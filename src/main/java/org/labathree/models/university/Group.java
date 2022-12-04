package org.labathree.models.university;

import java.util.List;

public class Group{
    private String name;
    private Human boss;
    private
    List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
