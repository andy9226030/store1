package com.store1.service;

import com.store1.entity.Address;
import jakarta.servlet.http.HttpSession;

public interface IAddressService {
    /**
     * @param address
     * @param uid
     * @param Username
     */
    void addNewaddress(Address address, Integer uid, String Username);


}
