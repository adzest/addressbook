package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreationPage();
        ContactData contact = new ContactData("test_Name",null,null,"test1");

        app.getContactHelper().createContact( contact,true);

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.setLastName(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getLastName());
        contact.setGroup(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getGroup());
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparing(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
