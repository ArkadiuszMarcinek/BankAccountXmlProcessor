package com.example;

import com.example.validator.FileValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.util.Scanner;


public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        FileValidator fileValidator = new FileValidator();
        Scanner scan = new Scanner(System.in);
        LOGGER.info("sciezka do pliku xml:");
        String inputPath = scan.nextLine();
        fileValidator.inputFileValidation(inputPath);
        LOGGER.info("validacja zakonczona, podaj sciezke do zapisu zwalidowanego pliku xml: ");
        String outputPath = scan.nextLine();
        if (!xmlValidator.validateOutputPath(outputPath))
            outputPath = scan.nextLine();
        outputPath += System.getProperty("file.separator") + "output.xml";
        bankAccountsXmlParser.parseTo(validateBankAccounts, outputPath);
    }
}
