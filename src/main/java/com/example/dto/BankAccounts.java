package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccounts {

    @XmlElement(name = "account")
    private List<BankAccount> bankAccounts;
}
