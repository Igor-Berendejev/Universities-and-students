package model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Student {
    @SerializedName(value = "Student full name")
    private String fullName;
    @SerializedName(value = "University ID")
    private String universityId;
    @SerializedName(value = "Current course")
    private int currentCourseNumber;
    @SerializedName(value = "Average exam score")
    private float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "model.Student: [Full name: " + fullName +
                ", university id: " + universityId +
                ", current course number: " + currentCourseNumber +
                ", average exam score: " + avgExamScore + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Student student = (Student) obj;
        return this.getFullName().equals(student.getFullName()) &&
                this.getUniversityId().equals(student.getUniversityId()) &&
                this.getCurrentCourseNumber() == student.getCurrentCourseNumber() &&
                this.getAvgExamScore() == student.getAvgExamScore();
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, universityId, currentCourseNumber, avgExamScore);
    }
}
