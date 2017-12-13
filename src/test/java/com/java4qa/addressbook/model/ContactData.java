package com.java4qa.addressbook.model;

public class ContactData {
    private final String firstNameData;
    private final String lastNameData;
    private final String companyData;
    private String group;

    public ContactData(String firstNameData, String lastNameData, String companyData, String group) {
        this.firstNameData = firstNameData;
        this.lastNameData = lastNameData;
        this.companyData = companyData;
        this.group = group;
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

    public String getGroup() {
        return group;
    }
}
