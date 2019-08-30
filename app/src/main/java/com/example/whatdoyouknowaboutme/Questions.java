package com.example.whatdoyouknowaboutme;

class Questions {
    private String questionTitle;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int numberOfTheCorrectAnswer;

    Questions(String questionTitle, String answer1, String answer2, String answer3, String answer4, int numberOfTheCorrectAnswer) {
        this.questionTitle = questionTitle;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.numberOfTheCorrectAnswer = numberOfTheCorrectAnswer;
    }

    String getQuestionTitle() {
        return questionTitle;
    }

//    public void setQuestionTitle(String questionTitle) {
//        this.questionTitle = questionTitle;
//    }

    String getAnswer1() {
        return answer1;
    }

//    public void setAnswer1(String answer1) {
//        this.answer1 = answer1;
//    }

    String getAnswer2() {
        return answer2;
    }

//    public void setAnswer2(String answer2) {
//        this.answer2 = answer2;
//    }

    String getAnswer3() {
        return answer3;
    }

//    public void setAnswer3(String answer3) {
//        this.answer3 = answer3;
//    }

    String getAnswer4() {
        return answer4;
    }

//    public void setAnswer4(String answer4) {
//        this.answer4 = answer4;
//    }

    int getNumberOfTheCorrectAnswer() {
        return numberOfTheCorrectAnswer;
    }

    void setNumberOfTheCorrectAnswer(int numberOfTheCorrectAnswer) {
        this.numberOfTheCorrectAnswer = numberOfTheCorrectAnswer;
    }
}
