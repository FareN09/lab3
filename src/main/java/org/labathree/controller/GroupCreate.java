package org.labathree.controller;

import org.labathree.models.university.Group;
import org.labathree.models.university.Human;
import org.labathree.models.university.Student;

import java.util.List;


public interface GroupCreate {
    default Group create(List<Student> students, String name,Human boss){
        Group group = new Group();
        group.setBoss(boss);
        group.setName(name);
        group.setStudents(students);
        return group;
    }
}
