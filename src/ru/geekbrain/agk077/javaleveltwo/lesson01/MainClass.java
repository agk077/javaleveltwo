package ru.geekbrain.agk077.javaleveltwo.lesson01;

/*
ДЗ урок 1 Java уровень 2 by agk077@ya.ru (tango!)
30.11.20
 */


import ru.geekbrain.agk077.javaleveltwo.lesson01.competitor.*;
import ru.geekbrain.agk077.javaleveltwo.lesson01.obstacle.*;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Obstacle[] obstacles = new Obstacle[3];
        Competitor[] competitors = new Competitor[3];

        // Заполняем массивы данных
        Random random = new Random();
        obstacles[0] = new Wall(random.nextInt(100));
        obstacles[1] = new Treadmill(random.nextInt(100));
        obstacles[2] = new Wall(random.nextInt(100));

        competitors[0] = new Cat("Барсик", random.nextInt(300), random.nextInt(300));
        competitors[1] = new Human("Владимир", random.nextInt(200), random.nextInt(200));
        competitors[2] = new Robot("Электроник", random.nextInt(50), random.nextInt(50));

        // Начинаем преодаление препятствий
        System.out.println("Go!\n");

        for (Competitor competitor:competitors
             ) {
            System.out.println("New round");
            boolean isPerformed = true;
            for (int i = 0; i < obstacles.length; i++) {
                if(!obstacles[i].moveThroughObstacle(competitor)) {
                    System.out.println(competitor + " выбывает из данного раунда.");
                    isPerformed = false;
                   break;
                }
            }
            if (isPerformed) System.out.println(competitor + " успешно преодалел все препятствия.");
            System.out.println("*************************************************************\n");
        }

    }
}
