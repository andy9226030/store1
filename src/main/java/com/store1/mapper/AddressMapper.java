package com.store1.mapper;

import com.store1.entity.Address;

public interface AddressMapper {
    /**
     * @param address
     * @return
     */
    Integer insert(Address address);

    /**
     * @param
     * @return
     */
    Integer finyByAddress(Integer uid);

    /**
     * 查詢uid 返回address對象
     * @param
     * @return
     */
    Address getAddress1(Integer uid);
}
