package com.pokebro.Adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bryant on 10/6/2014.
 */
public class MonsterParcelable implements Parcelable {

    private String name;
    private int drawableResoure;

    public MonsterParcelable(String name, int drawableResoure) {
        this.name = name;
        this.drawableResoure = drawableResoure;
    }

    public String getName() {
        return name;
    }

    public int getDrawableResoure() {
        return drawableResoure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(drawableResoure);
    }

    public static final Parcelable.Creator<MonsterParcelable> CREATOR = new Parcelable.Creator<MonsterParcelable>() {
        public MonsterParcelable createFromParcel(Parcel in) {
            return new MonsterParcelable(in);
        }

        public MonsterParcelable[] newArray(int size) {
            return new MonsterParcelable[size];
        }
    };

    private MonsterParcelable(Parcel in) {
        name = in.readString();
        drawableResoure = in.readInt();
    }
}
