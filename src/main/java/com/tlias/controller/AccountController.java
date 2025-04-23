package com.tlias.controller;


import com.tlias.pojo.Account;
import com.tlias.pojo.Result;
import com.tlias.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public Result save(Account account) {
        // 打印account里面的内容
        log.info("account: {}", account);
        String status = accountService.save(account);
        String msg = "注册成功";
        if (!Objects.equals(status, "10")) {
            msg = "注册失败";
            return Result.error(msg);
        }
        return Result.success(msg);
    }
    @PostMapping("/deleteregister")
    public Result deleteByName(String name) {
        log.info("name: {}", name);
        accountService.deleteByName(name);
        return Result.success();
    }
}
