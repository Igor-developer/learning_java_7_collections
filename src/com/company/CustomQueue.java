package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CustomQueue {
    String programName;
    List<Person> persons;
    boolean isStack; //для уменьшения количества кода при добавлении Person в List

    CustomQueue(String programName) {
        this.programName = programName;
        persons = new ArrayList<>();

        System.out.println("Вас приветствует \"" + programName + "\"!");
    }

    //Запуск командной строки
    void runCommandLine() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите комманду (help для вызова справки):");
            String command = sc.nextLine().trim().toLowerCase();
            switch (command) {
                case "help":
                    help();
                    break;
                case "1":
                    addPerson(isStack ? 0 : persons.size());
                    break;
                case "2":
                    displayQueue();
                    break;
                case "3":
                    removePerson();
                    break;
                case "4":
                    System.out.println(programName + " завершена.\n");
                    return;
                default:
                    System.out.println("Комманда \"" + command + "\" не распознана, повторите ввод:");
            }
        }
    }

    //Вывод справки
    void help() {
        System.out.println("help - вывести данную справку;\n" +
                "1 – добавить человека в очередь;\n" +
                "2 - вывести список людей в очереди;\n" +
                "3 – удалить человека из очереди;\n" +
                "4 – завершить программу.");
    }

    //Создание нового Person
    abstract Person createPerson() throws IllegalStateException;

    //Добавление Person в очередь
    void addPerson(int index) {
        try {
            Person person = createPerson();
            persons.add(index, person);
            System.out.println(person + " добавлен.");
        } catch (IllegalStateException e) {
            System.out.println("Неверный ввод!");
        }
    }

    //Отображение очереди
    void displayQueue() {
        if (persons.isEmpty()) {
            System.out.println("Нет людей.");
            return;
        }

        System.out.println("Порядок людей:");
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((i + 1) + " - " + persons.get(i) + (persons.size() - 1 == i ? "." : ";"));
        }
    }

    //Удаление Person
    abstract void removePerson();

    //Ввод имени Person
    String inputPersonName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя человека:");

        return sc.nextLine().trim();
    }

}