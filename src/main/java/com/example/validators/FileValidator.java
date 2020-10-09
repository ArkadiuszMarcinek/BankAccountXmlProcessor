package com.example.validators;

import com.example.dto.BankAccounts;
import com.example.xmlparser.BankAccountsXmlParser;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBException;
import java.io.File;

@NoArgsConstructor
public class FileValidator {
    private final XmlValidator xmlValidator = new XmlValidator();

    public BankAccounts inputFileValidation(String inputPath, BankAccountsXmlParser bankAccountsXmlParser) throws JAXBException {
        File file = new File(inputPath);
        if (xmlValidator.validateInputFile(file)) {
            final BankAccounts bankAccounts;
            bankAccounts = bankAccountsXmlParser.parseFrom(file);
            final AccountsValidator accountsValidator = new AccountsValidator();
            return accountsValidator.validate(bankAccounts);
        }
        throw new RuntimeException("Invalid input File");
    }
}