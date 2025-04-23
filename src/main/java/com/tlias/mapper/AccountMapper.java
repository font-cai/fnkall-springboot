package com.tlias.mapper;

import com.tlias.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("select count(*) from account_number where name = #{name}")
    int countByName(String name);

    @Insert("insert into account_number(name, password) values (#{name}, #{password})")
    void save(Account account);

    @Insert("delete from account_number where name = #{name}")
    void deleteByName(String name);
}
