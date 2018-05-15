/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.models;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Article extends BaseModel {

    @NonNull
    @SerializedName("title")
    public String title;

    @Nullable
    @SerializedName("text")
    public String text;

    @NonNull
    @SerializedName("score")
    public Integer score;

    @Nullable
    @SerializedName("url")
    public String url;

    @NonNull
    @SerializedName("descendants")
    public Integer descendants;

    @NonNull
    @SerializedName("kids")
    public Integer[] kids;

    protected Article(Parcel in) {
        super(in);
        title = in.readString();
        text = in.readString();
        if (in.readByte() == 0) {
            score = -1;
        } else {
            score = in.readInt();
        }
        url = in.readString();
        if (in.readByte() == 0) {
            descendants = 0;
        } else {
            descendants = in.readInt();
        }
        kids = (Integer[]) in.readArray(Integer.class.getClassLoader());
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeByte((byte) 1);
        parcel.writeInt(score);
        parcel.writeString(url);
        parcel.writeByte((byte) 1);
        parcel.writeInt(descendants);
    }
}
