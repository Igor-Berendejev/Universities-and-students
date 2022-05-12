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
import java.util.logging.*;

/**
Reads an Excel file containing sheets "Студенты" and "Университеты" and adds Student and University objects to
 respective collections
 */

public class UniversityInfoReader {

    private static UniversityInfoReader INSTANCE;
    private Set<Student> students = new HashSet<Student>();
    private Set<University> universities = new HashSet<University>();
    public static final Logger readerLogger = Logger.getLogger(UniversityInfoReader.class.getName());

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

    /**
     * Reads an Excel file from the path received as a parameter,
     * creates a Student object from every row of the file and adds it to the collection.
     * @param filePath - a path (String) to the location of file containing information about Students
     */

    public void getStudentData(String filePath) {
        readerLogger.info("Extracting Student data at " + filePath);
        try (InputStream univFileStream = new FileInputStream(filePath)) {
            XSSFWorkbook workbookReader = new XSSFWorkbook(univFileStream);
            XSSFSheet studentsSheet = workbookReader.getSheet("Студенты");
            readerLogger.fine("Opened workbook sheet \"Студенты\" at: " + filePath);
            Iterator studentsSheetIterator = studentsSheet.iterator();
            studentsSheetIterator.next();
            while (studentsSheetIterator.hasNext()) {
                Row row = (Row) studentsSheetIterator.next();
                String universityId = row.getCell(0).getStringCellValue();
                String studentName = row.getCell(1).getStringCellValue();
                int course = (int) row.getCell(2).getNumericCellValue();
                float avgResult = (float) row.getCell(3).getNumericCellValue();
                if (!students.add(new Student(studentName, universityId, course, avgResult)))
                    readerLogger.warning("Failed to add student from row " + row.getRowNum());
            }
        } catch (IOException e) {
            readerLogger.severe(e.getMessage());
        }
        readerLogger.fine("Students sheet reading completed");
    }

    /**
     * Reads an Excel file from the path received as a parameter,
     * creates a University object from every row of the file and adds it to the collection.
     * @param filePath - a path (String) to the location of file containing information about Students
     */

    public void getUniversityData(String filePath) {
        readerLogger.info("Extracting University data at " + filePath);
        try (InputStream univFileStream = new FileInputStream(filePath)) {
            XSSFWorkbook workbookReader = new XSSFWorkbook(univFileStream);
            XSSFSheet universitiesSheet = workbookReader.getSheet("Университеты");
            readerLogger.fine("Opened workbook sheet \"Университеты\" at: " + filePath);
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
                    if (!universities.add(new University(uId, uFullName, uShortName, yearOfFoundation, profile)))
                        readerLogger.warning("Failed to add university from row " + row.getRowNum());
                } catch (IllegalArgumentException profileExc) {
                    readerLogger.severe("Invalid study profile at " + row.getRowNum() + ". " + profileExc.getMessage());
                }
            }
        } catch (IOException e) {
            readerLogger.severe(e.getMessage());
        }
        readerLogger.fine("University sheet reading completed");
    }
}
