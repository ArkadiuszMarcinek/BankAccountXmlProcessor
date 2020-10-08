import com.example.dto.BankAccount;
import com.example.dto.BankAccounts;
import com.example.validator.BankAccountValidator;

import java.util.Comparator;
import java.util.stream.Collectors;

public class AccountsValidator {

    private final BankAccountValidator bankAccountValidator = new BankAccountValidator();

    public BankAccounts validate(BankAccounts bankAccounts) {
        return new BankAccounts(bankAccounts.getBankAccounts().stream()
                .filter(bankAccountValidator::isValid)
                .sorted(Comparator.comparing(BankAccount::getName))
                .collect(Collectors.toList()));
    }
}
