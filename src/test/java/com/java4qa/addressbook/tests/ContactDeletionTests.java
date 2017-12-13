package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}
