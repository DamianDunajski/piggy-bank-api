package com.kainos.springbootdemo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kainos.springbootdemo.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Profile("quote-orchestrator")
@Service
public class DataStoreClient {
    private final ObjectMapper objectMapper;

    private final String accountStoreURI;

    public DataStoreClient(ObjectMapper objectMapper, @Value("${application.account-store-uri}") String accountStoreURI) {
        this.objectMapper = objectMapper;
        this.accountStoreURI = accountStoreURI;
    }

    public Account getAccount(long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(accountStoreURI + "/accounts/" + id))
                .GET()
                .build();
        String accountJson = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();
        return objectMapper.readValue(accountJson, Account.class);
    }
}
