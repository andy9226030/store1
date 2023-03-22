package com.store1.controller;

import com.store1.Util.JsonResult;
import com.store1.controller.ex.FileUpladException;
import com.store1.service.ex.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    public static final int OK = 200;

    /**
     * @param e
     * @return
     */
    @ExceptionHandler({ServiceException.class, FileUpladException.class})
    public JsonResult<Void> Handler(Throwable e) {
        JsonResult<Void> result = new JsonResult(e);
        if (e instanceof UsernameException) {
            result.setState(400);
            result.setMessage("帳號已被註冊");
        } else if (e instanceof UsernameNotException) {
            result.setState(401);
            result.setMessage("沒有這個帳號");
        } else if (e instanceof PasswordException) {
            result.setState(401);
            result.setMessage("密碼錯誤");
        } else if (e instanceof InsertException) {
            result.setState(403);
            result.setMessage("插入異常");
        } else if (e instanceof UpdataException) {
            result.setState(404);
            result.setMessage("修改密碼失敗");
        } else if (e instanceof AvatarException) {
            result.setState(405);
            result.setMessage("頭像上傳失敗");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(406);
            result.setMessage("超過最大限制");
        } else if (e instanceof  GetNotAddres) {
            result.setState(407);
            result.setMessage("查詢不到資料");

        }
        return result;
    }

    /**
     * @param session session對象
     * @return 獲取登入用戶的uid的值
     */
    protected final Integer getuidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * @param session
     * @return 獲取當前的用戶username的值
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

}
