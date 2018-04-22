package com.grow.source;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EIntentActivity1 extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText phone;

    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;

    Button secondBtn;
    Button thirdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eintent1);

        name = (EditText)findViewById(R.id.eia1_name_et);
        phone = (EditText)findViewById(R.id.eia1_phone_et);

        option1 = (RadioButton)findViewById(R.id.eia1_option1_rb);
        option2 = (RadioButton)findViewById(R.id.eia1_option2_rb);
        option3 = (RadioButton)findViewById(R.id.eia1_option3_rb);
        option4 = (RadioButton)findViewById(R.id.eia1_option4_rb);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        option1.setChecked(true);

        secondBtn = (Button)findViewById(R.id.eia1_go_second_b);
        thirdBtn = (Button)findViewById(R.id.eia1_go_third_b);

        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.eia1_option1_rb:
                Toast.makeText(this, "사람 1 : " + option1.isChecked() + "\n", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.eia1_option2_rb:
                Toast.makeText(this, "사람 2 : " + option2.isChecked() + "\n", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.eia1_option3_rb:
                Toast.makeText(this, "사람 3 : " + option3.isChecked() + "\n", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.eia1_option4_rb:
                Toast.makeText(this, "사람 4 : " + option4.isChecked() + "\n", Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.eia1_go_second_b:
                Intent it = new Intent(getApplicationContext(), EIntentActivity2.class);
                it.putExtra("name", name.getText().toString());
                it.putExtra("phone", phone.getText().toString());
                if (option1.isChecked()) {
                    it.putExtra("pic", R.drawable.p1);
                } else if (option2.isChecked()) {
                    it.putExtra("pic", R.drawable.p2);
                } else if (option3.isChecked()) {
                    it.putExtra("pic", R.drawable.p3);
                } else if (option4.isChecked()) {
                    it.putExtra("pic", R.drawable.p4);
                }

                startActivity(it);

                break;
            case R.id.eia1_go_third_b:
                Person person = new Person();

                Intent it2 = new Intent(getApplicationContext(), EIntentActivity3.class);
                person.setName(name.getText().toString());
                person.setPhone(phone.getText().toString());

                if (option1.isChecked()) {
                    person.setImageres(R.drawable.p1);
                } else if (option2.isChecked()) {
                    person.setImageres(R.drawable.p2);
                } else if (option3.isChecked()) {
                    person.setImageres(R.drawable.p3);
                } else if (option4.isChecked()) {
                    person.setImageres(R.drawable.p4);
                }

                it2.putExtra(EIntentActivity3.EXTRA_PERSON, person);
                startActivity(it2);

                break;
        }
    }
}
