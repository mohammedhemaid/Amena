package com.app.wihack.amina.chatting;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class OrganizationProfile implements Parcelable {

    private int organization_id;
    private String organization_picture;
    private String organization_name;
    private GeoPoint geo_point;
    private String organization_location;
    private String organization_speciality;
    private String organization_description;
    private String organization_mobileNumber;

    public static ArrayList<OrganizationProfile> getOrganizationProfiles(){
        ArrayList<OrganizationProfile> organizationProfiles = new ArrayList<>();
        organizationProfiles.add(new OrganizationProfile(0,null,"hello","Gaza","women"));
        organizationProfiles.add(new OrganizationProfile(1,null,"hello","Gaza","women"));
        organizationProfiles.add(new OrganizationProfile(2,null,"hello","Gaza","women"));
        organizationProfiles.add(new OrganizationProfile(3,null,"hello","Gaza","women"));
        organizationProfiles.add(new OrganizationProfile(4,null,"hello","Gaza","women"));

    return organizationProfiles;
    }
    public OrganizationProfile() {
    }

    public OrganizationProfile(int organization_id, String organization_picture, String organization_name, String organization_location, String organization_speciality) {
        this.organization_id = organization_id;
        this.organization_picture = organization_picture;
        this.organization_name = organization_name;
        this.organization_location = organization_location;
        this.organization_speciality = organization_speciality;
    }

    protected OrganizationProfile(Parcel in) {
        organization_id = in.readInt();
        organization_picture = in.readString();
        organization_name = in.readString();
        organization_location = in.readString();
        organization_speciality = in.readString();
        organization_description = in.readString();
        organization_mobileNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(organization_id);
        dest.writeString(organization_picture);
        dest.writeString(organization_name);
        dest.writeString(organization_location);
        dest.writeString(organization_speciality);
        dest.writeString(organization_description);
        dest.writeString(organization_mobileNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OrganizationProfile> CREATOR = new Creator<OrganizationProfile>() {
        @Override
        public OrganizationProfile createFromParcel(Parcel in) {
            return new OrganizationProfile(in);
        }

        @Override
        public OrganizationProfile[] newArray(int size) {
            return new OrganizationProfile[size];
        }
    };

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganization_picture() {
        return organization_picture;
    }

    public void setOrganization_picture(String organization_picture) {
        this.organization_picture = organization_picture;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public GeoPoint getGeo_point() {
        return geo_point;
    }

    public void setGeo_point(GeoPoint geo_point) {
        this.geo_point = geo_point;
    }

    public String getOrganization_location() {
        return organization_location;
    }

    public void setOrganization_location(String organization_location) {
        this.organization_location = organization_location;
    }

    public String getOrganization_speciality() {
        return organization_speciality;
    }

    public void setOrganization_speciality(String organization_speciality) {
        this.organization_speciality = organization_speciality;
    }

    public String getOrganization_description() {
        return organization_description;
    }

    public void setOrganization_description(String organization_description) {
        this.organization_description = organization_description;
    }

    public String getOrganization_mobileNumber() {
        return organization_mobileNumber;
    }

    public void setOrganization_mobileNumber(String organization_mobileNumber) {
        this.organization_mobileNumber = organization_mobileNumber;
    }
}
