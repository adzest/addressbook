package com.java4qa.addressbook.tests;

import com.java4qa.addressbook.model.GroupData;
import com.java4qa.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test0").withHeader("header").withFooter("footer")});
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header").withFooter("footer")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header").withFooter("footer")});
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> inValidGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test'").withHeader("header").withFooter("footer")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public static void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    //noinspection ConstantConditions
    assertThat(after, equalTo(
          before.withAdded(group.withId(after.stream().mapToInt(GroupData::getId).max().getAsInt()))));
  }

  @Test(dataProvider = "inValidGroups")
  public void testBadGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }

}
