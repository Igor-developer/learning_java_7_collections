package com.company;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int floor;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isOldMen() {
        return age > 65;
    }

    @Override
    public int compareTo(Person o) {
        return this.getFloor() - o.getFloor();
    }

    @Override
    public String toString() {
        return getName()
                + (age != 0 ? " (" + getAge() + " лет)" : "")
                + (floor != 0 ? ", (этаж " + floor + ")" : "");
    }
}
