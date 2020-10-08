package com.example.predicates;

import com.example.dto.BankAccount;

import java.time.LocalDate;
import java.util.Optional;

public class ClosingDatePredicate implements IBankAccountPredicate {

    @Override
    public boolean test(BankAccount bankAccount) {
        return Optional.of(bankAccount)
                .map(BankAccount::getClosingDate)
                .map(LocalDate.now()::isBefore)
                .orElse(false);
    }
}
