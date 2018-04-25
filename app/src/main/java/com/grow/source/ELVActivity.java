package com.grow.source;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ELVActivity extends AppCompatActivity {
    private ELVItem data;
    private ArrayList<ELVItem> arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elv);

        ListView listView = (ListView)findViewById(R.id.elv_lv1);

        arrays = new ArrayList<ELVItem>();
        initialData();
        ELVAdapter adapter = new ELVAdapter(arrays);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ELVItem item = (ELVItem)adapterView.getItemAtPosition(i);
                Toast.makeText(ELVActivity.this, i + "번째 선택\n " + item.getTitleStr() + item.getDescStr() + item.getLocation(), Toast.LENGTH_SHORT)
                        .show();;
            }
        });
    }

    private void initialData() {
        data = new ELVItem();
        data.setData(getResources().getDrawable(R.drawable.p1, null), "이효서", "010-2333-3333", "서울");
        arrays.add(data);

        data = new ELVItem();
        data.setData(getResources().getDrawable(R.drawable.p2, null), "박신혜", "010-2333-4333", "인천");
        arrays.add(data);

        data = new ELVItem();
        data.setData(getResources().getDrawable(R.drawable.p3, null), "이동건", "010-2433-3333", "해남");
        arrays.add(data);
    }
}
