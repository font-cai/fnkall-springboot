package com.tlias.mapper;

import com.tlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
//    @Select("select id, name, UNIX_TIMESTAMP(create_time) as createTime, UNIX_TIMESTAMP(update_time) as updateTime  from dept where name = #{name}  order by update_time desc")
//    List<Dept> findAll(String name);
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, now(), now())")
    void save(String name);
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    @Update("update dept set name = #{name}, update_time = now() where id = #{id}")
    void updateById(Dept dept);

    List<Dept> findAll(String name);
}
