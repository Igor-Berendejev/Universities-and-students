# Universities-and-students

The program for work with Students and Universities.

UniversityInfoReader class allows to read an excel file containing information about Students and Universities and create respective objects
and collections of objects basing on the file data.

Students and Universities can be compared on every parameter of the class using respective comparators. Enums are available for both Students and
Universities comparators and user can get a needed comparator by calling static methods of Comparators class

![image](https://user-images.githubusercontent.com/90723839/164557000-189a8b9a-2e7b-4905-9143-bac14bb8c026.png)

Static methods of JsonUtil class enable serialization and deserialization of Student and University objects and their collections.

```java

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

```

