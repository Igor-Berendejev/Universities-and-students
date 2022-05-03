import model.Statistics;
import model.Student;
import model.University;
import repository.UniversityInfoReader;
import repository.XlsWriter;
import service.Comparators;
import service.JsonUtil;
import service.StatisticsUtil;
import service.studentComparators.StudentComparator;
import service.studentComparators.StudentComparators;
import service.universityComparators.UniversityComparator;
import service.universityComparators.UniversityComparators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UniversityInfoReader uIReader = UniversityInfoReader.getInstance();
        String filePath = "src/main/resources/universityInfo.xlsx";
        uIReader.getStudentData(filePath);
        uIReader.getUniversityData(filePath);
        StudentComparator studNameComp = Comparators.getStudentComparator(StudentComparators.STUDENT_NAME_COMPARATOR);
        UniversityComparator univProfileComp = Comparators.getUniversityComparator(UniversityComparators.UNIVERSITY_PROFILE_COMPARATOR);
        Set<University> univSet = uIReader.getUniversities();
        Set<Student> studSet = uIReader.getStudents();

        // Serializing Students and Universities collections
        String univJsonString = JsonUtil.getUniversityCollectionJson(univSet);
        String studJsonString = JsonUtil.getStudentCollectionJson(studSet);
        System.out.println(univJsonString);
        System.out.println("\n-----------------------------\n");
        System.out.println(studJsonString);

        // Deserializing Students and Universities collections
        HashSet<University> newUnivSet = JsonUtil.universityCollectionFromJson(univJsonString);
        HashSet<Student> newStudSet = JsonUtil.studentCollectionFromJson(studJsonString);
        System.out.println("Initial university set size: " + univSet.size() + ", new set size " + newUnivSet.size());
        System.out.println("Initial student set size: " + studSet.size() + ", new set size " + newStudSet.size());

        univSet.stream()
                .sorted(univProfileComp)
                .limit(3)
                .map(JsonUtil::getUniversityJson)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);

        List<Statistics> stat = StatisticsUtil.getStatistics(studSet, univSet);
        System.out.println(stat);

        String writingPath = "src/main/resources/statistics.xlsx";
        XlsWriter writer = XlsWriter.getInstance();

        writer.writeXls(stat, writingPath);
    }
}
