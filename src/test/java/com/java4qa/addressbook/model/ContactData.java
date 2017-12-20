package com.java4qa.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String lastName;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String group;
  private String allPhones;

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

  public String getGroup() {
    return group;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", homePhone='" + homePhone + '\'' +
          ", mobilePhone='" + mobilePhone + '\'' +
          ", workPhone='" + workPhone + '\'' +
          ", group='" + group + '\'' +
          '}';
  }

  //  @Override
//  public String toString() {
//    return "ContactData{" +
//          "firstName='" + firstName + '\'' +
//          ", lastName='" + lastName + '\'' +
//          '}';
//
//  }

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


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
}
