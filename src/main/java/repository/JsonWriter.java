package repository;

import model.Statistics;
import model.Student;
import model.University;
import model.DataStructure;
import service.JsonUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class JsonWriter extends DataStructureWriter {

    private static JsonWriter instance;
    public static final Logger jsonWriterLogger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter(){}

    public static JsonWriter getInstance(){
        if(instance == null) instance = new JsonWriter();
        return instance;
    }

    @Override
    public void writeFile(DataStructure dataStructure, String dirPath) {
        jsonWriterLogger.info("Extracting data from DataStructure object");
        Set<Student> studentSet = dataStructure.getStudentSet();
        Set<University> universitySet = dataStructure.getUniversitySet();
        List<Statistics> statisticsList = dataStructure.getStatisticsList();

        Path directory = null;
        try {
            Path path = Paths.get(dirPath);
            if (!Files.exists(path)) directory = Files.createDirectory(path);
            else directory = path;
        } catch (IOException e) {
            jsonWriterLogger.severe("Could not create or find path at " + dirPath + ". " + e.getMessage());
        }
        jsonWriterLogger.fine("Directory " + dirPath + " available for writing");

        jsonWriterLogger.info("creating file name");
        LocalDateTime timeStamp = dataStructure.getDateTime();
        String timeString = timeStamp.format(DateTimeFormatter.ISO_LOCAL_DATE);
        Path newFile = Paths.get( directory + "\\req_"+ timeString + ".json");

        try(FileWriter writer = new FileWriter(Files.createFile(newFile).toFile())){
            writer.write(JsonUtil.getStudentCollectionJson(studentSet));
            writer.write(JsonUtil.getUniversityCollectionJson(universitySet));
            writer.write(JsonUtil.getStatisticsCollectionJson(statisticsList));
        }catch (IOException e){
            jsonWriterLogger.severe("Could not write file. " + e.getMessage());
        }
        jsonWriterLogger.fine("Json file successfully written.");
    }
}
