package com.java4qa.addressbook.model;

public class AddNewData {
    private final String firstNameData;
    private final String lastNameData;
    private final String companyData;
    private final String phoneWorkData;

    public AddNewData(String firstNameData, String lastNameData, String companyData, String phoneWorkData) {
        this.firstNameData = firstNameData;
        this.lastNameData = lastNameData;
        this.companyData = companyData;
        this.phoneWorkData = phoneWorkData;
     }

    public String getFirstNameData() {
        return firstNameData;
    }

    public String getLastNameData() {
        return lastNameData;
    }

    public String getCompanyData() {
        return companyData;
    }

    public String getPhoneWorkData() {
        return phoneWorkData;
    }
}
