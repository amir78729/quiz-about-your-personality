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

import java.util.Objects;

public class AddingQuestions extends AppCompatActivity {
    private TextView questionNumbers;
    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private Button[] myButtons;
    private ImageButton add;
    private Questions[] questions = QuestionBank.getQuestionsForYou();
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_questions);

        TextView name = findViewById(R.id.name);
        questionNumbers = findViewById(R.id.numberOfQuestionForYou);
        question = findViewById(R.id.questionText);
        answer1 = findViewById(R.id.answerNumber1);
        answer2 = findViewById(R.id.answerNumber2);
        answer3 = findViewById(R.id.answerNumber3);
        answer4 = findViewById(R.id.answerNumber4);
        add = findViewById(R.id.addQuestion);
        myButtons = new Button[]{answer1 ,answer2 ,answer3, answer4};

        final String yourName = getIntent().getStringExtra("yourName");
        String shoeYourName = "Dear " + yourName + ",";
        name.setText(shoeYourName);

        showQuestion(questions[currentQuestionIndex]);

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
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex < questions.length - 1)
                    addAndGoToTheNextQuestion();
                else {// here we have to go to another activity
                    Intent intent = new Intent(AddingQuestions.this , YourFriendsPage.class);
                    intent.putExtra("yourName" ,yourName);
                    int[] correctAnswers = new int[questions.length];
                    for (int i = 0 ; i < correctAnswers.length ; i++){
                        correctAnswers[i] = questions[i].getNumberOfTheCorrectAnswer();
                    }
//                    intent.putExtra("correctAnswers", correctAnswers);
                    User user = new User(yourName , correctAnswers);
                    Log.d("PRESS", "user created");
                    UsersBank.AddAUser(user);
                    Log.d("PRESS", "user added to the user bank");

                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void showQuestion(Questions q){
        questionNumbers.setText((currentQuestionIndex+1) + " / " + questions.length);
        question.setText(q.getQuestionTitle());
        answer1.setText(q.getAnswer1());
        answer2.setText(q.getAnswer2());
        answer3.setText(q.getAnswer3());
        answer4.setText(q.getAnswer4());

        answer1.setTextColor(Color.BLACK);
        answer2.setTextColor(Color.BLACK);
        answer3.setTextColor(Color.BLACK);
        answer4.setTextColor(Color.BLACK);

        answer1.setBackgroundColor(Color.WHITE);
        answer2.setBackgroundColor(Color.WHITE);
        answer3.setBackgroundColor(Color.WHITE);
        answer4.setBackgroundColor(Color.WHITE);

    }
    @SuppressLint("ResourceAsColor")
    public void press(int currentQuestionIndex, int correctAnswer){
        questions[currentQuestionIndex].setNumberOfTheCorrectAnswer(correctAnswer);// set the correct answer
        for (int i = 0; i < 4; i++){
            if (correctAnswer - 1 == i){
//                myButtons[i].setBackgroundColor(R.color.green);
//                myButtons[i].setTextColor(R.color.white);
                myButtons[i].setBackgroundColor(Color.BLACK);
                myButtons[i].setTextColor(Color.WHITE);

            }else{
                myButtons[i].setBackgroundColor(Color.WHITE);
                myButtons[i].setTextColor(Color.BLACK);
            }
        }
        Log.d("PRESS", "correct answer for Q#" + (currentQuestionIndex + 1) + " : " + questions[currentQuestionIndex].getNumberOfTheCorrectAnswer());
        add.setVisibility(View.VISIBLE);
    }
    public void addAndGoToTheNextQuestion(){
        currentQuestionIndex++;
        showQuestion(questions[currentQuestionIndex]);
        add.setVisibility(View.INVISIBLE);
    }
}
