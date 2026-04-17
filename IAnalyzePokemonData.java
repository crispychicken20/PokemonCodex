import java.util.ArrayList;
import java.util.HashSet;

/**
 * Interface for analyzing Pokemon data extracted from CSV format.
 * Defines contract for classes that parse and extract character information
 * from raw CSV-formatted data.
 * 
 *  
 * @author Christopher Perez
 * @version 3.0
 */
public interface IAnalyzePokemonData {

    /**
     * Extracts all unique Pokemon character names from the provided data.
     * 
     * Parses CSV-formatted data and retrieves character names from a
     * predetermined column index. Implementations should handle quotation
     * marks and whitespace appropriately.
     * 
     * @param originalData an ArrayList containing CSV-formatted strings,
     *                     where each string represents one line of Pokemon data
     * @return a HashSet containing all unique Pokemon character names found
     *         in the data, with special characters cleaned
     * @throws IndexOutOfBoundsException if a line has fewer expected columns
     */
    HashSet<String> getAllCharacterNames(ArrayList<String> originalData);
}