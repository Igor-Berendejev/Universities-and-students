package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Statistics;
import model.Student;
import model.University;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A utility class for mapping Student, University and their collections to a json
 */

public class JsonUtil {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
    }

    /**
     * Maps a University to json
     * @param university - a University object to be mapped to a json
     * @return a json representation of University received as a parameter
     */
    public static String getUniversityJson(University university) {
        return gson.toJson(university);
    }

    /**
     * Maps a json to University object
     * @param universityJson - a json representation of University
     * @return University object mapped from json
     */
    public static University universityFromJson(String universityJson) {
        return gson.fromJson(universityJson, University.class);
    }

    /**
     * Maps a Student to json
     * @param student - a Student object to be mapped to a json
     * @return a json representation of Student received as a parameter
     */
    public static String getStudentJson(Student student) {
        return gson.toJson(student);
    }

    /**
     * Maps a json to Student object
     * @param studentJson - a json representation of Student
     * @return Student object mapped from json
     */
    public static Student studentFromJson(String studentJson) {
        return gson.fromJson(studentJson, Student.class);
    }

    /**
     * Maps a University collection to a json
     * @param universityCollection a collection of University objects
     * @return a json representation of the collection received as a parameter
     */
    public static String getUniversityCollectionJson(Set<University> universityCollection) {
        return gson.toJson(universityCollection);
    }

    /**
     * Maps a json to a University collection
     * @param universityCollectionJson a json representation of University collection
     * @return a collection of Universities mapped from json
     */
    public static HashSet<University> universityCollectionFromJson(String universityCollectionJson) {
        return gson.fromJson(universityCollectionJson, new TypeToken<HashSet<University>>() {
        }.getType());
    }

    /**
     * Maps a Student collection to a json
     * @param studentCollection a collection of Student objects
     * @return a json representation of the collection received as a parameter
     */
    public static String getStudentCollectionJson(Set<Student> studentCollection) {
        return gson.toJson(studentCollection);
    }

    /**
     * Maps a json to a Student collection
     * @param studentCollectionJson a json representation of Student collection
     * @return a collection of Student mapped from json
     */
    public static HashSet<Student> studentCollectionFromJson(String studentCollectionJson) {
        return gson.fromJson(studentCollectionJson, new TypeToken<HashSet<Student>>() {
        }.getType());
    }

    /**
     * Maps a Statistics collection to a json
     * @param statisticsCollection a collection of Statistics objects
     * @return a json representation of the collection received as a parameter
     */
    public static String getStatisticsCollectionJson(List<Statistics> statisticsCollection) {
        return gson.toJson(statisticsCollection);
    }
}
