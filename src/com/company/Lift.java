package com.company;

import java.util.*;

public class Lift extends CustomQueue {
    private boolean reorganization; //указывает нужно ли людям в лифте перестраиваться в порядке выхода на этажах

    public Lift(String programName, boolean reorganization) {
        super(programName);
        this.reorganization = reorganization;
        isStack = true;

        System.out.println("Люди в лифте " + (reorganization ? "" : "не ") + "построены в порядке выхода на этажах.");

        runCommandLine();
    }

    //Ввод этажа Person из консоли
    private int inputPersonFloor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите этаж, на котором человек выходит:");

        return Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    Person createPerson() {
        Person person = new Person();
        person.setName(inputPersonName());
        person.setFloor(inputPersonFloor());

        return person;
    }

    @Override
    void displayQueue() {
        if (reorganization) {
            Collections.sort(persons);  //построение людей в порядке выхода из лифта
        }

        super.displayQueue();
    }

    @Override
    void removePerson() {
        displayQueue();

        if (!persons.isEmpty()) {
            System.out.println(persons.remove(0) + ", принудительно удалён из лифта.");
        }

    }
}