package com.tlias.service.impl;

import com.tlias.mapper.AccountMapper;
import com.tlias.pojo.Account;
import com.tlias.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public String save(Account account) {
        int count = accountMapper.countByName(account.getName());
        if (count > 0) {
            return "20";
        }
         accountMapper.save(account);
        return "10";
    }
    @Override
    public void deleteByName(String name) {
        accountMapper.deleteByName(name);
    }
}
