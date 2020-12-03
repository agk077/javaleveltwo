package ru.geekbrain.agk077.javaleveltwo.lesson01.obstacle;

import ru.geekbrain.agk077.javaleveltwo.lesson01.competitor.Competitor;

public class Treadmill implements Obstacle {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean moveThroughObstacle(Competitor competitor) {
        if (competitor.run() >= length) {
            System.out.println("Участник " + competitor + " успешно пробежал " + length + " метров.");
            return true;
        } else {
            System.out.println("Участник " + competitor + " не смог преодалеть " + length + " метров.");
            return false;
        }
    }
}
