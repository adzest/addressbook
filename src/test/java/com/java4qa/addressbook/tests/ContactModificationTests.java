package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationPage();
      app.getContactHelper().createContact(new ContactData("testFN", "test_LN", "test_Comp", "test1"), true);
    }
  }

  @Test(enabled = false)
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(), "FirstNameData", "test_sername", "CompanyData", "test12");

    app.getContactHelper().modifyContact(index, contact, false);

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
