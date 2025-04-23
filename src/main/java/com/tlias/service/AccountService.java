package com.tlias.service;

import com.tlias.pojo.Account;

public interface AccountService {
    String save(Account account);
    void deleteByName(String name);
}
