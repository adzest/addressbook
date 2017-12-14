package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test12", null, null));
        }
        app.getGroupHelper().selectGroup(before -1);
        app.getGroupHelper().modifyGroup(new GroupData("test12", null, "test13"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before );
    }
}
