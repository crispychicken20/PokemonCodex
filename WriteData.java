import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Implements file writing functionality for persisting data to files.
 * Provides methods to write collection data to disk in a line-delimited format.
 * 
 * @author Christopher Perez
 * @version 3.0
 * @see IWriteData
 * @see PrintWriter
 * @see FileWriter
 */
public class WriteData implements IWriteData {
    
    /**
     * Constructs a new WriteData instance.
     * 
     */
    public WriteData() {
    }

    /**
     * Writes a collection of data to a file.
     * 
     * 
     * @param someData a HashSet containing string data elements to be written.
     *                 Each element is written on a separate line. An empty
     *                 HashSet will result in an empty file being created.
     *                 Null values within the set will be written as the string "null".
     * 
     * @param fileName the path or name of the file to write to. Can be a relative
     *                 or absolute path (e.g., "output/names.txt", "/home/user/data.txt",
     *                 or "C:\\Users\\Data\\file.txt" on Windows).
     *                 If the directory path does not exist, an IOException will be thrown.
     *                 If the file name is empty or null, an IOException may occur.
     * 
     * @return true if the data was successfully written to the file and the
     *         operation completed without exceptions. Returns false if an IOException
     *         occurred at any point during file creation or writing operations.
     * 
     * @throws IOException implicitly caught within this method - any IOException
     *                     from FileWriter or PrintWriter operations is caught,
     *                     logged, and converted to a boolean return value
     * 
     * @see HashSet
     * @see PrintWriter
     * @see FileWriter
     * @see IOException
     * @see IWriteData#writeDataToFile(HashSet, String)
     */
    @Override
    public boolean writeDataToFile(HashSet<String> someData, String fileName) {
        try {
            try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for(String data : someData) {
                    writer.println(data);
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error writing in file: " + e.getMessage());
            return false;
        }
    }
}