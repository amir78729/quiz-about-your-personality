package com.example.whatdoyouknowaboutme;

public class QuestionBank {
    private static final Questions[] questions = new Questions[]{
            new Questions("What is your\nfavourite drink?","milk","tea", "coffee", "juice", -1),
            new Questions("What is your\nfavourite movie genre?","comedy","romantic", "action", "science fiction", -1),
            new Questions("Who is your\nfavourite superhero?","spider-man","batman", "superman", "iron-man", -1),
            new Questions("How do you transport\nin the city?","bus","subway", "personal car", "taxi", -1),
    };
    public static final String[] getQuestionsForFriends(String name){
        String[] result = new String[]{
                "What is "+name+"'s\nfavourite drink?",
                "What is "+name+"'s\nfavourite movie genre?",
                "Who  is "+name+"'s\nfavourite superhero?",
                "How does "+name+" transport\nin the city?",
        };
        return result;
    }

    public static Questions[] getQuestionsForYou() {
        return questions;
    }
}
