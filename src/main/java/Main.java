public class Main {
    public static void main(String[] args) {
        UniversityInfoReader uIReader = UniversityInfoReader.getInstance();
        String filePath = "src/main/resources/universityInfo.xlsx";
        uIReader.getStudentData(filePath);
        uIReader.getUniversityData(filePath);
        uIReader.getUniversities().stream().forEach(System.out::println);
        uIReader.getStudents().stream().forEach(System.out::println);
    }
}
