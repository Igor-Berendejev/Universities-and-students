package model;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private StudyProfile studyProfile;
    private double avgScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private List<String> universityList;

    public Statistics(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        this.avgScore = 0;
        this.numberOfStudents = 0;
        this.numberOfUniversities = 0;
        this.universityList = new ArrayList<>();
    }

    public Statistics(StudyProfile studyProfile, double avgScore, int numberOfStudents, int numberOfUniversities, List<String> universityList) {
        this.studyProfile = studyProfile;
        this.avgScore = avgScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.universityList = universityList;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public void setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
    }

    public List<String> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<String> universityList) {
        this.universityList = universityList;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + studyProfile +
                ", avgScore=" + avgScore +
                ", numberOfStudents=" + numberOfStudents +
                ", numberOfUniversities=" + numberOfUniversities +
                ", universityList=" + universityList +
                '}';
    }
}
