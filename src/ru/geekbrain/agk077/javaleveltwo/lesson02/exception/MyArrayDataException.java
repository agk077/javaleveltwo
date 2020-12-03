package ru.geekbrain.agk077.javaleveltwo.lesson02.exception;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "MyArrayDataException{}" + this.getMessage();
    }
}
