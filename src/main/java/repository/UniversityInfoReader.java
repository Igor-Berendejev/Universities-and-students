package repository;

import model.Student;
import model.StudyProfile;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniversityInfoReader {
    private static UniversityInfoReader INSTANCE;
    private Set<Student> students = new HashSet<Student>();
    private Set<University> universities = new HashSet<University>();

    private UniversityInfoReader() {
    }

    public static UniversityInfoReader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UniversityInfoReader();
        }
        return INSTANCE;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<University> getUniversities() {
        return universities;
    }

    public void getStudentData(String filePath) {
        try (InputStream univFileStream = new FileInputStream(filePath)) {
            XSSFWorkbook workbookReader = new XSSFWorkbook(univFileStream);
            XSSFSheet studentsSheet = workbookReader.getSheet("Студенты");
            Iterator studentsSheetIterator = studentsSheet.iterator();
            studentsSheetIterator.next();
            while (studentsSheetIterator.hasNext()) {
                Row row = (Row) studentsSheetIterator.next();
                String universityId = row.getCell(0).getStringCellValue();
                String studentName = row.getCell(1).getStringCellValue();
                int course = (int) row.getCell(2).getNumericCellValue();
                float avgResult = (float) row.getCell(3).getNumericCellValue();
                students.add(new Student(studentName, universityId, course, avgResult));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUniversityData(String filePath) {
        try (InputStream univFileStream = new FileInputStream(filePath)) {
            XSSFWorkbook workbookReader = new XSSFWorkbook(univFileStream);
            XSSFSheet universitiesSheet = workbookReader.getSheet("Университеты");
            Iterator universitiesSheetIterator = universitiesSheet.iterator();
            universitiesSheetIterator.next();
            while (universitiesSheetIterator.hasNext()) {
                Row row = (Row) universitiesSheetIterator.next();
                String uId = row.getCell(0).getStringCellValue();
                String uFullName = row.getCell(1).getStringCellValue();
                String uShortName = row.getCell(2).getStringCellValue();
                int yearOfFoundation = (int) row.getCell(3).getNumericCellValue();
                try {
                    StudyProfile profile = StudyProfile.valueOf(row.getCell(4).getStringCellValue());
                    universities.add(new University(uId, uFullName, uShortName, yearOfFoundation, profile));
                } catch (IllegalArgumentException profileExc) {
                    System.out.println("Invalid profile in the table for university " + uFullName + profileExc.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
