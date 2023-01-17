package com.kainos.springbootdemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public class Account {
    @Id
    Long id;
    LocalDate openedOn;
    double minimalContribution;
}
