package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class AddingQuestions extends AppCompatActivity {
    private TextView name;
    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private Questions[] questions = new Questions[]{
            new Questions("What is your favourite drink?","milk","tea", "coffee", "juice", -1),
            new Questions("What is your favourite movie genre?","comedy","romantic", "action", "science fiction", -1),
    };
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_questions);

        name = findViewById(R.id.name);
        question = findViewById(R.id.questionText);
        answer1 = findViewById(R.id.answerNumber1);
        answer2 = findViewById(R.id.answerNumber2);
        answer3 = findViewById(R.id.answerNumber3);
        answer4 = findViewById(R.id.answerNumber4);

        String yourName = Objects.requireNonNull(getIntent().getStringExtra("yourName")).concat(",");
        name.setText(yourName);

        showQuestion(questions[currentQuestionIndex]);

    }

    public void showQuestion(Questions q){
        question.setText(q.getQuestionTitle());
        answer1.setText(q.getAnswer1());
        answer2.setText(q.getAnswer2());
        answer3.setText(q.getAnswer3());
        answer4.setText(q.getAnswer4());
    }
}
