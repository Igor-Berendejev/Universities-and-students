package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import service.DateAdapter;
import service.StatisticsUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "root")
public class DataStructure {

    @XmlElementWrapper(name = "studentsInfo")
    private Set<Student> studentSet;

    @XmlElementWrapper(name = "universitiesInfo")
    private Set<University> universitySet;

    @XmlElementWrapper(name = "statisticalInfo")
    private List<Statistics> statisticsList;

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "processedAt")
    private LocalDateTime dateTime;

    public DataStructure() {
    }

    public DataStructure(Set<Student> studentSet, Set<University> universitySet){
        this.studentSet = studentSet;
        this.universitySet = universitySet;
        this.statisticsList = StatisticsUtil.getStatistics(studentSet, universitySet);
        this.dateTime = LocalDateTime.now();
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public Set<University> getUniversitySet() {
        return universitySet;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
