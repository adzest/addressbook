package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.GroupData;
import com.java4qa.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void insurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
              .withId(modifiedGroup.getId()).withName("test1_mod").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
        //TODO:DONE - Chapter 5 video 6: replace 2 methodes with one withModified.
        assertThat(after, equalTo(before.withModified(modifiedGroup, group)));
    }
}
