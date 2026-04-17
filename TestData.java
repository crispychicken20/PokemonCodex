import java.util.ArrayList;

/**
 * Provides unit testing functionality for data validation and display.
 * Offers methods to test file reading operations by displaying specific
 * portions of loaded data.
 * 
 * 
 * @author Christopher Perez
 * @version 3.0
 */
public class TestData {
    
    /**
     * Prints the first 7 and last 7 lines from the provided data collection.
     * 
     * @param dataContain an ArrayList of strings representing lines from a file,
     *                   where each string is one complete line of the file
     */
    public void testPrintFirstAndLastSeven(ArrayList<String> dataContain) {
        System.out.println("\n ---- first 7 lines ---");
            for(int i = 0; i < 7 && i < dataContain.size(); i++) {
                System.out.printf("%4d: %s%n", i + 1, dataContain.get(i));
                System.out.print(" ");
    
            }
    
            
            System.out.println("\n ---- last 7 lines ---");
            int lastSev = Math.max(1 - 1, dataContain.size() - 8);
            for(int i = lastSev; i < dataContain.size(); i++) {
                System.out.printf("%4d: %s%n", i + 1, dataContain.get(i));
                System.out.print(" ");
            }
            System.out.println();
    }
}