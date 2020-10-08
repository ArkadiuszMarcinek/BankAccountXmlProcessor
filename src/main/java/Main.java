import com.example.dto.BankAccounts;
import com.example.validator.XmlValidator;
import com.example.xmlparser.BankAccountsXmlParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Scanner;


public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final XmlValidator xmlValidator = new XmlValidator();
        Scanner scan = new Scanner(System.in);
        LOGGER.info("sciezka do pliku xml:");
        String inputPath = scan.nextLine();
        File file = new File(inputPath);
        if (xmlValidator.validateInputFile(file)) {
            try {
                final BankAccountsXmlParser bankAccountsXmlParser = new BankAccountsXmlParser();
                final BankAccounts bankAccounts = bankAccountsXmlParser.parseFrom(file);
                final AccountsValidator accountsValidator = new AccountsValidator();
                final BankAccounts validateBankAccounts = accountsValidator.validate(bankAccounts);
                LOGGER.info("validacja zakonczona, podaj sciezke do zapisu zwalidowanego pliku xml: ");
                String outputPath = scan.nextLine();
                if (!xmlValidator.validateOutputPath(outputPath))
                    outputPath = scan.nextLine();
                outputPath+=System.getProperty("file.separator")+"output.xml";
                bankAccountsXmlParser.parseTo(validateBankAccounts, outputPath);
            } catch (JAXBException e) {
                LOGGER.error("JAXB Exception", e);
            }
        }
    }


}
