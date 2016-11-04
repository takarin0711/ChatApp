package com.example.takay_000.chatapp;

import android.graphics.Bitmap;

/**
 * Created by takay_000 on 2016/11/04.
 */

public class CustomData {
    private Bitmap imageData_;
    private String textData_;
    private String nameData_;

    public void setImagaData(Bitmap image) {
        imageData_ = image;
    }

    public Bitmap getImageData() {
        return imageData_;
    }

    public void setTextData(String text) { textData_ = text; }

    public String getTextData() {
        return textData_;
    }

    public void setNameData(String text) { nameData_ = text; }

    public String getNameData() {
        return nameData_;
    }
}