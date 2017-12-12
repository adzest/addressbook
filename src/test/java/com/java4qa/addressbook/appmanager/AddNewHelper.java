package com.java4qa.addressbook.appmanager;

import com.java4qa.addressbook.model.AddNewData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewHelper {
    private ChromeDriver wd;

    public AddNewHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void submitAddNew(ApplicationManager app) {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillAddNewForm(AddNewData addNewData) {
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
}
