package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().all().size() == 0) {
      app.goTo().contactCreationPage();
      //TODO: Add Phone number to the contact
      app.contact().create(new ContactData()
            .withFirstName("test_name").withLastName("test_sername").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactPhones(){
    //TODO: DONE - add check is there are any contact?
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
//    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
