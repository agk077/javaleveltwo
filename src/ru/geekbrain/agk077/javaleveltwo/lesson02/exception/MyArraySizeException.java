package ru.geekbrain.agk077.javaleveltwo.lesson02.exception;

public class MyArraySizeException extends IndexOutOfBoundsException{
    public MyArraySizeException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "MyArraySizeException{} " + this.getMessage();
    }
}
