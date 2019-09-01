package com.example.whatdoyouknowaboutme;

class QuestionBank {
    private static final Questions[] questions = new Questions[]{
            new Questions("What is your\nfavourite drink?","milk","tea", "coffee", "juice", -1),
            new Questions("What is your\nfavourite movie genre?","comedy","romantic", "action", "science fiction", -1),
            new Questions("Who is your\nfavourite superhero?","spider-man","batman", "superman", "iron-man", -1),
            new Questions("How do you transport\nin the city?","bus","subway", "personal car", "taxi", -1),
            new Questions("What is your\nfavourite fast food?","pizza","burger", "hot dog", "fried chicken", -1),
            new Questions("What is your\nfavourite music genre?","pop","classic", "electronic", "rock/metal", -1),
            new Questions("What is your\nfavourite sport?","soccer","volleyball", "basketball", "tennis", -1),




    };

    static String[] getQuestionsForFriends(String name){
        return new String[]{
                "What is "+name+"'s\nfavourite drink?",
                "What is "+name+"'s\nfavourite movie genre?",
                "Who  is "+name+"'s\nfavourite superhero?",
                "How does "+name+" transport\nin the city?",
                "What is "+name+"'s\nfavourite fast food?",
                "What is "+name+"'s\nfavourite music genre?",
                "What is "+name+"'s\nfavourite sport?",



        };
    }

    static Questions[] getQuestionsForYou() {
        return questions;
    }
}
