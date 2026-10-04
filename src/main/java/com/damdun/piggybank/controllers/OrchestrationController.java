package com.damdun.piggybank.controllers;

import com.damdun.piggybank.models.Account;
import com.damdun.piggybank.services.AccountStoreClient;
import com.damdun.piggybank.models.Quote;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@Profile("quote-orchestrator")
@RestController
public class OrchestrationController {

    private final AccountStoreClient accountStoreClient;

    public OrchestrationController(AccountStoreClient accountStoreClient) {
        this.accountStoreClient = accountStoreClient;
    }

    @GetMapping(path = "/accounts/{accountId}/quotes/{effectiveDate}")
    public @ResponseBody Quote requestQuote(@PathVariable int accountId, @PathVariable LocalDate effectiveDate) throws IOException, InterruptedException {
        Account account = accountStoreClient.getAccount(accountId);

        long monthsSinceAccountOpening = Period.between(account.openedOn(), effectiveDate).toTotalMonths();

        return new Quote(
                new Quote.Parameters(
                        accountId,
                        effectiveDate
                ),
                monthsSinceAccountOpening * account.minimalContribution()
        );
    }
}

