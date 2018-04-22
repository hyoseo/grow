package com.grow.source;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EIntentActivity2 extends AppCompatActivity {
    TextView resultTextview;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eintent2);

        resultTextview = (TextView)findViewById(R.id.eia2_se_tv);
        imageview = (ImageView)findViewById(R.id.eia2_imgview);

        Intent it = getIntent();

        String picNumber = it.getStringExtra("pic");
        String resultText = it.getStringExtra("name") + ", " + it.getStringExtra("phone");

        resultTextview.setText(resultText);
        imageview.setImageResource(it.getIntExtra("pic", 0));
    }
}
