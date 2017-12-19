package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import com.java4qa.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(invocationCount = 10)
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().contactCreationPage();
    ContactData contact = new ContactData()
          .withFirstName("test_name").withLastName("test_surname").withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }
}
