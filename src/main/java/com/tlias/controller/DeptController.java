package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list () {
        System.out.println("查询部门数据");
        List<Dept> deptList = deptService.findAll();
        System.out.println("查询部门数据成功"+Result.success(deptList));
       return Result.success(deptList);
    }
    @PostMapping("/depts")
    public Result save(String name) {
        System.out.println("保存部门数据"+name);
        deptService.save(name);
        return Result.success();
    }
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("删除部门数据"+id);
        deptService.deleteById(id);
        return Result.success();
    }
    // 修改部门信息
    @PostMapping("/deptsById")
    public Result update(Dept dept) {
        System.out.println("修改部门数据"+dept);
        deptService.updateById(dept);
        return Result.success();
    }
//    @PostMapping("/api/v1/auth/login")
//    public Result loginTest(){
//        return Result.success();
//    }
}
