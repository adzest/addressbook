package com.java4qa.addressbook.appmanager;

import com.java4qa.addressbook.model.AddNewData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewHelper extends HelperBase{

    public AddNewHelper(ChromeDriver wd) {
        super(wd);
    }

    public void fillAddNewForm(AddNewData addNewData) {
        type(By.name("firstname"), addNewData.getFirstNameData());
        type(By.name("lastname"), addNewData.getLastNameData());
        type(By.name("company"), addNewData.getCompanyData());
        type(By.name("work"), addNewData.getPhoneWorkData());
    }

    public void submitAddNew(ApplicationManager app) {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }
}
