package com.grow.source;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mQuizStartButton;
    private Button mEIntentStartButton;

    private static final int REQUEST_CODE_QUIZ = 0;
    private static final int REQUEST_CODE_EINTENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizStartButton = (Button)findViewById(R.id.quiz_start_button);
        mQuizStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, QuizActivity.class),
                        REQUEST_CODE_QUIZ);

                Toast.makeText(getApplicationContext(), "QuizActivity Started", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        mEIntentStartButton = (Button)findViewById(R.id.eintent_start_button);
        mEIntentStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, EIntentActivity1.class),
                        REQUEST_CODE_EINTENT);

                Toast.makeText(getApplicationContext(), "EIntentActivity1 Started", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_QUIZ) {
            Toast.makeText(getApplicationContext(), "QuizActivity Ended", Toast.LENGTH_SHORT)
                    .show();
        } else if (requestCode == REQUEST_CODE_EINTENT) {
            Toast.makeText(getApplicationContext(), "EIntentActivity1 Ended", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
