package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button nextQuestion;
    private Questions[] questions;
    private String[] questionTitles;
    private int[] yourAnswersToTheQuestions;
    private int correct = 0;
    private int wrong = 0;
    private TextView correctAnswers;
    private TextView wrongAnswers;

    int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final Bundle bundle = getIntent().getExtras();
        Log.d("PRESS", "QUIZ BEGUN");
        TextView name = findViewById(R.id.friend_name);
        questionNumbers = findViewById(R.id.friend_numberOfQuestionForYou);
        question = findViewById(R.id.friend_questionText);
        answer1 = findViewById(R.id.friend_answerNumber1);
        answer2 = findViewById(R.id.friend_answerNumber2);
        answer3 = findViewById(R.id.friend_answerNumber3);
        answer4 = findViewById(R.id.friend_answerNumber4);
        nextQuestion = findViewById(R.id.friend_addQuestion);
        correctAnswers = findViewById(R.id.correctAnswers);
        wrongAnswers = findViewById(R.id.wrongAnswers);
        myButtons = new Button[]{answer1 ,answer2 ,answer3, answer4};

        questions = QuestionBank.getQuestionsForYou();
        questionTitles = QuestionBank.getQuestionsForFriends(getIntent().getStringExtra("yourName"));

        final String friendsName = getIntent().getStringExtra("friendsName");
        final String yourName = getIntent().getStringExtra("yourName");
        yourAnswersToTheQuestions = UsersBank.getAUserAnswers(yourName);

        String showFriendsName = "Dear " + friendsName + ",";
        name.setText(showFriendsName);
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
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex < questions.length - 1)
                    next();
                else {// game is over
                    gameOver(bundle);
                }
            }
        });
//
    }
//
    @SuppressLint("SetTextI18n")
    public void showQuestion(int  currentQuestionIndex){
        Log.d("PRESS", "Q#" + (currentQuestionIndex + 1) + "'s correct answer : " + yourAnswersToTheQuestions[currentQuestionIndex]  );
        questionNumbers.setText((currentQuestionIndex+1) + " / " + questions.length);
        refreshTheScreen();

    }

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    public void press(int currentQuestionIndex, int friendsAnswer){
        if (friendsAnswer == yourAnswersToTheQuestions[currentQuestionIndex]){
            answerWasTrue(friendsAnswer);
        }
        else {
            answerWasFalse(friendsAnswer);
        }
        Log.d("PRESS", "your friend's answer for Q#" + (currentQuestionIndex + 1) + " : " + friendsAnswer + " -> " + (friendsAnswer == yourAnswersToTheQuestions[currentQuestionIndex]));
        nextQuestion.setVisibility(View.VISIBLE);
        for (Button b : myButtons){
            b.setEnabled(false);
        }
    }
    public void next(){
        currentQuestionIndex++;
        showQuestion(currentQuestionIndex);
        nextQuestion.setVisibility(View.INVISIBLE);
    }
    public void refreshTheScreen(){
        question.setText(questionTitles[currentQuestionIndex]);
        answer1.setText(questions[currentQuestionIndex].getAnswer1());
        answer2.setText(questions[currentQuestionIndex].getAnswer2());
        answer3.setText(questions[currentQuestionIndex].getAnswer3());
        answer4.setText(questions[currentQuestionIndex].getAnswer4());
        for (Button b : myButtons){
            b.setTextColor(Color.rgb(53,105,150));
            b.setBackgroundColor(Color.WHITE);
            b.setEnabled(true);
        }
    }
    @SuppressLint("SetTextI18n")
    public void answerWasTrue(int friendsAnswer){
        Toast.makeText(Quiz.this , "True!" , Toast.LENGTH_SHORT).show();
        myButtons[friendsAnswer - 1].setBackgroundColor(Color.rgb(0,95,0));
        myButtons[yourAnswersToTheQuestions[currentQuestionIndex] - 1].setTextColor(Color.WHITE);
        correct++;
        correctAnswers.setText("correct answers: " + correct);
    }

    @SuppressLint("SetTextI18n")
    public void answerWasFalse(int friendsAnswer){
        Toast.makeText(Quiz.this , "False!" , Toast.LENGTH_SHORT).show();
        myButtons[friendsAnswer - 1].setBackgroundColor(Color.rgb(177,0,0));
        myButtons[friendsAnswer - 1].setTextColor(Color.WHITE);
        myButtons[yourAnswersToTheQuestions[currentQuestionIndex] - 1].setBackgroundColor(Color.rgb(0,95,0));
        myButtons[yourAnswersToTheQuestions[currentQuestionIndex] - 1].setTextColor(Color.WHITE);
        wrong++;
        wrongAnswers.setText("wrong answers: " + wrong);
    }
    public void gameOver(Bundle bundle){
        Intent intent = new Intent(Quiz.this , Results.class);
        intent.putExtra("bundle" , bundle);
        intent.putExtra("correctAnswers", ""+correct);
        startActivity(intent);
        finish();
    }
}
