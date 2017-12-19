package com.java4qa.addressbook.appmanager;

import com.java4qa.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void create(ContactData contact, boolean creation) {
    fillContactForm(contact, creation);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact, boolean creation) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, creation);
    submitContactModification();
    returnToHomePage();
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
  }

  public void initContactModification() {
    click(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    submitContactDeletion();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("#maintable > tbody > tr:nth-child(2) > td:nth-child(8) > a > img"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getAttribute("innerText");
      String surname = element.findElement(By.cssSelector("td:nth-child(2)")).getAttribute("innerText");
      contacts.add(new ContactData().withId(id).withFirstName(name).withLastName(surname));
    }
    return contacts;
  }

}

