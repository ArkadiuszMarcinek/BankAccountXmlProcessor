package com.example.predicates;

import com.example.dto.BankAccount;
import org.apache.commons.validator.routines.IBANValidator;

import java.util.Optional;

public class IbanPredicate implements IBankAccountPredicate {

    private final IBANValidator ibanValidator = IBANValidator.getInstance();

    @Override
    public boolean test(BankAccount bankAccount) {
        return Optional.ofNullable(bankAccount)
                .map(BankAccount::getIban)
                .map(ibanValidator::isValid)
                .orElse(false);
    }
}
