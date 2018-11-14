package com.bb.myfragments;

public class Person {
    private String name;
    private double weight;
    private int age;
    private boolean isMale;

    public Person(String name, double weight, int age, boolean isMale) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }
}
