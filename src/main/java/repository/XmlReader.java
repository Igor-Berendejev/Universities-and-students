package repository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Statistics;
import model.Student;
import model.University;
import model.DataStructure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class XmlReader {
    public static final Logger xmlReaderLogger = Logger.getLogger(XmlReader.class.getName());

    public static DataStructure getDataStructure(String filePath) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(DataStructure.class, Student.class, University.class, Statistics.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DataStructure) unmarshaller.unmarshal(new FileReader(filePath));
    }
}
