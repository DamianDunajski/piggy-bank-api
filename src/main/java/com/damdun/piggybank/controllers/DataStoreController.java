package com.damdun.piggybank.controllers;

import com.damdun.piggybank.models.Account;
import com.damdun.piggybank.repositories.AccountRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Profile("account-store")
@RestController
public class DataStoreController {

    private final AccountRepository accountRepository;

    public DataStoreController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(path = "/accounts/{id}")
    public @ResponseBody Account getAccount(@PathVariable long id) {
        return accountRepository.findById(id).orElseThrow();
    }

}

