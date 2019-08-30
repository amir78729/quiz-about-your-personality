package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button start;
    EditText enterYourName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        enterYourName = findViewById(R.id.enter_your_name);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourName = enterYourName.getText().toString().trim();
                if (!yourName.isEmpty()){
                    Intent intent = new Intent(MainActivity.this , AddingQuestions.class);
                    intent.putExtra("yourName", yourName);
                    startActivity(intent);
                }else  {
                    Toast.makeText(MainActivity.this, "Please enter your name!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
