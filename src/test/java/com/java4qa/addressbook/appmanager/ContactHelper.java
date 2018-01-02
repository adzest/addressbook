package com.java4qa.addressbook.appmanager;

import com.java4qa.addressbook.model.ContactData;
import com.java4qa.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactModification() {
    click(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img"));
  }

  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//     wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  private void initContactDetailsPageById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    if (contactData.getPhoto() != null) {
      attach(By.name("photo"), new File(contactData.getPhoto()));
    }
    type(By.name("address"), contactData.getCompanyAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    if (creation) {
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
      Assert.assertTrue(isElementPresent(By.name("new_group")));
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact, boolean creation) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, creation);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    contactCache = null;
    submitContactDeletion();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String surname = cells.get(1).getText();
      String name = cells.get(2).getText();
      String companyAddress = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      contactCache.add(new ContactData()
            .withId(id).withFirst(name)
            .withLast(surname)
            .withCompanyAddress(companyAddress)
            .withAllPhones(allPhones)
            .withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String name = wd.findElement(By.name("firstname")).getAttribute("value");
    String surname = wd.findElement(By.name("lastname")).getAttribute("value");
    String companyAddress = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
          .withFirst(name).withLast(surname).withCompanyAddress(companyAddress)
          .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
          .withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  public ContactData infoFromDetailsPage(ContactData contact) {
    initContactDetailsPageById(contact.getId());
    String details = wd.findElement(By.id("content")).getAttribute("innerText");
    System.out.println(details);
    String[] rows = details.split("\n");
    String name = rows[0].split(" ")[0];
    String surname = rows[0].split(" ")[1];
    String address = rows[1];
//    String empty = rows[2];
    String home = rows[3].split("H: ")[1];
    String mobile = rows[4].split("M: ")[1];
    String work = rows[5].split("W: ")[1];
//    String empty = rows[6];
    String email = rows[7].split(" ")[0];
    String email2 = rows[8].split(" ")[0];
    String email3 = rows[9].split(" ")[0];
//    System.out.println(home);
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
          .withFirst(name).withLast(surname).withCompanyAddress(address)
          .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
          .withEmail(email).withEmail2(email2).withEmail3(email3);
  }

//  private Contacts contactWithPhoneCache = null;
//
////  public Contacts allWithPhones() {
////    if (contactWithPhoneCache != null) {
////      return new Contacts(contactWithPhoneCache);
////    }
////    List<WebElement> rows = wd.findElements(By.name("entry"));
////    for (WebElement row : rows) {
////      List<WebElement> cells = row.findElements(By.tagName("td"));
////      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
////      String surname = cells.get(1).getText();
////      String name = cells.get(2).getText();
////      String[] phones = cells.get(5).getText().split("\n");
////      contactWithPhoneCache.add(new ContactData()
////            .withId(id)
////            .withFirst(name)
////            .withLast(surname)
////            .withHomePhone(phones[0])
////            .withMobilePhone(phones[1])
////            .withWorkPhone(phones[2]));
////    }
////    return new Contacts(contactWithPhoneCache);
////  }
}
