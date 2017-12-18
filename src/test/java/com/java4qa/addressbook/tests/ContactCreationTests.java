package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().list();
        app.goTo().contactCreationPage();
        ContactData contact = new ContactData()
              .withFirstName("test_Name").withLastName("test_Surname").withGroup("test1");
        app.contact().create(contact, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
//        contact.withLastName(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getLastName());
//        contact.withGroup(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getGroup());
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
