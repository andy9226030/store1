package com.store1.service;

import com.store1.entity.District;

import java.util.List;

public interface IDistricService {
    List<District> getParent(String Parent);
}
