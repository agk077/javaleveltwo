package ru.geekbrain.agk077.javaleveltwo.lesson05;
/*
ДЗ урок 5 Java уровень 2 by agk077@ya.ru (tango!)
09.12.20
 */

public class MainClass {
    public static void method1() {

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        // засекаем время
        long a = System.currentTimeMillis();

        {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        // выводим разницу во времени
        System.out.printf("Время выполнения method 1: %d ms%n", (System.currentTimeMillis() - a));

    }

    public static void method2 () throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        // засекаем время
        long a = System.currentTimeMillis();

        {
            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }, "Поток 1");

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }, "Поток 2");

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
        }

        // выводим разницу во времени
        System.out.printf("Время выполнения method 2: %d ms%n", (System.currentTimeMillis() - a));
    }

    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();
    }
}
