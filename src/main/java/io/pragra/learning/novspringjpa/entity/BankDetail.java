package io.pragra.learning.novspringjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bankDetailId;
    private String accountNumber;
    private String bankName;

    @Override
    public String toString() {
        return "BankDetail{" +
                "bankDetailId=" + bankDetailId +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }

    public Integer getBankDetailId() {
        return bankDetailId;
    }

    public void setBankDetailId(Integer bankDetailId) {
        this.bankDetailId = bankDetailId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
