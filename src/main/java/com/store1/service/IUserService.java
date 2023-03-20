package com.store1.service;

import com.store1.entity.User;

import java.util.Date;

public interface IUserService {
    /**
     * 註冊方法
     *
     * @param user 利用對象方式
     */
    void reg(User user);

    /**
     * @param username 用戶名
     * @param password 密碼
     * @return
     */
    User Login(String username, String password);

    /**
     * 修改密碼
     *
     * @param uid          判斷帳號是否存在
     * @param username     為了數據庫的修改名稱
     * @param oldpassword  舊密碼
     * @param newpassword1 跟新密碼
     */
    void changePassword(Integer uid, String username, String oldpassword, String newpassword1);

    /**
     * @param uid 將後端資料往前端傳
     * @return
     */
    User getuid(Integer uid);

    /**
     * @param uid      判斷帳號
     * @param username 用於切換畫面顯示在前端的數據
     * @param user     用於輸入數據 所以使用USER
     */
    void changeINfo(Integer uid, String username, User user);

    /**
     * 更換照片
     * @param uid
     * @param username
     * @param avatar
     */
    void changeAvatar(Integer uid, String username, String avatar);
}
