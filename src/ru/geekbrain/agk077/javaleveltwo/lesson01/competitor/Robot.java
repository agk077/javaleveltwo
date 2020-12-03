package ru.geekbrain.agk077.javaleveltwo.lesson01.competitor;

public class Robot implements Competitor {
    private final String name;
    private final int maxJumpHeight;
    private final int maxRunLength;

    public Robot(String name, int maxJumpHeight, int maxRunLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
    }

    @Override
    public int run() {
        System.out.println("Робот " + name + " бежит на " + maxRunLength + " метров.");
        return maxRunLength;
    }

    @Override
    public int jump() {
        System.out.println("Робот " + name + " прыгает на " + maxJumpHeight + " метров.");
        return maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", maxJumpHeight=" + maxJumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }
}
