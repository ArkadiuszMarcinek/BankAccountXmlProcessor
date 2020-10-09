package com.example;

import com.example.dto.BankAccounts;
import com.example.validators.FileValidator;
import com.example.validators.XmlValidator;
import com.example.xmlparser.BankAccountsXmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.util.Scanner;


public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        final BankAccountsXmlParser bankAccountsXmlParser = new BankAccountsXmlParser();
        final FileValidator fileValidator = new FileValidator();
        final XmlValidator xmlValidator = new XmlValidator();
        final BankAccounts validateBankAccounts = new BankAccounts();
        Scanner scan = new Scanner(System.in);
        LOGGER.info("sciezka do pliku xml:");
        String inputPath = scan.nextLine();
        try {
            fileValidator.inputFileValidation(inputPath, bankAccountsXmlParser);
            LOGGER.info("validacja zakonczona, podaj katalog do zapisu zwalidowanego pliku xml: ");
            String outputPath = scan.nextLine();
            if (!xmlValidator.validateOutputPath(outputPath)) {
                LOGGER.info("podaj poprawny katalog");
                outputPath = scan.nextLine();
            }
            outputPath += System.getProperty("file.separator") + "output.xml";
            bankAccountsXmlParser.parseTo(validateBankAccounts, outputPath);
        } catch (JAXBException ex) {
            LOGGER.error("JAXB Exception", ex);
        }
    }
}
