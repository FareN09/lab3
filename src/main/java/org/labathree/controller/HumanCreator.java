package org.labathree.controller;

import org.labathree.models.university.Human;

public interface HumanCreator {
    default Human create(Human.Gender gender, String name, String lastName){
        Human human = new Human();
        human.setGender(gender);
        human.setName(name);
        human.setLastName(lastName);
        return human;
    }
}
