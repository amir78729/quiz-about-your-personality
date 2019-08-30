package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    private TextView questionNumbers;
    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private Button[] myButtons;
    private ImageButton add;
//    private Questions[] questions = QuestionBank.getQuestionsForYou();
//    private String[]    questionTitles = QuestionBank.getQuestionsForFriends(getIntent().getStringExtra("yourName"));
    private Questions[] questions;
    private String[] questionTitles;
    private int[] yourAnswersToTheQuestions;
    int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView name = findViewById  (R.id.friend_name);
        questionNumbers = findViewById(R.id.friend_numberOfQuestionForYou);
        question = findViewById       (R.id.friend_questionText);
        answer1 = findViewById        (R.id.friend_answerNumber1);
        answer2 = findViewById        (R.id.friend_answerNumber2);
        answer3 = findViewById        (R.id.friend_answerNumber3);
        answer4 = findViewById        (R.id.friend_answerNumber4);
        add = findViewById            (R.id.friend_addQuestion);
        myButtons = new Button[]{answer1 ,answer2 ,answer3, answer4};

        questions = QuestionBank.getQuestionsForYou();
        questionTitles = QuestionBank.getQuestionsForFriends(getIntent().getStringExtra("yourName"));
        yourAnswersToTheQuestions = getIntent().getIntArrayExtra("correctAnswers");

        final String friendsName = getIntent().getStringExtra("friendsName");
        String shoeYourName = "Dear " + friendsName + ",";
        name.setText(shoeYourName);
        showQuestion(currentQuestionIndex);
//
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press(currentQuestionIndex, 1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press(currentQuestionIndex, 2);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press(currentQuestionIndex, 3);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press(currentQuestionIndex, 4);
            }
        });
//
    }
//
    @SuppressLint("SetTextI18n")
    public void showQuestion(int  currentQuestionIndex){
        questionNumbers.setText((currentQuestionIndex+1) + " / " + questions.length);
        question.setText(questionTitles[currentQuestionIndex]);
        answer1.setText(questions[currentQuestionIndex].getAnswer1());
        answer2.setText(questions[currentQuestionIndex].getAnswer2());
        answer3.setText(questions[currentQuestionIndex].getAnswer3());
        answer4.setText(questions[currentQuestionIndex].getAnswer4());

        answer1.setTextColor(Color.BLACK);
        answer2.setTextColor(Color.BLACK);
        answer3.setTextColor(Color.BLACK);
        answer4.setTextColor(Color.BLACK);

        answer1.setBackgroundColor(Color.WHITE);
        answer2.setBackgroundColor(Color.WHITE);
        answer3.setBackgroundColor(Color.WHITE);
        answer4.setBackgroundColor(Color.WHITE);

        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);
        answer4.setEnabled(true);

    }

    @SuppressLint("ResourceAsColor")
    public void press(int currentQuestionIndex, int correctAnswer){
//        for (int i = 0; i < 4; i++){
//            if (correctAnswer - 1 == i){
////                myButtons[i].setBackgroundColor(R.color.green);
////                myButtons[i].setTextColor(R.color.white);
//                myButtons[i].setBackgroundColor(Color.GREEN);
//                myButtons[i].setTextColor(Color.WHITE);
//
//            }else{
//                myButtons[i].setBackgroundColor(Color.RED);
//                myButtons[i].setTextColor(Color.WHITE);
//            }
//            myButtons[i].setEnabled(false);
//        }
        if (correctAnswer == yourAnswersToTheQuestions[currentQuestionIndex]){
            Toast.makeText(Quiz.this , "True!" , Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(Quiz.this , "False!" , Toast.LENGTH_SHORT).show();
        }
//        Log.d("PRESS", "your friend's answer for Q#" + (currentQuestionIndex + 1) + " : " + correctAnswer - 1 == i);
        add.setVisibility(View.VISIBLE);
    }
//    public void addAndGoToTheNextQuestion(){
//        currentQuestionIndex++;
//        showQuestion(currentQuestionIndex);
//        add.setVisibility(View.INVISIBLE);
//    }

}
