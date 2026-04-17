/**
 * Interface for writing data from files.
 * Defines contract for classes that handle file input operations,
 * including opening files and writing their contents into memory.
 * 
 *
 * 
 * @author Christopher Perez
 * @version 3.0
 */
import java.util.HashSet;

 /**
* Writes the contents of data from files.
* 
* Processes the file line-by-line and stores the data internally
* for retrieval. Should handle IOException gracefully.
*
* @return true if the file was successfully writen and stored,
*         false if an error occurred during writing
*/
public interface IWriteData {
    boolean writeDataToFile(HashSet<String> someData, String fileName);
}
