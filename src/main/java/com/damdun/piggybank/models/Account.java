package com.damdun.piggybank.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Account(@Id Long id, LocalDate openedOn, double minimalContribution) {}
