package com.store1.Service;

import com.store1.entity.Address;
import com.store1.service.IAddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressTest {
    @Autowired
    private IAddressService iAddressService;

    @Test
    public void insert() {
        Address address = new Address();
        address.setProvinceCode("qwfpkqf");
        address.setCityName("wdkqwkd");
        address.setCityCode("apfkpflkq");
        address.setAreaCode("owkdawk");
        address.setAreaName("owqkdpqwl");
        address.setZip("dpkqdwl");
        address.setAddress("qwokfpqf");
        address.setPhone("pfkwqfpkqwf");
        address.setTel("dkoqdkqw");
        address.setTag("wpfkqpfwqf");
        iAddressService.addNewaddress(address, 20, "admin");
    }
}
