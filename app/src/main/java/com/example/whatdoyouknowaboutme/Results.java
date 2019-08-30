package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView textView = findViewById(R.id.result);
        Button button = findViewById(R.id.playAgain);
        int correctAnswers = Integer.parseInt(getIntent().getStringExtra("correctAnswers"));
        textView.setText(correctAnswers + "/" + QuestionBank.getQuestionsForYou().length);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
