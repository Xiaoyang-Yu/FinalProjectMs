package com.management.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String username;
    public List<Attributes> AttriList = new ArrayList<>();
    public String Recipe;

    public Person() {}

    public Person(String username) {
        this.username = username;
    }

    public Person set(String AttriName, int score) {
        this.AttriList.add(new Attributes(AttriName, score));
        return this;
    }

    public Attributes find(String AttriName) {
        for (Attributes attr : AttriList) {
            if (attr.AttriName.equals(username)) {
                return attr;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
