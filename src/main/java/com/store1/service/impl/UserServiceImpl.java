package com.store1.service.impl;

import com.store1.entity.User;
import com.store1.mapper.UserMapper;
import com.store1.service.IUserService;
import com.store1.service.ex.*;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //判斷帳號是否被註冊過 沒有被註冊過就讓他註冊 如果有就跟他說已經被註冊過了
        String username = user.getUsername();//獲取使用者輸入的帳號
        User result = userMapper.FinyByUsername(username); //判斷使用者帳號是否被註冊過
        if (result != null) {  //把結果丟進去作比較 如果為true就用user的方式把資料丟進去
            throw new UsernameException("用戶名被佔用");
        }
        //獲取使用者輸入的密碼
        String oldPassowrd = user.getPassword();
        //使用uuid獲取隨機的鹽值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //自己寫一個加密方法
        String newpassword = MD5Password(oldPassowrd, salt);
        //加密完成必須把鹽值存下來
        user.setSalt(salt);
        //把舊密碼跟新密碼做替換
        user.setPassword(newpassword);

        // 設定插入數據庫的時間
        Date date = new Date();
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(date);
        //設定插入數據庫的時間

        //做插入的動作把使用者輸入的存到insert裡面
        Integer user1 = userMapper.insert(user);

        if (user1 != 1) {
            throw new InsertException("插入異常");
        }
    }

    public String MD5Password(String password, String salt) {
        for (int i = 1; i <= 10; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

    @Override
    public User Login(String username, String password) {
        User Login_Username = userMapper.FinyByUsername(username);
        if (Login_Username == null) {
            throw new UsernameNotException("沒有這個帳號");
        }
        String oldPassowrd = Login_Username.getPassword();
        String salt = Login_Username.getSalt();
        String Login_Password = MD5Password(password, salt);

        if (!oldPassowrd.equals(Login_Password)) {
            throw new PasswordException("用戶密碼錯誤");
        }
        if (Login_Username.getIsDelete() == 1) {
            throw new UsernameNotException("沒有這個帳號");
        }
        User user = userMapper.FinyByUsername(username);
        user.setUid(Login_Username.getUid());
        user.setUsername(Login_Username.getUsername());
        user.setPassword(Login_Username.getPassword());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldpassword, String newpassword) {
//      判斷數據庫是否有這個帳號的uid
        User reult = userMapper.finyByUid(uid);
//      如果查詢不到就返回null的結果我們就會知道數據庫裡面沒有這個帳號的uid就拋出異常
        if (reult == null || reult.getIsDelete() == 1) {
            throw new UsernameNotException("沒有這個帳號");
        }
//        如果能到這裡就代表數據庫裡面有這個帳號
//        這裡要做使用輸入的密碼跟之前的鹽值做組合加密在跟數據庫裡面的密碼做比較
        String Md5oldpassword = MD5Password(oldpassword, reult.getSalt());
        if (!Md5oldpassword.equals(reult.getPassword())) {
            throw new PasswordException("密碼不符合");
        }
        String newMD5Password = MD5Password(newpassword, reult.getSalt());
        Integer updata = userMapper.updataPasswordByuid(uid, newMD5Password, username, new Date());
        if (updata != 1) {
            throw new UpdataException("更改密碼失敗");
        }
    }

    @Override
    public User getuid(Integer uid) {
        User result = userMapper.finyByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotException("未找到帳號");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeINfo(Integer uid, String username, User user) {
        User result = userMapper.finyByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotException("未找到帳號");
        }
        user.setUid(uid);
        user.getUsername();
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.userdata(user);
        if (rows != 1) {
            throw new UpdataException("更新數據時產生未知的錯誤");
        }

    }

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        //判斷uid是否有這個帳號
        User result = userMapper.finyByUid(uid);
        //判斷帳號是否符合條件
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotException("未找到帳號");
        }
        Integer updata = userMapper.updataAvater(uid, avatar, username, new Date());
        if (updata!=1){
            throw new AvatarException("上傳失敗");
        }
    }
}


