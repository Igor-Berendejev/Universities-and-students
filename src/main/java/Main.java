import jakarta.xml.bind.JAXBException;
import model.Statistics;
import model.Student;
import model.University;
import repository.*;
import model.DataStructure;
import service.Comparators;
import service.JsonUtil;
import service.StatisticsUtil;
import service.studentComparators.StudentComparator;
import service.studentComparators.StudentComparators;
import service.universityComparators.UniversityComparator;
import service.universityComparators.UniversityComparators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        try {
            InputStream stream = new FileInputStream("src/main/resources/logging.properties");
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        UniversityInfoReader uIReader = UniversityInfoReader.getInstance();
        String filePath = "src/main/resources/universityInfo.xlsx";
        uIReader.getStudentData(filePath);
        uIReader.getUniversityData(filePath);
        StudentComparator studNameComp = Comparators.getStudentComparator(StudentComparators.STUDENT_NAME_COMPARATOR);
        UniversityComparator univProfileComp = Comparators.getUniversityComparator(UniversityComparators.UNIVERSITY_PROFILE_COMPARATOR);
        Set<University> univSet = uIReader.getUniversities();
        Set<Student> studSet = uIReader.getStudents();

        univSet.stream()
                .sorted(univProfileComp)
                .limit(3)
                .map(JsonUtil::getUniversityJson)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);

        List<Statistics> stat = StatisticsUtil.getStatistics(studSet, univSet);
        System.out.println(stat);

        DataStructure dataStructure = new DataStructure(studSet, univSet);

        XmlWriter.getInstance().writeFile(dataStructure, "C:\\Users\\igor\\Documents\\xmlReqs");
        JsonWriter.getInstance().writeFile(dataStructure, "C:\\Users\\igor\\Documents\\jsonReqs");

        String writingPath = "src/main/resources/statistics.xlsx";
        XlsWriter writer = XlsWriter.getInstance();

        writer.writeXls(stat, writingPath);
    }
}
