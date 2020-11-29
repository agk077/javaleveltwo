package ru.geekbrain.agk077.javaleveltwo.lesson01.competitor;

public class Cat implements Competitor{
    private final String name;
    private final int maxJumpHeight;
    private final int maxRunLength;

    public Cat(String name, int maxJumpHeight, int maxRunLength) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
    }


    @Override
    public int run() {
        System.out.println("Кот " + name + " бежит на " + maxRunLength + " метров.");
        return maxRunLength;
    }

    @Override
    public int jump() {
        System.out.println("Кот " + name + " прыгает на " + maxJumpHeight + " метров.");
        return maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", maxJumpHeight=" + maxJumpHeight +
                ", maxRunLength=" + maxRunLength +
                '}';
    }
}
