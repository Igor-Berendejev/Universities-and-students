package repository;

import model.DataStructure;

public abstract class DataStructureWriter {

    public abstract void writeFile(DataStructure dataStructure, String dirPath);
}
