package repository;

import model.Statistics;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class XlsWriter {

    private static XlsWriter INSTANCE;

    private XlsWriter(){}

    public static XlsWriter getInstance(){
        if (INSTANCE == null) INSTANCE = new XlsWriter();
        return INSTANCE;
    }

    public void writeXls(List<Statistics> statisticsList, String filePath){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statSheet = workbook.createSheet("Statistics");
        int rowCount = 0;

        //Create a header
        Row header = statSheet.createRow(rowCount++);

        CellStyle headerStyle = boldHeight12(workbook);

        int cellCount = 0;
        header.createCell(cellCount++).setCellValue("Study profile");
        header.createCell(cellCount++).setCellValue("Average score");
        header.createCell(cellCount++).setCellValue("Number of students");
        header.createCell(cellCount++).setCellValue("Number of universities");
        header.createCell(cellCount++).setCellValue("Universities");
        header.forEach(c-> c.setCellStyle(headerStyle));

        // fill the sheet with statistics
        for (Statistics s : statisticsList){
            Row row = statSheet.createRow(rowCount++);
            cellCount = 0;

            row.createCell(cellCount++).setCellValue(s.getStudyProfile().getProfileName());
            row.createCell(cellCount++).setCellValue(s.getAvgScore());
            row.createCell(cellCount++).setCellValue(s.getNumberOfStudents());
            row.createCell(cellCount++).setCellValue(s.getNumberOfUniversities());
            row.createCell(cellCount++).setCellValue(s.getUniversityList()
                    .stream()
                    .collect(Collectors.joining(", ")));

            // write sheet to a file
            try (FileOutputStream fos = new FileOutputStream(filePath)){
                workbook.write(fos);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private CellStyle boldHeight12(XSSFWorkbook workbook){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        return  headerStyle;
    }
}
