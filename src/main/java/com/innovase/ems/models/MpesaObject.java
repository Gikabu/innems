package com.innovase.ems.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MpesaObject {
    @JsonProperty("TransactionType")
    public String transactionType;
    @JsonProperty("TransID")
    public String transID;
    @JsonProperty("TransTime")
    public String transTime;
    @JsonProperty("TransAmount")
    public String transAmount;
    @JsonProperty("BusinessShortCode")
    public String businessShortCode;
    @JsonProperty("BillRefNumber")
    public String billRefNumber;
    @JsonProperty("InvoiceNumber")
    public String invoiceNumber;
    @JsonProperty("OrgAccountBalance")
    public String orgAccountBalance;
    @JsonProperty("ThirdPartyTransID")
    public String thirdPartyTransID;
    @JsonProperty("MSISDN")
    public String mSISDN;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("LastName")
    public String lastName;

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransID() {
        return transID;
    }

    public String getTransTime() {
        return transTime;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public String getBillRefNumber() {
        return billRefNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getOrgAccountBalance() {
        return orgAccountBalance;
    }

    public String getThirdPartyTransID() {
        return thirdPartyTransID;
    }

    public String getmSISDN() {
        return mSISDN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setThirdPartyTransID(String thirdPartyTransID) {
        this.thirdPartyTransID = thirdPartyTransID;
    }
}
