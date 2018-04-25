package com.grow.source;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ELVAdapter extends BaseAdapter {
    private ArrayList<ELVItem> listViewItemList = new ArrayList<ELVItem>();

    public ELVAdapter(ArrayList<ELVItem> data) {
        this.listViewItemList = data;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return listViewItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        final int pos = i;
        final Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.elv_row, viewGroup, false);
        }

        ImageView iconImageView = (ImageView)view.findViewById(R.id.elv_row_iv1);
        TextView titleTextView = (TextView)view.findViewById(R.id.elv_row_tv1);
        TextView descTextView = (TextView)view.findViewById(R.id.elv_row_tv2);
        TextView locationTextView = (TextView)view.findViewById(R.id.elv_row_tv3);

        ELVItem elvItem = listViewItemList.get(pos);

        iconImageView.setImageDrawable(elvItem.getIconDrawable());
        titleTextView.setText(elvItem.getTitleStr());
        descTextView.setText(elvItem.getDescStr());
        locationTextView.setText(elvItem.getLocation());

        ImageView button = (ImageView)view.findViewById(R.id.elv_row_iv2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, pos+"번째 선택", Toast.LENGTH_SHORT)
                        .show();

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                alertdialog.setMessage(listViewItemList.get(pos).getDescStr() + "으로 전화하시겠습니까?");

                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT)
                                .show();
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                        context.startActivity(intent);
                    }
                });

                alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "취소 버튼을 눌렀습니다.", Toast.LENGTH_SHORT)
                                .show();
                    }
                });

                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setTitle("전화연결");
                alert.show();
            }
        });

        return view;
    }

    public void addItem(Drawable icon, String title, String desc, String loc) {
        ELVItem item = new ELVItem();

        item.setIconDrawable(icon);
        item.setTitleStr(title);
        item.setDescStr(desc);
        item.setLocation(loc);

        listViewItemList.add(item);
    }
}
