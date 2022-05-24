package repository;

import jakarta.xml.bind.*;
import model.Statistics;
import model.Student;
import model.University;
import model.DataStructure;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class XmlWriter extends DataStructureWriter {
    private static XmlWriter instance;
    public static final Logger xmlWriterLogger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter(){}

    public static XmlWriter getInstance() {
        if(instance == null) instance = new XmlWriter();
        return instance;
    }

    @Override
    public void writeFile(DataStructure dataStructure, String dirPath){
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(DataStructure.class, Student.class, University.class, Statistics.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e){
            xmlWriterLogger.severe("Could not create marshaller for DataStructure object. " + e.getMessage());
        }
        xmlWriterLogger.fine("Marshaller for DataStructure object created successfully");

        Path directory = null;
        try {
            Path path = Paths.get(dirPath);
            if (!Files.exists(path)) directory = Files.createDirectory(path);
            else directory = path;
        } catch (IOException e) {
            xmlWriterLogger.severe("Could not create or find path at " + dirPath + ". " + e.getMessage());
        }
        xmlWriterLogger.fine("Directory " + dirPath + " available for writing");

        xmlWriterLogger.info("creating file name");
        LocalDateTime timeStamp = dataStructure.getDateTime();
        String timeString = timeStamp.format(DateTimeFormatter.ISO_LOCAL_DATE);
        Path newFile = Paths.get( directory + "\\req_"+ timeString + ".xml");

        try {
            marshaller.marshal(dataStructure, new FileWriter(Files.createFile(newFile).toFile()));
        } catch (IOException e) {
            xmlWriterLogger.severe("Could not write file. " + e.getMessage());
        } catch (JAXBException e) {
            xmlWriterLogger.severe("Could not marshall DataStructure object. " + e.getMessage());
        }
        xmlWriterLogger.fine("Xml file successfully written.");
    }
}
