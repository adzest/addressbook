package com.java4qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
    private ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) {
        this.wd = wd;
    }


    public void gotoGroupPage() {
        wd.findElement(By.linkText("GROUPS")).click();
    }

    public void gotoAddNewPage() {
        wd.findElement(By.linkText("ADD_NEW")).click();
    }
}
