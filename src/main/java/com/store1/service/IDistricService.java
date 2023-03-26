package com.store1.service;

import com.store1.entity.District;

import java.util.List;

public interface IDistricService {
    /**
     *
     * @param
     * @return
     */
    List<District> getByParent(String parent);

    /**
     *
     * @param code
     * @return
     */
    String getNameByCode(String code);
}
