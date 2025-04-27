package com.tlias.mapper;

import com.tlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    void save(String name);

    void deleteById(Integer id);
    void deleteByIds(List<Integer> ids);

    void updateById(Dept dept);

    List<Dept> findAll(String name);
}
