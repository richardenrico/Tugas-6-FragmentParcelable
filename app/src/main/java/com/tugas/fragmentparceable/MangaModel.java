package com.tugas.fragmentparceable;

import android.os.Parcel;
import android.os.Parcelable;

public class MangaModel implements Parcelable {
    private String title;
    private String synopsis;
    private String author;
    private int image;

    protected MangaModel(Parcel in) {
        title = in.readString();
        synopsis = in.readString();
        author = in.readString();
        image = in.readInt();
    }

    public static final Creator<MangaModel> CREATOR = new Creator<MangaModel>() {
        @Override
        public MangaModel createFromParcel(Parcel in) {
            return new MangaModel(in);
        }

        @Override
        public MangaModel[] newArray(int size) {
            return new MangaModel[size];
        }
    };

    public MangaModel() {}

    public void setAuthor(String author) {this.author = author;}

    public String getAuthor() {return author;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(synopsis);
        dest.writeString(author);
        dest.writeInt(image);
    }
}
