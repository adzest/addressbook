package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import com.java4qa.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test()
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test()
  public void testContactCreationWithGroup() {
//    TODO: add ensurePreconditions() for this test. Groups should be existed!
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname").withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test()
  public void testContactCreationWithPones() {
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname").withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
