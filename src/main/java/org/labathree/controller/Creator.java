package org.labathree.controller;

import org.jetbrains.annotations.NotNull;
import org.labathree.models.university.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Creator implements HumanCreator,StudentCreate, GroupCreate, DepartmentCreate,FacultyCreate{

    public  void createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator() {
            @Override
            public Human create(Human.Gender gender, String name, String lastName) {
                return HumanCreator.super.create(gender, name, lastName);
            }
        };

        StudentCreate studentCreate = new StudentCreate() {
            @Override
            public Student create(@NotNull Human person) {
                return StudentCreate.super.create(person);
            }
        };

        GroupCreate groupCreate = new GroupCreate() {
            @Override
            public Group create(List<Student> students, String name, Human boss) {
                return GroupCreate.super.create(students, name, boss);
            }
        };

        DepartmentCreate departmentCreate = new DepartmentCreate() {
            @Override
            public Department createDepartment(List<Group> groups, Human boss, String name) {
                return DepartmentCreate.super.createDepartment(groups, boss, name);
            }
        };

        FacultyCreate facultyCreate =new FacultyCreate() {
            @Override
            public Faculty create(List<Department> departments, Human boss, String facultyName) {
                return FacultyCreate.super.create(departments, boss, facultyName);
            }
        };

        List<Student> students = new ArrayList<>();
        List<Student> pupils = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        Random random = new Random();

        String[] Students_Name = {"Brian","Violet","Stefani","Bradley","Tom"};
        String[] Students_Lastname = {"Walker","Orlando","Germanotta","Cooper","Holland"};
        Integer[] Students_Gender = {0,1,1,0,0};
        for (int i = 0; i < 2; i++) {
            Human human = humanCreator.create(Human.Gender.values()[Students_Gender[i]],Students_Name[i],Students_Lastname[i]);
            Student student =  studentCreate.create(human);
            students.add(student);
        }
        for (int i = 2; i < Students_Name.length; i++) {
            Human human = humanCreator.create(Human.Gender.values()[Students_Gender[i]],Students_Name[i],Students_Lastname[i]);
            Student student =  studentCreate.create(human);
            pupils.add(student);
        }

        Human groupBoss1 = humanCreator.create(Human.Gender.values()[1],"Ganny","Grande");
        Human groupBoss2 = humanCreator.create(Human.Gender.values()[1],"Lily","Johanson");

        Group group1 = groupCreate.create(students,"122-20-1",groupBoss1);
        Group group2 = groupCreate.create(pupils,"122-19-3",groupBoss2);
        groups.add(group1);
        groups.add(group2);

        Human departmentBoss = humanCreator.create(Human.Gender.values()[0],"Trevor","Bacon");

        Department department = departmentCreate.createDepartment(groups,departmentBoss,"Department of compucter scince");
        departments.add(department);

        Human facultyBoss = humanCreator.create(Human.Gender.values()[0],"Cris","Gun");
        Faculty faculty = facultyCreate.create(departments,facultyBoss,"Faculty IT");



        faculty.getDepartments()
                .forEach(dep -> dep.getGroupList()
                        .forEach(gr -> gr.getStudents()
                                .forEach(st -> System.out.println(
                                        "| " +faculty.getName() + " -> " + faculty.getBoss().getName() + " " + faculty.getBoss().getLastName() + " " + faculty.getBoss().getGender()
                                                + " | " + dep.getName() + " -> " + dep.getBoss().getName() + " " + dep.getBoss().getLastName() + " " + dep.getBoss().getGender()
                                                + " | " + gr.getName() + " -> " + gr.getBoss().getName() + " " + gr.getBoss().getLastName() + " " + gr.getBoss().getGender()
                                                + " -- " + st.getLastName() + " " + st.getName() + " " + st.getGender()
                                ))));

    }
}
