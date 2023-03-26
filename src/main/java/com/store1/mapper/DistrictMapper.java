package com.store1.mapper;

import com.store1.entity.District;

import java.util.List;

public interface DistrictMapper {
    /**
     * 查詢數據庫裡的位置
     *
     * @param
     * @return
     */
    List<District> findByParent(String parent);

    /**
     * @param code
     * @return
     */
    String findNameByCode(String code);
}
