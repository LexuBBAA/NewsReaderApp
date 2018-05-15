/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.models;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Comment extends BaseModel {

    @NonNull
    @SerializedName("text")
    public String text;

    @Nullable
    @SerializedName("kids")
    public Integer[] kids;

    protected Comment(Parcel in) {
        super(in);
        text = in.readString();
        kids = (Integer[]) in.readArray(Integer.class.getClassLoader());
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(text);
        parcel.writeArray(kids);
    }
}
