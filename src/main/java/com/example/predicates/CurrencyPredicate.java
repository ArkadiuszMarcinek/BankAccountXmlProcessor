package com.example.predicates;

import com.example.dto.BankAccount;

import java.util.Optional;

public class CurrencyPredicate implements IBankAccountPredicate {

    @Override
    public boolean test(BankAccount bankAccount) {
        return Optional.ofNullable(bankAccount)
                .map(BankAccount::getCurrency)
                .map("PLN"::equals)
                .orElse(false);
    }
}
