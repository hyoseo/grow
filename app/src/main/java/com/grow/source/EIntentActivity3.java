package com.grow.source;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EIntentActivity3 extends AppCompatActivity {
    public static final String EXTRA_PERSON = "EXTRA_PERSON";

    TextView third_resultTextview;
    ImageView third_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eintent3);

        third_resultTextview = (TextView)findViewById(R.id.eia3_tv);
        third_imageview = (ImageView) findViewById(R.id.eia3_imgview);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Person person = (Person)getIntent().getExtras().getSerializable(EXTRA_PERSON);
            if (person == null) {
                Toast.makeText(this, "잘못된 요청", Toast.LENGTH_SHORT).
                        show();
                finish();
            } else {
                String resultText = person.getName() + ", " + person.getPhone();

                third_resultTextview.setText(resultText);
                third_imageview.setImageResource(person.getImageres());
            }
        } else {
            Toast.makeText(this, "잘못된 요청", Toast.LENGTH_SHORT).
                    show();
            finish();
        }
    }
}
