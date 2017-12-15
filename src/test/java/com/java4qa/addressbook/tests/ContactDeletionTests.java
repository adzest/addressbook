package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecoditions(){
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationPage();
      app.getContactHelper().createContact(new ContactData("FirstNameData", "test_sername", "CompanyData", "test12"), true);
    }
  }

  @Test(enabled = false)
  public void testContactDeletion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;

    app.getContactHelper().deleteContact(index);
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
