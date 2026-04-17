import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Implements file reading functionality for loading data from files.
 * Provides methods to open, validate, and read file contents into memory.
 * 

 * 
 * @author Christopher Perez
 * @version 3.0
 * @see IReadData
 * @see BufferedReader
 * @see FileReader
 */
public class ReadData implements IReadData {
    
    /** The name or path of the currently opened file */
    private String fileName;
    
    /** ArrayList storing the raw data read from the file, one line per element */
    private ArrayList<String> rawDataList;

    /**
     * Constructs a new ReadData instance.
     * 
     */
    public ReadData() {
        this.rawDataList = new ArrayList<>();
        this.fileName = "";
    }

    /**
     * Opens a data file for reading.
     * 
     * 
     * @param fileName the path or name of the file to open. Can be a relative
     *                 or absolute path (e.g., "data/pokemon.csv" or "/home/user/file.txt")
     * @return true if the file exists and was successfully prepared for reading,
     *         false if the file does not exist or cannot be accessed
     * 
     * @see #readDataFile()
     * @see File#exists()
     */
    @Override
    public boolean openDataFile(String fileName) {
        File file = new File(fileName);
        
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return false;
        }
        
        this.fileName = fileName;
        return true;
    }

    /**
     * Reads the contents of a previously opened file.
     * 
 
     * @return true if the file was successfully read and all lines stored
     *         in the data list, false if an IOException occurred during
     *         the read operation or if no file has been opened
     * 
     * @see openDataFile(String)
     * @see BufferedReader
     * @see IOException
     */
    @Override
    public boolean readDataFile() {
        try {
            rawDataList.clear();
            try(FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)) {
                    String line;
                    boolean done = false;
                    while(!done) {
                        line = br.readLine();
                        if(line == null) {
                            done = true;
                        }
                        else {
                            rawDataList.add(line);
                        }
                    }
                    return true;
                }
            
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
            return false;
        }
    }

    /**
     * Retrieves the raw data read from the file.
     * 
   
     * @return an ArrayList of strings, where each element is one complete
     *         line from the file, or an empty list if no data has been loaded
     * 
     * @see #readDataFile()
     */
    @Override
    public ArrayList<String> getRawDataList() {
        return rawDataList;
    }
}