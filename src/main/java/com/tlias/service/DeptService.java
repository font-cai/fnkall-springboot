package com.tlias.service;

import com.tlias.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll(String name);
    void save(String name);
    void deleteById(Integer id);

    void deleteByIds(List<Integer> ids);

    void updateById(Dept dept);
}
