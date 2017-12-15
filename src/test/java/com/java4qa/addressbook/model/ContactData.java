package com.java4qa.addressbook.model;

public class ContactData {
    private final String firstNameData;
    private final String lastNameData;
    private final String companyData;
    private String group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstNameData != null ? !firstNameData.equals(that.firstNameData) : that.firstNameData != null)
            return false;
        if (lastNameData != null ? !lastNameData.equals(that.lastNameData) : that.lastNameData != null) return false;
        if (companyData != null ? !companyData.equals(that.companyData) : that.companyData != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;
    }

    @Override
    public int hashCode() {
        int result = firstNameData != null ? firstNameData.hashCode() : 0;
        result = 31 * result + (lastNameData != null ? lastNameData.hashCode() : 0);
        result = 31 * result + (companyData != null ? companyData.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstNameData='" + firstNameData + '\'' +
                ", lastNameData='" + lastNameData + '\'' +
                ", companyData='" + companyData + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

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
