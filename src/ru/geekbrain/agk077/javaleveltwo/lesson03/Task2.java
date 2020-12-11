package ru.geekbrain.agk077.javaleveltwo.lesson03;
/*
ДЗ урок 3 Java уровень 2 by agk077@ya.ru (tango!)
06.12.20
 */

import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Олег Крылов", "+7 499 123-45-56");
        phoneBook.addContact("Олег Крылов", "+7 495 123-45-56");
        phoneBook.addContact("Олег Крылов", "+7 495 123-45-56"); // Для теста
        phoneBook.addContact("Денис Прощенко", "+7 495 123-45-56");
        phoneBook.addContact("Кирилл Качалов", "+7 812 123-45-56");
        phoneBook.addContact("Максим Паньков", "N/A");

        Set<String> allSurnames = phoneBook.getNames();
        for (String surname : allSurnames) {
            Set<String> phones = phoneBook.getPhone(surname);
            System.out.printf("%s: %s%n", surname, phones);
        }
    }
}
