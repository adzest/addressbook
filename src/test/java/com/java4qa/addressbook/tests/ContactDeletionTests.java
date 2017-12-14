package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import com.java4qa.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        int before = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("FirstNameData", "test_sername", "CompanyData", "test12"), true);
        }
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
