import java.util.ArrayList;

/**
 * Interface for reading data from files.
 * Defines contract for classes that handle file input operations,
 * including opening files and reading their contents into memory.
 * 

 * 
 * @author Christopher Perez
 * @version 3.0
 */
public interface IReadData {
    
    /**
     * Opens a data file for reading.
     * 
     * Verifies that the specified file exists and is accessible
     * before attempting to read from it.
     * 
     * @param fileName the path or name of the file to open
     * @return true if the file was successfully opened, false otherwise
     */
    boolean openDataFile(String fileName);

    /**
     * Reads the contents of a previously opened file.
     * 
     * Processes the file line-by-line and stores the data internally
     * for retrieval. Should handle IOException gracefully.
     * 
     * @return true if the file was successfully read and stored,
     *         false if an error occurred during reading
     */
    boolean readDataFile();

    /**
     * Retrieves the raw data read from the file.
     * 
     * <p>Returns the complete file contents as a list of strings,
     * where each string represents one line from the file.</p>
     * 
     * @return an ArrayList containing all lines read from the file,
     *         or an empty list if no file has been read
     */
    ArrayList<String> getRawDataList();
}