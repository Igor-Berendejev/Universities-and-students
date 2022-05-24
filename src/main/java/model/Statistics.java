package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "statisticsEntry")
@XmlType(propOrder = {"studyProfile", "avgScore"})
public class Statistics {

    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;

    @XmlElement(name = "avgScore")
    private double avgScore;

    @XmlTransient
    private int numberOfStudents;

    @XmlTransient
    private int numberOfUniversities;

    @XmlTransient
    private List<String> universityList;

    public Statistics() {
    }

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

    @XmlTransient
    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgScore() {
        return avgScore;
    }

    @XmlTransient
    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    @XmlTransient
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    @XmlTransient
    public void setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
    }

    public List<String> getUniversityList() {
        return universityList;
    }

    @XmlTransient
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
