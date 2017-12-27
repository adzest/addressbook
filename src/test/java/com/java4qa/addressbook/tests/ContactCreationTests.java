package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import com.java4qa.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.java4qa.addressbook.tests.GroupCreationTests.testGroupCreation;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SuppressWarnings("ALL")
public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    File photo = new File("src/test/resources/test.jpeg");
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname").withPhoto(photo);
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    //noinspection ConstantConditions
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreationWithGroup() {
//    TODO: add ensurePreconditions() for this test. Groups should be existed!
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname").withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    //noinspection ConstantConditions
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreationWithPones() {
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("test_name").withLast("test_surname").withHomePhone("111").withMobilePhone("222").withWorkPhone("333");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    //noinspection ConstantConditions
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreationWithOutGroup() {
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirst("name").withLast("surname").withCompanyAddress("companyAddress")
          .withHomePhone("+111").withMobilePhone("(22)2").withWorkPhone("3-3 3")
          .withEmail2("email@2").withEmail3("email@3");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    //noinspection ConstantConditions
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
