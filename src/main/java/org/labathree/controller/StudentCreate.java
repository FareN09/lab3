package org.labathree.controller;

import org.labathree.models.university.Human;
import org.labathree.models.university.Student;



public interface StudentCreate {

    default Student create(Human person){
        Student newStudent = new Student();
        newStudent.setName(person.getName());
        newStudent.setLastName(person.getLastName());
        newStudent.setGender(person.getGender());

        return newStudent;
    }



}
