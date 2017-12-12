package com.java4qa.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test12", "test22", "test23"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
