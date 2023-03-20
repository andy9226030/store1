package com.store1.maaper;

import com.store1.entity.User;
import com.store1.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMappertests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("adsdndy");
        user.setPassword("appsle");

        Integer username = userMapper.insert(user);
        System.out.println(username);
    }

    @Test
    public void FinyByUsername() {
        User return1 = userMapper.FinyByUsername("test005");
        System.out.println(return1);
    }

    @Test
    public void updataPasswordByuid() {
        Integer updata = userMapper.updataPasswordByuid(25, "test1", "test001", new Date());
        System.out.println(updata);
    }

    @Test
    public void finyByUid() {

        User uid = userMapper.finyByUid(30);
        System.out.println(uid);
    }

    @Test
    public void userdata() {
        User user = new User();
        user.setUid(20);
        user.setPhone("34567u8iop");
        user.setEmail("andy219323@gmail.com");
        user.setGender(1);
        Integer updata = userMapper.userdata(user);
        System.out.println(updata);
    }

    @Test
    public void updataAvater() {
        Integer avatar = userMapper.updataAvater(28, "/updata/avatar", "admin", new Date());
        System.out.println(avatar);
    }
}
