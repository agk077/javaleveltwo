package ru.geekbrain.agk077.javaleveltwo.lesson03;
/*
ДЗ урок 3 Java уровень 2 by agk077@ya.ru (tango!)
06.12.20
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, Set<String>> contacts;

    public PhoneBook() {
        this.contacts = new TreeMap<>();
    }

    public void addContact(String name, String phone) {
        Set<String> phones = getPhones(name);
        if (!phones.add(phone)) {
            System.err.println("Не уникальное значение пары: name = \'" + name + "\', phone = \'" + phone + "\'");
        };
    }

    private Set<String> getPhones(String name) {
        Set<String> phones = contacts.getOrDefault(name, new HashSet<>());
        if (phones.isEmpty()) {
            contacts.put(name, phones);
        }
        return phones;
    }

    public Set<String> getPhone(String name) {
        return getPhones(name);
    }

    public Set<String> getNames() {
        return contacts.keySet();
    }
}
