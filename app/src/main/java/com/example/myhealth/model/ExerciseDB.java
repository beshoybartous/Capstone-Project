package com.example.myhealth.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exersice_table")

public class ExerciseDB implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    private String muscle;
    private String name;
    private String comment;
    private String instructionPreparation;
    private String instructionExecution;
    private String gifUrl;

    public ExerciseDB(String muscle, String name, String comment, String instructionPreparation, String instructionExecution, String gifUrl) {
        this.muscle = muscle;
        this.name = name;
        this.comment = comment;
        this.instructionPreparation = instructionPreparation;
        this.instructionExecution = instructionExecution;
        this.gifUrl = gifUrl;
    }
    public ExerciseDB()
    {

    }

    protected ExerciseDB(Parcel in) {
        id = in.readInt();
        muscle = in.readString();
        name = in.readString();
        comment = in.readString();
        instructionPreparation = in.readString();
        instructionExecution = in.readString();
        gifUrl = in.readString();
    }

    public static final Creator<ExerciseDB> CREATOR = new Creator<ExerciseDB>() {
        @Override
        public ExerciseDB createFromParcel(Parcel in) {
            return new ExerciseDB(in);
        }

        @Override
        public ExerciseDB[] newArray(int size) {
            return new ExerciseDB[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setInstructionPreparation(String instructionPreparation) {
        this.instructionPreparation = instructionPreparation;
    }

    public void setInstructionExecution(String instructionExecution) {
        this.instructionExecution = instructionExecution;
    }


    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public int getId() {
        return id;
    }

    public String getMuscle() {
        return muscle;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getInstructionPreparation() {
        return instructionPreparation;
    }

    public String getInstructionExecution() {
        return instructionExecution;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(muscle);
        dest.writeString(name);
        dest.writeString(comment);
        dest.writeString(instructionPreparation);
        dest.writeString(instructionExecution);
        dest.writeString(gifUrl);
    }
}
