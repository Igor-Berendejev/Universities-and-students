import repository.UniversityInfoReader;
import service.Comparators;
import service.studentComparators.StudentComparator;
import service.studentComparators.StudentComparators;
import service.universityComparators.UniversityComparator;
import service.universityComparators.UniversityComparators;

public class Main {
    public static void main(String[] args) {
        UniversityInfoReader uIReader = UniversityInfoReader.getInstance();
        String filePath = "src/main/resources/universityInfo.xlsx";
        uIReader.getStudentData(filePath);
        uIReader.getUniversityData(filePath);
        StudentComparator studNameComp = Comparators.getStudentComparator(StudentComparators.STUDENT_NAME_COMPARATOR);
        UniversityComparator univProfileComp = Comparators.getUniversityComparator(UniversityComparators.UNIVERSITY_PROFILE_COMPARATOR);
        uIReader.getUniversities().stream().sorted(univProfileComp).forEach(System.out::println);
        uIReader.getStudents().stream().sorted(studNameComp).forEach(System.out::println);
    }
}
