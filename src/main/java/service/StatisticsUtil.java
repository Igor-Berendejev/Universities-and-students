package service;

import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.*;

public class StatisticsUtil {
    public static final Logger statisticsLogger = Logger.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil() {
    }

    public static List<Statistics> getStatistics(Set<Student> studentSet, Set<University> universitySet) {
        statisticsLogger.info("Extracting statistics");
        List<Statistics> profiles = universitySet.stream()
                .map(University::getMainProfile)
                .distinct()
                .map(Statistics::new)
                .toList();

        profiles.stream()
                .forEach(stat -> {
                    List <String> univIds = new ArrayList<>();
                    universitySet.stream()
                            .filter(u -> u.getMainProfile().equals(stat.getStudyProfile()))
                            .forEach(u -> {
                                stat.setNumberOfUniversities(stat.getNumberOfUniversities() + 1);
                                stat.getUniversityList().add(u.getFullName());
                                univIds.add(u.getId());
                            });
                    stat.setNumberOfUniversities(univIds.size());
                    statisticsLogger.info("Universities statistics added for " + stat.getStudyProfile());
                    List<Student> students = studentSet.stream().filter(stud -> univIds
                            .contains(stud.getUniversityId())).toList();
                    stat.setNumberOfStudents(students.size());
                    OptionalDouble avg = students
                            .stream()
                            .mapToDouble(Student::getAvgExamScore)
                            .average();
                    stat.setAvgScore(0);
                    avg.ifPresent(score -> stat.setAvgScore(BigDecimal.valueOf(score)
                            .setScale(2 ,RoundingMode.HALF_UP).doubleValue()));
                    statisticsLogger.info("Statistics completed for study profile " + stat.getStudyProfile());
                });
        statisticsLogger.fine("Successfully created collection of Statistics");
        return profiles;
    }
}
