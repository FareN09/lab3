package org.labathree.controller;

import org.labathree.models.university.Department;
import org.labathree.models.university.Group;
import org.labathree.models.university.Human;

import java.util.List;

public interface DepartmentCreate {
    default Department createDepartment(List<Group> groups,Human boss, String name){
        Department department = new Department();
        department.setBoss(boss);
        department.setName(name);
        department.setGroupList(groups);
        return department;
    }
}
