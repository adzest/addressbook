package com.java4qa.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String companyAddress;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email;
  private String email2;
  private String email3;
  private String group;
  private String allPhones;
  private String allEmails;
  private String contactDetails;
  private File photo;

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public ContactData withFirst(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public ContactData withLast(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobile;
    return this;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public ContactData withCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail2() {
    return email2;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getContactDetails() {
    return contactDetails;
  }

  public ContactData withContactDetails(String details) {
    this.contactDetails = details;
    return this;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
          "id=" + id +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", companyAddress='" + companyAddress + '\'' +
          ", homePhone='" + homePhone + '\'' +
          ", mobilePhone='" + mobilePhone + '\'' +
          ", workPhone='" + workPhone + '\'' +
          ", email='" + email + '\'' +
          ", email2='" + email2 + '\'' +
          ", email3='" + email3 + '\'' +
          ", group='" + group + '\'' +
          ", allPhones='" + allPhones + '\'' +
          ", allEmails='" + allEmails + '\'' +
          ", contactDetails='" + contactDetails + '\'' +
          ", photo=" + photo +
          '}';
  }
}
