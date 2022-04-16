package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.util.HashSet;

public class JsonUtil {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
    }

    public static String getUniversityJson(University university) {
        return gson.toJson(university);
    }

    public static University universityFromJson(String universityJson) {
        return gson.fromJson(universityJson, University.class);
    }

    public static String getStudentJson(Student student) {
        return gson.toJson(student);
    }

    public static Student studentFromJson(String studentJson) {
        return gson.fromJson(studentJson, Student.class);
    }

    public static String getUniversityCollectionJson(HashSet<University> universityCollection) {
        return gson.toJson(universityCollection);
    }

    public static HashSet<University> universityCollectionFromJson(String universityCollectionJson) {
        return gson.fromJson(universityCollectionJson, new TypeToken<HashSet<University>>() {
        }.getType());
    }

    public static String getStudentCollectionJson(HashSet<Student> studentCollection) {
        return gson.toJson(studentCollection);
    }

    public static HashSet<Student> studentCollectionFromJson(String studentCollectionJson) {
        return gson.fromJson(studentCollectionJson, new TypeToken<HashSet<Student>>() {
        }.getType());
    }
}
