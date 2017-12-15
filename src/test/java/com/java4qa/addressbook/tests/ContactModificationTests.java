package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactCreationPage();
      app.getContactHelper().createContact(new ContactData("testFN", "test_LN", "test_Comp", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "FirstNameData", "test_sername", "CompanyData", "test12");
    app.getContactHelper().modifyContact(contact, false);
    List<ContactData> after = app.getContactHelper().getContactList();
//    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
