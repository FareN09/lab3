package org.labathree.models.university;

import java.util.List;

public class Department  {
    private String name;
    private Human boss;
    private List<Group> GroupList;

    public Human getBoss() {
        return boss;
    }

    public void setBoss(Human boss) {
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return GroupList;
    }

    public void setGroupList(List<Group> groupList) {
        GroupList = groupList;
    }

}
