package com.store1.maaper;

import com.store1.entity.Address;
import com.store1.mapper.AddressMapper;
import org.apache.catalina.util.ToStringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAddressTest {
    @Autowired
    private AddressMapper userAddress;

    @Test
    public void inset() {
        Address address = new Address();
        address.setUid(22);
        address.setName("qweqwe");
        address.setProvinceCode("aspdkakpd");
        address.setCityName("oqfkqofk");
        address.setCityCode("ofojfqjpwf");
        address.setAreaName("papfkapk");
        address.setAreaCode("pakfpakf");
        address.setZip("fqofqkp");
        address.setAddress("pfkqwfqpf");
        address.setPhone("pfkwpkf");
        address.setTag("pfkfpk");
        address.setTel("pkwgkwgpk");

        address.setCreatedUser(address.getCreatedUser());
        address.setCreatedTime(address.getCreatedTime());
        address.setModifiedTime(address.getModifiedTime());
        address.setModifiedUser(address.getModifiedUser());

        Integer address1 = userAddress.insert(address);
        System.out.println(address1);
    }

    @Test
    public void finyByAddress() {
        Integer uid = 12;
        Integer address = userAddress.finyByAddress(uid);
        System.out.println(address);
    }

    @Test
    public void getAddresss() {
//        try {
            Address address = userAddress.getAddress1(28);
            System.out.println(address);
//        }catch (MyBatisSystemException e){
//            e.getMessage();
//        }
    }
}