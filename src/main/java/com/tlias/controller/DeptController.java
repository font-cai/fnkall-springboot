package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/depts")
    public Result list () {
        System.out.println("查询部门数据");
        List<Dept> deptList = deptService.findAll();
        System.out.println("查询部门数据成功"+Result.success(deptList));
       return Result.success(deptList);
    }
    @PostMapping("/api/v1/auth/login")
    public Result loginTest(){
        return Result.success();
    }
}
