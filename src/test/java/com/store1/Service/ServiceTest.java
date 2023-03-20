package com.store1.Service;

import com.store1.entity.User;
import com.store1.service.IUserService;
import com.store1.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {
    @Autowired
    private IUserService iUserService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("test005");
            user.setPassword("test");
            user.setEmail("andy922603032@gmail.com");
            user.setPhone("0901727398");
            user.setGender(1);
            iUserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

    @Test
    public void Login() {
        User user = iUserService.Login("test001", "test");
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        iUserService.changePassword(19, "管理員", "qwe", "qwe1");


    }

    @Test
    public void getuid() {
        System.err.println(iUserService.getuid(12));
    }

    @Test
    public void changeINfo() {
        User user = new User();
        user.setEmail("andy922603032@gmail.com");
        user.setPhone("0901727398");
        user.setGender(1);
        iUserService.changeINfo(12, "管理員", user);
    }

    @Test
    public void changeAvatar() {
        iUserService.changeAvatar(29, "admin", "/updata/Avatar");
    }
}
