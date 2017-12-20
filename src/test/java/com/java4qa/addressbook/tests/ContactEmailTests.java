package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactEmail() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    System.out.println(contact.getAllEmails());
    System.out.println(mergeEmails(contactInfoFromEditForm));
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
          .filter((s) -> !s.equals(""))
          .map(ContactEmailTests::cleaned)
          .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "");
  }
}
