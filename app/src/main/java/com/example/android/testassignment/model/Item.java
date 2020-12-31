package com.example.android.testassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("img_src")
    private String mImage;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("sub_title")
    private String mSubTitle;

    public Item(String image, String title, String category, String subtitle){
        this.mImage = image;
        this.mTitle = title;
        this.mSubTitle = subtitle;
    }

    protected Item(Parcel in) {
        mImage = in.readString();
        mTitle = in.readString();
        mSubTitle = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getImage() {
        return mImage;
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mImage);
        parcel.writeString(mTitle);
        parcel.writeString(mSubTitle);
    }
}
