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

    //    @Override
    public List<District> getParent(String Parent) {
//        List<District> list= districtMapper.findByParent("110100");
//        for (int i = 0; i < ; i++) {
        return null;

    }
//    }
}
