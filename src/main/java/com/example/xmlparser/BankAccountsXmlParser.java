package com.example.xmlparser;

import com.example.dto.BankAccounts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BankAccountsXmlParser {

    public BankAccounts parseFrom(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BankAccounts.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (BankAccounts) unmarshaller.unmarshal(file);

    }

    public void parseTo(BankAccounts bankAccounts, String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(BankAccounts.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(bankAccounts, new File(path));
    }
}
