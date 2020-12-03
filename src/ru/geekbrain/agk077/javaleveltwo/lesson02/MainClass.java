package ru.geekbrain.agk077.javaleveltwo.lesson02;

/*
ДЗ урок 2 Java уровень 2 by agk077@ya.ru (tango!)
30.11.20
 */

import ru.geekbrain.agk077.javaleveltwo.lesson02.exception.MyArrayDataException;
import ru.geekbrain.agk077.javaleveltwo.lesson02.exception.MyArraySizeException;

import java.util.Random;

public class MainClass {

    private final static int ARRAY_SIZE = 4;

    public static int getSumFormArray(String[][] array) {
        int sum = 0;
        // проверяем размерность массива
        try {
            if (array.length == 4 && array[0].length == 4) {
                // Массив нам подходит - суммируем
                int i = 0, j = 0; // чтобы переменные попадали в область видимости блока catch
                try {
                    for (i = 0; i < array.length; i++) {
                        for (j = 0; j < array[0].length; j++) {
                            int data = new Integer(array[i][j]);
                            sum += data;
                        }
                    }
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("/В ячейке [" + i + "][" + j + "] неверные данные");
                }
            } else {
                // пробрасываем экспепшен MyArraySizeException
                throw new MyArraySizeException("/Неверная размерность массива");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Возможна ошибка при обращении к первому элементу массива
            // пробрасываем экспепшен MyArraySizeException
            throw new MyArraySizeException("/Неверная размерность массива");
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] stringArray = new String[ARRAY_SIZE][ARRAY_SIZE];

        // заполняем массив данными
        Random random = new Random();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[0].length; j++) {
                stringArray[i][j] = String.valueOf(random.nextInt(100));
                System.out.printf("[%2s]", stringArray[i][j]);
            }
            System.out.println();
        }

//      неверные тестовые данные
//       stringArray[1][1] = "iusf";
        try {
            System.out.println("Сумма значений в массив = " + getSumFormArray(stringArray));
        } catch (MyArraySizeException e) {
            System.out.println("Исключение: " + e.toString());
        } catch (MyArrayDataException e) {
            System.out.println("Исключение: " + e.toString());
        }

    }
}
