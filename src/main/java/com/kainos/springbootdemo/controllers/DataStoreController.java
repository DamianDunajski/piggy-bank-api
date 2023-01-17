package com.kainos.springbootdemo.controllers;

import com.kainos.springbootdemo.models.Account;
import com.kainos.springbootdemo.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Profile("account-store")
@RestController
@RequiredArgsConstructor
@Slf4j
public class DataStoreController {

    private final AccountRepository accountRepository;

    @GetMapping(path = "/accounts/{id}")
    public @ResponseBody Account getAccount(@PathVariable long id) {
        return accountRepository.findById(id).orElseThrow();
    }

}

