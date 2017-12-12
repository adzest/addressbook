package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.AddNewData;
import org.testng.annotations.Test;

public class AddNewTests extends TestBase {

    @Test
    public void testAddNew() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getAddNewHelper().fillAddNewForm(new AddNewData("FirstNameData", "LastNameData", "CompanyData", "PhoneWorkData"));
        app.getAddNewHelper().submitAddNew(app);
    }

}
