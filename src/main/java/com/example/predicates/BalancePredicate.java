package com.example.predicates;

import com.example.dto.BankAccount;

import java.math.BigDecimal;
import java.util.Optional;

public class BalancePredicate implements IBankAccountPredicate {

    @Override
    public boolean test(BankAccount bankAccount) {
        return Optional.ofNullable(bankAccount)
                .map(BankAccount::getBalance)
                .map(BigDecimal::signum)
                .map(integer -> integer >= 0)
                .orElse(false);
    }
}
