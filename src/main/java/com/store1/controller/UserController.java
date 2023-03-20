package com.store1.controller;

import com.store1.Util.JsonResult;
import com.store1.controller.ex.*;
import com.store1.entity.Address;
import com.store1.entity.User;
import com.store1.service.IAddressService;
import com.store1.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IAddressService addressService;

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/Login")
    public JsonResult<User> Login(String username, String password, HttpSession session) {
        User data = iUserService.Login(username, password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        System.out.println(getuidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/updataPassword")
    public JsonResult<Void> upDataPassword(HttpSession session, String oldPassword, String newPassword) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        iUserService.changePassword(uid, username, oldPassword, newPassword);

        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/get_by_uid")
    public JsonResult<User> getByuid(HttpSession session) {
        Integer uid1 = getuidFromSession(session);
        User data = iUserService.getuid(uid1);
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String user1 = getUsernameFromSession(session);
        iUserService.changeINfo(uid, user1, user);
        return new JsonResult<Void>(OK);
    }

    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpgs");
        AVATAR_TYPE.add("image/PNG");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
        AVATAR_TYPE.add("image/jpg");
        AVATAR_TYPE.add("image/jpeg");
    }

    @RequestMapping("/change_avatar")
    public JsonResult<String> updataAVAtar(HttpSession session,
                                           @RequestParam("file") MultipartFile file) {
        //判斷是否為空
        if (file.isEmpty()) {
            throw new FileEmptyException("請加入檔案");
        }
        //判斷檔案大小
        if (file.getSize() >= AVATAR_MAX_SIZE) {
            throw new FileSizeException("檔案過大");

        }
        //判斷檔案類型
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("未支持該檔案類型");
        }
        //獲得一個upload的名稱
        String parent = session.getServletContext().getRealPath("upload");
        //使用這個file類 建立一個upload的資料夾
        File dir1 = new File(parent);
        //判斷資料夾是否存在
        if (!dir1.exists()) {
            //不存在就建立
            dir1.mkdirs();
        }
        //獲得MultipartFile file 真實的路徑
        String originalFilename = file.getOriginalFilename();
        //做打印的動作
        System.out.println("OriginalFilename" + originalFilename);
        //獲得真實照片名稱然後通過判斷把.以後的檔名擷取下來
        Integer index = originalFilename.lastIndexOf(".");
        //獲取到照片的名稱.以後的名稱做輸出的動作
        String suffix = originalFilename.substring(index);
        //然後使用UUID這個亂數的生成 如果需要數字可以使用Math.random
        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;
        //在使用file 把資料存在file裡面 dir1現在已經被建立了 ,在把上面亂數生成的自除串丟進去file裡面
        File dest = new File(dir1, filename);
        try {
            //把dest 建立的物件傳送到 MultipartFile這個物件中
            file.transferTo(dest);
        } catch (FileStateException e) {
            //拋出異常
            throw new FileStateException("文件狀態異常");
        } catch (IOException e) {
            //拋出異常
            throw new FileUploadIOException("文件讀寫異常");
        }
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        //存在filename的資料做拼湊 之後回傳
        String avatar = "/upload/" + filename;
        System.out.println(avatar);
        //獲取資練完做存取的動作
        iUserService.changeAvatar(uid, username, avatar);
        //然後回傳
        return new JsonResult<>(OK, avatar);
    }

    @RequestMapping("/AddNewAddress")
    public JsonResult<Address> AddNewAddress(HttpSession session, Address address) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewaddress(address, uid, username);
        return new JsonResult<Address>(OK);
    }
}
