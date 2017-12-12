package com.java4qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("GROUPS"));
    }

    public void gotoAddNewPage() {
        click(By.linkText("ADD_NEW"));
    }
}
