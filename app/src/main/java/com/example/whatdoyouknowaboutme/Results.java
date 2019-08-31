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
        Button playAgain = findViewById(R.id.playAgain);
        int correctAnswers = Integer.parseInt(getIntent().getStringExtra("correctAnswers"));
        textView.setText(correctAnswers + "/" + QuestionBank.getQuestionsForYou().length);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button button = findViewById(R.id.playWithAnotherFriend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Results.this , YourFriendsPage.class);
                String name = getIntent().getStringExtra("yourName");

                intent.putExtra("yourName", name);
//                intent.putExtra("correctAnswers", bundle.getIntArray("correctAnswers"));
                startActivity(intent);
            }
        });
    }
}
