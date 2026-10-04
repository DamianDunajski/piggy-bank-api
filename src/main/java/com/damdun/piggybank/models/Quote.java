package com.damdun.piggybank.models;

import java.time.LocalDate;

public record Quote(Parameters parameters, double estimatedSavingsAmount) {
    public record Parameters(long accountId, LocalDate effectiveDate) {}
}
