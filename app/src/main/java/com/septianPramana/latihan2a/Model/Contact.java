package com.septianPramana.latihan2a.Model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.septianPramana.latihan2a.R;

public class Contact implements Parcelable {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String city;
    private boolean isMale;
    private boolean sd,smp,sma;
    private boolean s1,s2,s3;

    private Drawable imgPath;
    private int imgLink;

    public Contact(String id, String name, boolean isMale) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
    }

    public Contact(){}

    protected Contact(Parcel in) {
        id = in.readString();
        name = in.readString();
        address = in.readString();
        phone = in.readString();
        city = in.readString();
        isMale = in.readByte() != 0;
        sd = in.readByte() != 0;
        smp = in.readByte() != 0;
        sma = in.readByte() != 0;
        s1 = in.readByte() != 0;
        s2 = in.readByte() != 0;
        s3 = in.readByte() != 0;

        imgLink = in.readInt();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public boolean isSd() {
        return sd;
    }

    public void setSd(boolean sd) {
        this.sd = sd;
    }

    public boolean isSmp() {
        return smp;
    }

    public void setSmp(boolean smp) {
        this.smp = smp;
    }

    public boolean isSma() {
        return sma;
    }

    public void setSma(boolean sma) {
        this.sma = sma;
    }

    public boolean isS1() {
        return s1;
    }

    public void setS1(boolean s1) {
        this.s1 = s1;
    }

    public boolean isS2() {
        return s2;
    }

    public void setS2(boolean s2) {
        this.s2 = s2;
    }

    public boolean isS3() {
        return s3;
    }

    public void setS3(boolean s3) {
        this.s3 = s3;
    }

    public int getImgLink() {
        return imgLink;
    }

    public void setImgLink(int imgLink) {
        this.imgLink = imgLink;
    }

    public Drawable getImg() {
        return imgPath;
    }

    public void setImg(Drawable imgPath) {
        this.imgPath = imgPath;
    }


    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(phone);
        parcel.writeString(city);

        parcel.writeByte((byte) (isMale ? 1 : 0));
        parcel.writeByte((byte) (sd ? 1 : 0));
        parcel.writeByte((byte) (smp ? 1 : 0));
        parcel.writeByte((byte) (sma ? 1 : 0));
        parcel.writeByte((byte) (s1 ? 1 : 0));
        parcel.writeByte((byte) (s2 ? 1 : 0));
        parcel.writeByte((byte) (s3 ? 1 : 0));

        parcel.writeInt(imgLink);
    }
}
