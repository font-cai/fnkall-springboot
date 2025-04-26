package com.tlias.service.impl;

import com.tlias.mapper.DeptMapper;
import com.tlias.pojo.Dept;
import com.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll(String name) {
        return deptMapper.findAll(name);
    }

    @Override
    public void save(String name) {
        deptMapper.save(name);
    }
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }
    @Override
    public void updateById(Dept dept) {
        deptMapper.updateById(dept);
    }
}
