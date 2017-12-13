package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test12", null, null));
        }
        app.getGroupHelper().modifyGroup(new GroupData("test12", null, "test13"));
    }
}
