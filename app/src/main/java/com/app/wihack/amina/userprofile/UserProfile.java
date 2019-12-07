package com.app.wihack.amina.userprofile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.GeoPoint;

public class UserProfile implements Parcelable {

    private String username;
    private String violence_type;
    private int age;
    private int children_number;
    private GeoPoint geo_point;

    public UserProfile(String username, String violence_type, int age, int children_number, GeoPoint geo_point) {
        this.username = username;
        this.violence_type = violence_type;
        this.age = age;
        this.children_number = children_number;
        this.geo_point = geo_point;
    }

    public UserProfile() {
    }

    protected UserProfile(Parcel in) {
        username = in.readString();
        violence_type = in.readString();
        age = in.readInt();
        children_number = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(violence_type);
        dest.writeInt(age);
        dest.writeInt(children_number);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getViolence_type() {
        return violence_type;
    }

    public void setViolence_type(String violence_type) {
        this.violence_type = violence_type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildren_number() {
        return children_number;
    }

    public void setChildren_number(int children_number) {
        this.children_number = children_number;
    }

    public GeoPoint getGeo_point() {
        return geo_point;
    }

    public void setGeo_point(GeoPoint geo_point) {
        this.geo_point = geo_point;
    }
}