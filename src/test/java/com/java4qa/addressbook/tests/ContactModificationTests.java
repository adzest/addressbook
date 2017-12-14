package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
    @Test
    public void testGroupModification() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("FirstNameData", "test_sername", "CompanyData", "test12"), true);
        }
        app.getContactHelper().modifyContact(new ContactData("FirstNameData", "test_sername", "CompanyData", "test12"), false);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
