package ru.geekbrain.agk077.javaleveltwo.lesson03;

/*
ДЗ урок 3 Java уровень 2 by agk077@ya.ru (tango!)
06.12.20
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniqWords {
    static String[] monthsArr = {
            "январь",
            "февраль",
            "март",
            "март",
            "апрель",
            "май",
            "июнь",
            "июль",
            "август",
            "август",
            "август",
            "август",
            "август",
            "сентябрь",
            "октябрь",
            "ноябрь",
            "ноябрь",
            "ноябрь",
            "декабрь" };

    // Task 1: Создаём массив набора слов, вывести уникальный список с указанием частоты с которой слова встречаются

    public static void main(String[] args) {
        Map<String, Integer> monthsMap = new HashMap<>();
        for (String month: monthsArr) {
            Integer freq = monthsMap.get(month);
            if (freq == null) freq = 0;
            monthsMap.put(month, ++freq);
        }
//        System.out.println(monthsMap);
        monthsMap.forEach((month, freq) -> {
            System.out.println("Месяц \'" + month + "\'" + " встречается " + freq + " раз");
        });

    }
}
