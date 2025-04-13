package com.tlias.mapper;

import com.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, UNIX_TIMESTAMP(create_time) as createTime, UNIX_TIMESTAMP(update_time) as updateTime  from dept order by update_time desc")
    List<Dept> findAll();
}
