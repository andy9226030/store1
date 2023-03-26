package com.store1.Service;

import com.store1.entity.Address;
import com.store1.entity.District;
import com.store1.service.IAddressService;
import com.store1.service.IDistricService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DistricTest {
    @Autowired
    private IDistricService districService;

    @Test
    public void getByParent() {
        List<District> list = districService.getByParent("86");
        for (District district : list) {
            System.err.println(district);

        }
    }

    @Test
    public void getNameByCode() {
        String s = districService.getNameByCode("110109");
        System.out.println(s);
    }
}
