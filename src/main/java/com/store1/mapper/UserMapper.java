package com.store1.mapper;

import com.store1.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

//@Mapper
public interface UserMapper {
    /**
     * Insert Username and passowrd
     *
     * @return
     */
    Integer insert(User user);

    /**
     * select username
     *
     * @return
     */
    User FinyByUsername(String username);

    /**
     * 修改密碼
     *
     * @return
     */
    Integer updataPasswordByuid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 查詢uid
     *
     * @param uid
     * @return
     */
    User finyByUid(Integer uid);

    /**
     * 新增個人資料
     *
     * @param user
     * @return
     */
    Integer userdata(User user);

    /** 修改圖片
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     * @return
     */
    Integer updataAvater(@Param("uid") Integer uid,
                         @Param("avatar") String avatar,
                         @Param("modifiedUser") String modifiedUser,
                         @Param("modifiedTime") Date modifiedTime);
}

