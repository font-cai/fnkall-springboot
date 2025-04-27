package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list (String name) {
        log.info("查询部门数据"+name);
        List<Dept> deptList = deptService.findAll(name);
       return Result.success(deptList);
    }
    @PostMapping("/depts")
    public Result save(@RequestBody Dept dept) {
        System.out.println("保存部门数据"+dept.toString());
        String name = dept.getName();
        deptService.save(name);
        return Result.success();
    }
    @DeleteMapping("/depts")
    public Result delete(String id) {
//        deptService.deleteById(id);
        log.info("删除部门数据"+id);
        if (id == null || id.equals("")){
            return Result.error("缺少部门id");
        }
        List<Integer> idList = Arrays.stream(id.split(","))
                .map(item -> Integer.parseInt(item))
                .toList();
                deptService.deleteByIds(idList);
        return Result.success();
    }
    // 修改部门信息
    @PostMapping("/deptsById")
    public Result update(Dept dept) {
        System.out.println("修改部门数据"+dept);
        deptService.updateById(dept);
        return Result.success();
    }
}

