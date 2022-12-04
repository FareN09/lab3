package org.labathree.controller;

import org.labathree.models.university.Department;
import org.labathree.models.university.Faculty;
import org.labathree.models.university.Human;


import java.util.List;


public interface FacultyCreate {

    default Faculty create(List<Department> departments, Human boss, String facultyName) {
        Faculty faculty = new Faculty();
        faculty.setBoss(boss);
        faculty.setDepartments(departments);
        faculty.setName(facultyName);

        return faculty;

    }
}
