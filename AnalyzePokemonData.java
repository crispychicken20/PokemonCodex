import java.util.ArrayList;
import java.util.HashSet;

/**
 * Analyzes Pokemon data from CSV format and extracts character information.
 * This class implements the IAnalyzePokemonData interface to provide
 * functionality for parsing and analyzing Pokemon character data.
 * 
 * <p>The class processes CSV data where character names are located at
 * index 30 of each comma-separated line.</p>
 * 
 * @author Christopher Perez
 * @version 3.0
 * @see IAnalyzePokemonData
 */
public class AnalyzePokemonData implements IAnalyzePokemonData {

    /**
     * Constructs a new AnalyzePokemonData instance.
     * Default constructor with no parameters.
     */
    public AnalyzePokemonData() {

    }

    /**
     * Extracts all unique Pokemon character names from the provided data.
     * 
     * <p>This method parses CSV-formatted data where each line represents
     * a Pokemon character. The character name is expected at index 30
     * of the comma-separated values. Names are cleaned by removing
     * quotation marks and stored in a HashSet to ensure uniqueness.</p>
     * 
     * <p>The method skips the first line (index 0) assuming it contains
     * header information.</p>
     * 
     * @param originalData an ArrayList containing CSV-formatted strings,
     *                     where each string represents one line of Pokemon data
     * @return a HashSet containing all unique Pokemon character names found
     *         in the data, with quotation marks removed
     * @throws IndexOutOfBoundsException if a line has fewer than 31 columns
     * @see HashSet
     * @see ArrayList
     */
    @Override
    public HashSet<String> getAllCharacterNames(ArrayList<String> originalData) {
        HashSet<String> characterNames = new HashSet<>();

        // Skip header row (i starts at 1)
        for (int i = 1; i < originalData.size(); i++) {
            String line = originalData.get(i);
            String[] columns = line.split(",");

            if (columns.length > 30) {
                String name = columns[30].trim();
                name = name.replace("\"", "");
                characterNames.add(name);
            }
        }
        return characterNames;
    }
    
}
