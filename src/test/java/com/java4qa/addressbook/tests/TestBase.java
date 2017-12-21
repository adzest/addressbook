package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.appmanager.ApplicationManager;
import com.java4qa.addressbook.model.ContactData;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  public static String cleaned(String contactFiled) {
    return contactFiled.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

  public String mergePhones(ContactData contact) {
    return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
          .filter((s) -> !s.equals(""))
          .map(TestBase::cleaned)
          .collect(Collectors.joining("\n"));
  }

  public String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
          .filter((s) -> !s.equals(""))
          .map(TestBase::cleaned)
          .collect(Collectors.joining("\n"));
  }
}
