package com.kainos.springbootdemo.repositories;

import com.kainos.springbootdemo.models.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Profile("account-store")
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
