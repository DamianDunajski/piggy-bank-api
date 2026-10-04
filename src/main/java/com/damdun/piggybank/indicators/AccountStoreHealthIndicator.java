package com.damdun.piggybank.indicators;

import com.damdun.piggybank.services.AccountStoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("quote-orchestrator")
@Component("account-store")
@RequiredArgsConstructor
public class AccountStoreHealthIndicator implements HealthIndicator {

    private final AccountStoreClient accountStoreClient;

    @Override
    public Health health() {
        try {
            return accountStoreClient.isHealthy() ? Health.up().build() : Health.down().build();
        } catch (Exception ex) {
            return Health.down().build();
        }
    }
}
