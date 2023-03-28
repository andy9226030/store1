package com.store1.controller;

import com.store1.Util.JsonResult;
import com.store1.entity.District;
import com.store1.service.IDistricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("district")
public class DistrictController extends BaseController {
    @Autowired
    private IDistricService districService;

    @RequestMapping({"/", ""})
    public JsonResult<List<District>> getByparent(String parent) {
        List<District> data = districService.getByParent(parent);
        System.out.println(parent);
        return new JsonResult(OK, data);
    }

}
