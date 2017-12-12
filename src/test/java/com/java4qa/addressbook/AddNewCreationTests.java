package com.java4qa.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class AddNewCreationTests extends BeginWebTest {

    @Test
    public void NewContactCreationTests() {
        gotoAddNewPage();
        fillAddNewForm(new AddNewData("FirstNameData", "LastNameData", "AddressData", "PhoneHomeData", "PhoneHomeData", "PhoneWorkData", "PhoneMobileData", "PhoneFaxData", "email2Data@mail.com", "email3Data@mail.com", "SecondaryPhoneHomeData"), "MiddleNameData", "NickNameData", "TitleData", "CompanyData", "HomePageData", "//div[@id='content']/form/select[1]//option[3]", "//div[@id='content']/form/select[1]//option[3]", "//div[@id='content']/form/select[2]//option[2]", "//div[@id='content']/form/select[2]//option[2]", "2017", "//div[@id='content']/form/select[3]//option[4]", "//div[@id='content']/form/select[3]//option[4]", "//div[@id='content']/form/select[4]//option[3]", "//div[@id='content']/form/select[4]//option[3]", "2017", "SecondaryAddressData", "SecondaryNotesData");
        submitAddNew();
    }

    private void submitAddNew() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillAddNewForm(AddNewData addNewData, String middleNameData, String nickNameData, String titleData, String companyData, String homePageData, String birthDayFildXLocator, String birthDayData, String birthMonthFildXLocator, String birthMonthData, String birthYearData, String anniversaryDayFildXLocator, String firstFebDay, String anniversaryMonthFildXLocator, String anniversaryMonthData, String anniversaryYearData, String secondaryAddressData, String secondaryNotesData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(addNewData.getFirstNameData());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(middleNameData);
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(addNewData.getLastNameData());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(nickNameData);
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(titleData);
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(companyData);
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(addNewData.getAddressData());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(addNewData.getPhoneHomeData());
        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(addNewData.getPhoneWorkData());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(addNewData.getPhoneMobileData());
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(addNewData.getPhoneFaxData());
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(addNewData.getEmail2Data());
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(addNewData.getEmail3Data());
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(homePageData);
        if (!wd.findElement(By.xpath(birthDayFildXLocator)).isSelected()) {
            wd.findElement(By.xpath(birthDayData)).click();
        }
        if (!wd.findElement(By.xpath(birthMonthFildXLocator)).isSelected()) {
            wd.findElement(By.xpath(birthMonthData)).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(birthYearData);
        if (!wd.findElement(By.xpath(anniversaryDayFildXLocator)).isSelected()) {
            wd.findElement(By.xpath(firstFebDay)).click();
        }
        if (!wd.findElement(By.xpath(anniversaryMonthFildXLocator)).isSelected()) {
            wd.findElement(By.xpath(anniversaryMonthData)).click();
        }
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(anniversaryYearData);
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(secondaryAddressData);
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(addNewData.getSecondaryPhoneHomeData());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(secondaryNotesData);
    }

    private void gotoAddNewPage() {
        wd.findElement(By.linkText("ADD_NEW")).click();
    }
}
