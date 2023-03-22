package com.store1.maaper;

import com.store1.entity.District;
import com.store1.mapper.DistrictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class districtMapper {
    @Autowired
    private DistrictMapper districtMapper;


    /**
     * 測試獲取t_distpicker數據庫獲取parter是否正常
     */
    @Test
    public void FindByParent() {
        List<District> list = districtMapper.findByParent("110100");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
