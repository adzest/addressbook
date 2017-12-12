package com.java4qa.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class AddNewTests extends TestBase {

    @Test
    public void testAddNew() {
        gotoAddNewPage();
        fillAddNewForm(new AddNewData("FirstNameData", "LastNameData", "CompanyData", "PhoneWorkData"));
        submitAddNew();
    }

    private void submitAddNew() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillAddNewForm(AddNewData addNewData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(addNewData.getFirstNameData());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(addNewData.getLastNameData());
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(addNewData.getCompanyData());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(addNewData.getPhoneWorkData());
    }

    private void gotoAddNewPage() {
        wd.findElement(By.linkText("ADD_NEW")).click();
    }
}
