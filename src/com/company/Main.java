package com.company;

public class Main {

    public static void main(String[] args) {
        runTask1();
        runTask2();
    }

    //Задание 1.
    //Взять из прошлого урока создание массива людей и переделать массив на ArrayList. В консоли по нажатию
    //1 – создание нового человека. Необходимо ввести имя, возраст.
    //2 - вывод списка людей в очереди.
    //3 – удалить человека из очереди. Ну не дождался. Из консоли ввести еще номер человека из очереди.
    //4 – закончить программу.
    //Усиленная сложность: добавить возможность пропускать без очереди (в начало) стариков.
    //Добавить к человеку проверку на старика..
    private static void runTask1() {
        new QueueOfPersons("Программа управления очередью магазина Ромашка");
    }

    //Задание 2.
    //Создать лифт в который входят люди.
    //По нажатию 1 – добавить человека в лифт. Ввести имя и возраст.
    //По нажатию 2 – показать людей в лифте.
    //По нажатию 3 – вывести 1 человека из лифта (того кто стоит ближе всех к выходу).
    //По нажатию 4 – закончить программу.
    //Усложненный уровень: Добавить этаж на котором надо выйти и соответственно своевременную реструктуризацию.
    private static void runTask2() {
        new Lift("Программа управления очередью в лифте", false);
        new Lift("Программа управления очередью в лифте", true);
    }
}
