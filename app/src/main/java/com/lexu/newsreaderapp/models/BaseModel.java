/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.models;

import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.lexu.newsreaderapp.models.response.Type;

abstract class BaseModel implements Parcelable {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    public Integer id;

    @NonNull
    @SerializedName("by")
    public String by;

    @NonNull
    @SerializedName("time")
    public Long time;

    @NonNull
    @SerializedName("type")
    public Type type;

    BaseModel(Parcel in) {
        if (in.readByte() == 0) {
            id = -1;
        } else {
            id = in.readInt();
        }
        by = in.readString();
        if (in.readByte() == 0) {
            time = (long) -1;
        } else {
            time = in.readLong();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) 1);
        parcel.writeInt(id);
        parcel.writeString(by);
        parcel.writeByte((byte) 1);
        parcel.writeLong(time);
    }
}
