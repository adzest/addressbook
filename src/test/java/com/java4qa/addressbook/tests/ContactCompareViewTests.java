package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCompareViewTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationPage();
      //TODO: Add Data without Group field to the Contact
      app.contact().create(new ContactData()
            .withFirst("name").withLast("surname").withCompanyAddress("companyAddress")
            .withHomePhone("+111").withMobilePhone("(22)2").withWorkPhone("3-3 3")
            .withEmail2("email@2").withEmail3("email@3"),
            true);
    }
  }

  @Test
  public void testContactCompare () {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactDetailsPage = app.contact().infoFromDetailsPage(contact);
    ContactData edit = contactInfoFromEditForm
          .withAllEmails(mergePhones(contactInfoFromEditForm)).withAllEmails(mergeEmails(contactInfoFromEditForm));
    ContactData details = contactDetailsPage
          .withAllEmails(mergePhones(contactDetailsPage)).withAllEmails(mergeEmails(contactDetailsPage));
//    System.out.println("edit: " + edit);
//    System.out.println("details: " + details);
    assertThat(edit, equalTo(details));
  }

//  public ContactData merge(ContactData contact) {
//    String mergedPhones = Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
//          .filter((s) -> !s.equals(""))
//          .map(ContactCompareViewTests::cleaned)
//          .collect(Collectors.joining("\n"));
//    String mergedEmails = Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
//          .filter((s) -> !s.equals(""))
//          .map(ContactCompareViewTests::cleaned)
//          .collect(Collectors.joining("\n"));;
//    return new ContactData().withId(contact.getId())
//          .withFirst(contact.getFirstName()).withLast(contact.getLastName()).withCompanyAddress(contact.getCompanyAddress())
//          .withAllPhones(mergedPhones).withAllEmails(mergedEmails)
//          .withGroup(contact.getGroup());
//  }
}
