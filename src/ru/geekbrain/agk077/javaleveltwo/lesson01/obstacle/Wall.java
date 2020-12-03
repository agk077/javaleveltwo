package ru.geekbrain.agk077.javaleveltwo.lesson01.obstacle;

import ru.geekbrain.agk077.javaleveltwo.lesson01.competitor.Competitor;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean moveThroughObstacle(Competitor competitor) {
        if (competitor.jump() >= height) {
            System.out.println("Участник " + competitor + " успешно прыгнул на " + height + " метров.");
            return true;
        } else {
            System.out.println("Участник " + competitor + " не смог прыгнуть на " + height + " метров.");
            return false;
        }
    }
}
