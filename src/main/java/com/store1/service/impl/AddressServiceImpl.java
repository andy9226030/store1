package com.store1.service.impl;

import com.store1.entity.Address;
import com.store1.mapper.AddressMapper;
import com.store1.mapper.DistrictMapper;
import com.store1.service.IAddressService;
import com.store1.service.IDistricService;
import com.store1.service.ex.AddressCountLimitException;
import com.store1.service.ex.NoGetAddredss;
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
    @Autowired
    private IDistricService districService;
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
        //利用code的文字來尋找返回name的名字封裝成String
        String provinceName = districService.getNameByCode(address.getProvinceCode());
        String cityName = districService.getNameByCode(address.getCityCode());
        String areaName = districService.getNameByCode(address.getAreaCode());
        //把得到的名子傳進去name裡面
        System.out.println(address.getProvinceCode());
        System.out.println(address.getCityCode());
        System.out.println(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);
        //把利用code存進code欄位
        address.setProvinceCode(address.getProvinceCode());
        address.setAreaCode(address.getAreaCode());
        address.setCityCode(address.getCityCode());

        //1代表設定為默認值 0代表不設定
        Integer isDefault = UserUid == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        address.setUid(uid);
        //顯示時間
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
}

