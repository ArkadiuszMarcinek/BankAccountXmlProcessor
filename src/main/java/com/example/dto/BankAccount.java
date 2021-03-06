package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccount {

    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @XmlAttribute(name = "iban")
    @Getter
    private String iban;
    @XmlElement
    @Getter
    private String name;
    @XmlElement
    @Getter
    private String currency;
    @XmlElement
    @Getter
    private BigDecimal balance;
    @XmlElement
    private String closingDate;


    public LocalDate getClosingDate() {
        return Optional.ofNullable(closingDate)
                .filter(this::isValidData)
                .map(date -> LocalDate.parse(date, DATE_TIME_FORMATTER))
                .orElse(LocalDate.MIN);
    }

    private boolean isValidData(String data) {
        try {
            DATE_TIME_FORMATTER.parse(data);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


}
