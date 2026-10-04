package com.damdun.piggybank.indicators;

import com.damdun.piggybank.services.AccountStoreClient;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("quote-orchestrator")
@Component("account-store")
public class AccountStoreHealthIndicator implements HealthIndicator {

    private final AccountStoreClient accountStoreClient;

    public AccountStoreHealthIndicator(AccountStoreClient accountStoreClient) {
        this.accountStoreClient = accountStoreClient;
    }

    @Override
    public Health health() {
        try {
            return accountStoreClient.isHealthy() ? Health.up().build() : Health.down().build();
        } catch (Exception ex) {
            return Health.down().build();
        }
    }
}
