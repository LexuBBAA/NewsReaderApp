/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.models;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Job extends BaseModel {

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

    protected Job(Parcel in) {
        super(in);
        title = in.readString();
        text = in.readString();
        if (in.readByte() == 0) {
            score = -1;
        } else {
            score = in.readInt();
        }
        url = in.readString();
    }

    public static final Creator<Job> CREATOR = new Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
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
        parcel.writeInt(score);
        parcel.writeString(url);
    }
}
