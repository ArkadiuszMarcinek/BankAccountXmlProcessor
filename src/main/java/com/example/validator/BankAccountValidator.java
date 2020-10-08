package com.example.validator;

import com.example.dto.BankAccount;
import com.example.predicates.BalancePredicate;
import com.example.predicates.ClosingDatePredicate;
import com.example.predicates.CurrencyPredicate;
import com.example.predicates.IbanPredicate;

import java.util.stream.Stream;

public class BankAccountValidator {

    private final BalancePredicate balancePredicate = new BalancePredicate();
    private final ClosingDatePredicate closingDatePredicate = new ClosingDatePredicate();
    private final IbanPredicate ibanPredicate = new IbanPredicate();
    private final CurrencyPredicate currencyPredicate = new CurrencyPredicate();

    public boolean isValid(BankAccount bankAccount) {
        return Stream.of(balancePredicate, closingDatePredicate, ibanPredicate, currencyPredicate)
                .allMatch(predicate -> predicate.test(bankAccount));
    }
}
