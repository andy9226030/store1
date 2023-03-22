package com.store1.mapper;

import com.store1.entity.Address;

public interface AddressMapper {
    /**
     * 插入數據
     *
     * @param address
     * @return
     */
    Integer insert(Address address);

    /**
     * 查詢跟判斷
     *
     * @param
     * @return
     */
    Integer finyByAddress(Integer uid);

    /**
     * 查詢uid 返回address對象
     * 跟判斷是否有這個uid
     *
     * @param
     * @return
     */
    Address finy_Address(Integer uid);

   }
