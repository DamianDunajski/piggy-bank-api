package com.kainos.springbootdemo.controllers;

import com.kainos.springbootdemo.models.Account;
import com.kainos.springbootdemo.models.Quote;
import com.kainos.springbootdemo.services.DataStoreClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
@Slf4j
public class OrchestrationController {

    private final DataStoreClient dataStoreClient;

    @GetMapping(path = "/accounts/{accountId}/quotes/{effectiveDate}")
    public @ResponseBody Quote requestQuote(@PathVariable int accountId, @PathVariable LocalDate effectiveDate) throws IOException, InterruptedException {
        Account account = dataStoreClient.getAccount(accountId);

        long monthsSinceAccountOpening = Period.between(account.getOpenedOn(), effectiveDate).toTotalMonths();

        return Quote.builder()
                .withParameters(Quote.Parameters.builder()
                        .withAccountId(accountId)
                        .withEffectiveDate(effectiveDate)
                        .build())
                .withEstimatedSavingsAmount(monthsSinceAccountOpening * account.getMinimalContribution())
                .build();
    }
}

