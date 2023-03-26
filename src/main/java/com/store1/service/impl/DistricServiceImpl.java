package com.store1.service.impl;

import com.store1.entity.District;
import com.store1.mapper.DistrictMapper;
import com.store1.service.IDistricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistricServiceImpl implements IDistricService {
    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 搜尋數據庫裡面的
     *
     * @param parent
     * @return
     */
    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
        for (District d : list) {
            d.setid(null);
            d.setparent(null);
        }
        return list;
    }

    /**
     * @param code
     * @return
     */
    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);


    }
}