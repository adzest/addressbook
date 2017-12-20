package com.java4qa.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("Convert2Diamond")
public class Groups extends ForwardingSet<GroupData>{

  private Set<GroupData> delegate;

  public Groups(Groups groups) {
    this.delegate = new HashSet<GroupData>(groups.delegate);
  }

  public Groups() {
    this.delegate = new HashSet<GroupData>();
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded (GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups withOut (GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

  //TODO: DONE - Chapter 5 video 6: create wthModified group method to Groups class.
  public Groups withModified (GroupData modifiedGroup,GroupData group){
    Groups groups = new Groups(this);
    groups.remove(modifiedGroup);
    groups.add(group);
    return groups;
  }
}
