package com.example.whatdoyouknowaboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class YourFriendsPage extends AppCompatActivity {
    private EditText friendsName;
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_friends_page);

        friendsName = findViewById(R.id.friendsName);
        start = findViewById(R.id.startTheQuiz);
//        Bundle temp = getIntent().getExtras();
//        final int[] questionTemp = temp.getIntArray("correctAnswers");
        final int[] correctAnswers = UsersBank.getAUserAnswers(getIntent().getStringExtra("yourName"));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String friend = friendsName.getText().toString().trim();
                if (!friend.isEmpty()){
                    Intent intent = new Intent(YourFriendsPage.this , Quiz.class);
                    intent.putExtra("yourName", getIntent().getStringExtra("yourName"));
                    intent.putExtra("friendsName", friend);
//                    intent.putExtra("correctAnswers", correctAnswers);
                    intent.putExtra("correctAnswers", UsersBank.getAUserAnswers(getIntent().getStringExtra("yourName")));

                    startActivity(intent);
                    finish();
                }else  {
                    Toast.makeText(YourFriendsPage.this, "Please enter your friend's name!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
