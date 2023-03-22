package com.store1.service.impl;

import com.store1.entity.Address;
import com.store1.mapper.AddressMapper;
import com.store1.service.IAddressService;
import com.store1.service.ex.AddressCountLimitException;
import com.store1.service.ex.UsernameNotException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper userAddress;
    //在配置裡注入的方式管理
    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewaddress(Address address, Integer uid, String Username) {
        //判斷這個uid在數據庫裡面有多少條住址
        Integer UserUid = userAddress.finyByAddress(uid);
        //判斷這個uid在數據庫裡面有多少條如果大於等於50就跟他說超過最大數沒有則繼續執行
        if (UserUid >= maxCount) {
            throw new AddressCountLimitException("住址超過最大限制");
        }
//        address.setName(address.getName());
//        address.setProvinceCode(address.getProvinceCode());
        address.setCityName(address.getProvinceCode());
//        address.setCityCode(address.getCityCode());
//        address.setAreaCode(address.getAreaCode());
        address.setAreaName(address.getAreaCode());
//        address.setZip(address.getZip());
//        address.setAddress(address.getAddress());
//        address.setPhone(address.getPhone());
//        address.setTel(address.getTel());
//        address.setTag(address.getTag());
        //1代表設定為默認值 0代表不設定
        Integer isDefault = UserUid == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        address.setUid(uid);
//        顯示時間
        Date date = new Date();
        address.setCreatedUser(Username);
        address.setCreatedTime(date);
        address.setModifiedUser(Username);
        address.setModifiedTime(date);
        Integer address1 = userAddress.insert(address);
        if (address1 != 1) {
            System.out.println("插入失敗");
        }
    }

    /**
     * 返回傳送用戶地址
     *
     * @param uid
     * @return
     */
    @Override
    public Address GetAddress(Integer uid) {
        Address address = userAddress.finy_Address(uid);
        if (address == null) {
            throw new UsernameNotException("沒有此帳號");
        }
        Address address1 = new Address();
        if (address ==null){

        }else {
            address1.setName(address.getName());
            address1.setProvinceCode(address.getProvinceCode());
            address1.setCityName(address.getProvinceCode());
            address1.setCityCode(address.getCityCode());
            address1.setAreaCode(address.getAreaCode());
            address1.setAreaName(address.getAreaCode());
            address1.setZip(address.getZip());
            address1.setAddress(address.getAddress());
            address1.setPhone(address.getPhone());
            address1.setTel(address.getTel());
            address1.setTag(address.getTag());
        }
        return address1;
    }
}

