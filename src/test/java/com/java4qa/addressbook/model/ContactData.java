package com.java4qa.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private String lastName;
  private final String company;
  private String group;

  public ContactData(String firstName, String lastName, String company, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.group = group;
  }

  public ContactData(int id, String firstName, String lastName, String company, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCompany() {
    return company;
  }

  public String getGroup() {
    return group;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", group='" + group + '\'' +
          '}';
  }

}
