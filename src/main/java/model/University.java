package model;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Objects;

@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = {"id", "fullName", "mainProfile"})
public class University {

    @XmlElement(name = "universityId")
    @SerializedName(value = "University ID")
    private String id;

    @XmlElement(name = "universityName")
    @SerializedName(value = "University name")
    private String fullName;

    @XmlTransient
    @SerializedName(value = "Short name")
    private String shortName;

    @XmlTransient
    @SerializedName("Foundation year")
    private int yearOfFoundation;

    @XmlElement(name = "universityProfile")
    @SerializedName(value = "University profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @XmlTransient
    public University setId(String id) {
        this.id = id;
        return this;
    }

    @XmlTransient
    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @XmlTransient
    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    @XmlTransient
    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    @XmlTransient
    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "University: [ID: " + id +
                ", full name: " + fullName +
                ", short name: " + shortName +
                ", year of foundation: " + yearOfFoundation +
                ", main profile: " + mainProfile.getProfileName() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        University university = (University) obj;
        return this.getId().equals(university.getId()) &&
                this.getFullName().equals(university.getFullName()) &&
                this.getShortName().equals(university.getShortName()) &&
                this.getMainProfile() == university.getMainProfile() &&
                this.getYearOfFoundation() == university.getYearOfFoundation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, mainProfile, yearOfFoundation);
    }
}
