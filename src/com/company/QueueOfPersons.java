package com.company;

import java.util.Scanner;

public class QueueOfPersons extends CustomQueue {

    public QueueOfPersons(String programName) {
        super(programName);
        isStack = false;

        runCommandLine();
    }

    //Ввод возраста Person из консоли
    private int inputPersonAge() throws IllegalStateException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите возраст человека:");
        int age = Integer.parseInt(sc.nextLine().trim());
        if (age < 0) {
            throw new IllegalStateException();
        } else {
            return age;
        }

    }

    @Override
    Person createPerson() throws IllegalStateException {
        Person person = new Person();
        person.setName(inputPersonName());
        person.setAge(inputPersonAge());

        return person;
    }

    @Override
    void addPerson(int index) {
        super.addPerson(index);
        sortByElderly();
    }

    @Override
    void removePerson() {
        displayQueue();

        if (!persons.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер человека, которого нужно удалить из очереди:");
            int removed_index = Integer.parseInt(sc.nextLine()) - 1;

            if (removed_index > persons.size() - 1 || removed_index < 0) {
                System.out.println("Неверный ввод!");
                return;
            }

            System.out.println(persons.remove(removed_index) + " удалён из очереди," +
                    " добавьте нового человека на освободившееся место.");

            addPerson(removed_index);  //добавление нового Person вместо ушедшего
        }

    }

    //Пропуск стариков вперёд
    private void sortByElderly() {
        boolean isNotSorted = true;

        for (int n = 0; isNotSorted; n++) {
            isNotSorted = false;

            for (int i = 0; i + 1 < persons.size() - n; i++) {
                Person p1 = persons.get(i);
                Person p2 = persons.get(i + 1);
                if (!p1.isOldMen() && p2.isOldMen()) {
                    persons.set(i, p2);
                    persons.set(i + 1, p1);
                    isNotSorted = true;
                }
            }

        }

    }

}