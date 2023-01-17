package com.kainos.springbootdemo.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
public class Quote {
    Parameters parameters;
    double estimatedSavingsAmount;

    @Data
    @Builder(setterPrefix = "with")
    public static class Parameters {
        long accountId;
        LocalDate effectiveDate;
    }
}
