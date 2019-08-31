package com.example.whatdoyouknowaboutme;

public class User {
    private String name;
    private int[] correctAnswers;

    public User(String name, int[] correctAnswers) {
        this.name = name;
        this.correctAnswers = correctAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
