package com.grow.source;

import android.graphics.drawable.Drawable;

public class ELVItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String descStr;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getDescStr() {
        return descStr;
    }

    public void setDescStr(String descStr) {
        this.descStr = descStr;
    }

    public void setData(Drawable ic, String title, String desc, String loc) {
        iconDrawable = ic;
        titleStr = title;
        descStr = desc;
        location = loc;
    }
}
