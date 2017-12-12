package com.java4qa.addressbook;

public class AddNewData {
    private final String firstNameData;
    private final String lastNameData;
    private final String addressData;
    private final String phoneHomeData;
    private final String phoneHomeData1;
    private final String phoneWorkData;
    private final String phoneMobileData;
    private final String phoneFaxData;
    private final String email2Data;
    private final String email3Data;
    private final String secondaryPhoneHomeData;

    public AddNewData(String firstNameData, String lastNameData, String addressData, String phoneHomeData, String phoneHomeData1, String phoneWorkData, String phoneMobileData, String phoneFaxData, String email2Data, String email3Data, String secondaryPhoneHomeData) {
        this.firstNameData = firstNameData;
        this.lastNameData = lastNameData;
        this.addressData = addressData;
        this.phoneHomeData = phoneHomeData;
        this.phoneHomeData1 = phoneHomeData1;
        this.phoneWorkData = phoneWorkData;
        this.phoneMobileData = phoneMobileData;
        this.phoneFaxData = phoneFaxData;
        this.email2Data = email2Data;
        this.email3Data = email3Data;
        this.secondaryPhoneHomeData = secondaryPhoneHomeData;
    }

    public String getFirstNameData() {
        return firstNameData;
    }

    public String getLastNameData() {
        return lastNameData;
    }

    public String getAddressData() {
        return addressData;
    }

    public String getPhoneHomeData() {
        return phoneHomeData;
    }

    public String getPhoneHomeData1() {
        return phoneHomeData1;
    }

    public String getPhoneWorkData() {
        return phoneWorkData;
    }

    public String getPhoneMobileData() {
        return phoneMobileData;
    }

    public String getPhoneFaxData() {
        return phoneFaxData;
    }

    public String getEmail2Data() {
        return email2Data;
    }

    public String getEmail3Data() {
        return email3Data;
    }

    public String getSecondaryPhoneHomeData() {
        return secondaryPhoneHomeData;
    }
}
