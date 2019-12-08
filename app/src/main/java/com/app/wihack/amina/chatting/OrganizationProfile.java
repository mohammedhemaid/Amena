package com.app.wihack.amina.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.app.wihack.amina.R;
import com.google.firebase.firestore.GeoPoint;

import java.util.ArrayList;

public class OrganizationProfile implements Parcelable {

    private int organization_id;
    private int organization_picture;
    private String organization_name;
    private GeoPoint geo_point;
    private String organization_location;
    private String organization_speciality;
    private String organization_description;
    private String organization_mobileNumber;
    static Context context;

    public static void setContext(Context context) {
        OrganizationProfile.context = context;
    }

    public static ArrayList<OrganizationProfile> getOrganizationProfiles() {
        ArrayList<OrganizationProfile> organizationProfiles = new ArrayList<>();
        organizationProfiles.add(new OrganizationProfile(0, R.drawable.img_psyco_center, context.getString(R.string.gaza_program_for_psyco_health), context.getResources().getString(R.string.gaza_city), context.getResources().getString(R.string.psyco_therapy)));
        organizationProfiles.add(new OrganizationProfile(1, R.drawable.img_aisha, context.getString(R.string.aisha_institutes), context.getResources().getString(R.string.gaza_city), context.getResources().getString(R.string.specialization_above_fifteen)));
        organizationProfiles.add(new OrganizationProfile(3, R.drawable.img_culture_institutes_and_free, context.getString(R.string.culture_institutions), context.getResources().getString(R.string.gaza_city), context.getResources().getString(R.string.specialization_above_fifteen)));
        organizationProfiles.add(new OrganizationProfile(4, R.drawable.img_save_home, context.getString(R.string.save_place_org), "Gaza", "women"));
        organizationProfiles.add(new OrganizationProfile(5, R.drawable.img_research_women, context.getString(R.string.research_center_and_legal_security), "Gaza", "women"));
        organizationProfiles.add(new OrganizationProfile(6, R.drawable.palestine_center_for_conflict, context.getString(R.string.palestine_center_for_conflict), "Gaza", "women"));
        organizationProfiles.add(new OrganizationProfile(7, R.drawable.img_red_crescent, context.getString(R.string.red_cresent), "Gaza", "women"));

        return organizationProfiles;
    }

    public OrganizationProfile() {
    }

    public OrganizationProfile(int organization_id, int organization_picture, String organization_name, String organization_location, String organization_speciality) {
        this.organization_id = organization_id;
        this.organization_picture = organization_picture;
        this.organization_name = organization_name;
        this.organization_location = organization_location;
        this.organization_speciality = organization_speciality;
    }

    protected OrganizationProfile(Parcel in) {
        organization_id = in.readInt();
        organization_picture = in.readInt();
        organization_name = in.readString();
        organization_location = in.readString();
        organization_speciality = in.readString();
        organization_description = in.readString();
        organization_mobileNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(organization_id);
        dest.writeInt(organization_picture);
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

    public int getOrganization_picture() {
        return organization_picture;
    }

    public void setOrganization_picture(int organization_picture) {
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
