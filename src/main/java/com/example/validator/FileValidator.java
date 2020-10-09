package com.example.validator;

import com.example.AccountsValidator;
import com.example.dto.BankAccounts;
import com.example.xmlparser.BankAccountsXmlParser;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBException;
import java.io.File;
@NoArgsConstructor
public class FileValidator {
    private final BankAccountsXmlParser bankAccountsXmlParser = new BankAccountsXmlParser();
    private final XmlValidator xmlValidator = new XmlValidator();
    public BankAccounts inputFileValidation(String inputPath) {
        File file = new File(inputPath);
        if (xmlValidator.validateInputFile(file)) {

            final BankAccounts bankAccounts;
            try {
                bankAccounts = bankAccountsXmlParser.parseFrom(file);
            } catch (JAXBException e) {
                return null;
            }
            final AccountsValidator accountsValidator = new AccountsValidator();
            return  accountsValidator.validate(bankAccounts);
        }
        return null;
    }
}