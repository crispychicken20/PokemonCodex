import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * class meant to read input for reading a file
 * menu options fo user to open a file or exit
 * Sub menu to print first and last of a file or 
 * write a pokemon file with the names
 * also create a third option to search for a pokemon
 * @author Christopher Perez
 * @version 3.0
 */
// 
public class MyApp {
    /**
     * Contain data within a arraylist that will be used
     * to hold elements within a file
     */
    private ArrayList<String> dataContain;
    private ArrayList<PokemonCharacter> pokemonList;
    private CharacterSearchManager searchManager;
    private boolean dataLoaded;
    private MenuManager menuManager;

  
    private ReadData readData;
    private Scanner scnr;

    // Const variables indicated as our menu options 
    // for switch cases
    public static final  int EXIT_PROGRAM = 1;
    public static final  int OPEN_FILE = 2;
    public static final int SEARCH_CHARACTER = 3;
    public static final int CHARACTER_ATTRIBUTES = 4;
    public static final int UNIT_TESTING = 10;

    // Const varaibles used for sub menu options
    private final static int SUB_PRINT_SEVEN = 1;
    private final static int WRITE_CHARACTER_NAMES = 2;

    // Const variables used for secondary option menu
    private final static int HIT_POINT_VAL = 1;
    private final static int SPEED_VALUE = 2;

    // Const variables used for secondary level option
    // menu for character specfic hit point value
    private final static int SPECIFIC_HIT_POINT_VAL = 1;
    private final static int SPECIFIC_RANGE_OF_HITPOINTS = 2;
    private final static int LOWEST_HITPOINT_VAL = 3;
    private final static int HIGHEST_HITPOINT_VAL = 4;
    private final static int RETURN_PREV_MENU = 5;

    // Const variables for speed menu options
    private final static int FASTEST_SPEED = 1;
    private final static int SLOWEST_SPEED = 2;
    private final static int TOP_3_FASTEST = 3;
    private final static int TOP_3_SLOWEST = 4;
    private final static int SPECIFIC_RANGE_SPEED = 5;
    private final static int TOP_3_SPEED_GROUPS = 6;
    private final static int LARGEST_SPEED_GROUP = 7;
    private final static int RETURN_TO_PREV = 8;


    
    public MyApp() {
        this.readData = new ReadData();
        this.dataContain = new ArrayList<>();
        this.scnr = new Scanner(System.in);
        this.pokemonList = new ArrayList<>();
        this.dataLoaded = false;
        this.menuManager = new MenuManager();
    }
    

   
    
    /**
     * 
     * Reads in file from pokemon.csv
     * adds data into arrayList of type string
     * calls methods to open data file and read ot
     * @see pokemon.csv
     */
    public void openDataFile() {
            
        int attempts = 0;
        dataContain.clear();
        Scanner scnr = new Scanner(System.in);
        boolean success = false;
        File file = null;


        while(attempts < 2 && !success) {
            String fileName = scnr.nextLine();
            if (readData.openDataFile(fileName)) {
                if (readData.readDataFile()) {
                    dataContain = readData.getRawDataList();
                    System.out.println("File successfully opened and read!");
                    parseDataIntoPokemon();
                    success = true;
                } else {
                     System.out.println("Error reading the file. Please try again.");
                    attempts++;
                }
            } else {
                System.out.println("File not found. Please try again.");
                attempts++;
            }
                    
        }
    
    }

     /**
     * Parses raw data and creates PokemonCharacter objects
     * CSV structure: name (index 30), japanese_name (29), hp (28), speed (35), 
     * classification (24), pokedex_number (32)
     */
    private void parseDataIntoPokemon() {
        pokemonList.clear();
        
        // Skip header row (i starts at 1)
        for (int i = 1; i < dataContain.size(); i++) {
            String line = dataContain.get(i);
            String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Handle quoted commas
            
            try {
                if (parts.length < 36) {
                    continue; // Skip incomplete rows
                }
                
                String englishName = parts[30].trim().replaceAll("\"", "");
                String japaneseName = parts[29].trim().replaceAll("\"", "");
                String type = parts[24].trim().replaceAll("\"", ""); // classification
                int hitPoints = Integer.parseInt(parts[28].trim()); // hp column
                int speed = Integer.parseInt(parts[35].trim()); // speed column
                int pokedexNum = Integer.parseInt(parts[32].trim()); // pokedex_number
                
                PokemonCharacter pokemon = new PokemonCharacter(
                    englishName, japaneseName, hitPoints, speed, type, pokedexNum
                );
                pokemonList.add(pokemon);
            } catch (NumberFormatException e) {
                // Skip lines with invalid number formats
                System.err.println("Error parsing line " + i + ": " + e.getMessage());
            } catch (Exception e) {
                // Skip other malformed lines
                System.err.println("Error parsing line " + i + ": " + e.getMessage());
            }
        }
        
        // Initialize search manager with loaded data
        searchManager = new CharacterSearchManager(pokemonList);
        dataLoaded = true;
        System.out.println("Successfully loaded " + pokemonList.size() + " Pokemon characters.");
    }
     /**
     * Handles the unit testing sub-menu
     */
    public void handleUnitTesting() {
        MenuManager menu = new MenuManager();
        if (dataContain.isEmpty()) {
            System.out.println("No data loaded. Please open a file first.");
            return;
        }
        int subMenuOptions = menu.showSubMenu();

        switch(subMenuOptions) {
            case SUB_PRINT_SEVEN:
                TestData testData = new TestData();
                testData.testPrintFirstAndLastSeven(dataContain);
                break;
            case WRITE_CHARACTER_NAMES:
                handleWriteCharacterNames();
                break;

            default:
                System.out.println("Invalid options...");
        }
    }

    /**
     * Handles writing character names to a file
     */
    private void handleWriteCharacterNames() {
        Scanner scnr = new Scanner(System.in);
        AnalyzePokemonData analyzer = new AnalyzePokemonData();
        HashSet<String> characterNames = analyzer.getAllCharacterNames(dataContain);
        
        if (characterNames.isEmpty()) {
            System.out.println("No character names found.");
            return;
        }
        
        System.out.print("Enter output filename (e.g., pokemon_names.txt): ");
        String outputFile = scnr.nextLine();
        
        WriteData writer = new WriteData();
        if (writer.writeDataToFile(characterNames, outputFile)) {
            System.out.println("Character names successfully written to " + outputFile);
            System.out.println("Total characters: " + characterNames.size());
        } else {
            System.out.println("Error writing to file.");
        }
    }

    public void handleCharacterAttributes() {
        int charMenu = menuManager.showSecondarySubMenu();
        switch (charMenu) {
            case HIT_POINT_VAL:
                handleHitPointSearch();
                break;

            case SPEED_VALUE:
                handleSpeedSearch();
                break;

            default:
                throw new AssertionError();
        }
    }

    private void handleHitPointSearch() {
        boolean stayInMenu = true;
        
        while (stayInMenu) {
            int choice = menuManager.showCharacterAttributesSpecificHitMenu();
            TreeSet<PokemonCharacter> results = null;
            
            switch (choice) {
                case SPECIFIC_HIT_POINT_VAL:
                    results = searchManager.searchBySpecificHitPoint();
                    searchManager.displayResults(results);
                    break;
                    
                case SPECIFIC_RANGE_OF_HITPOINTS:
                    results = searchManager.searchByHitPointRange();
                    searchManager.displayResults(results);
                    break;
                    
                case LOWEST_HITPOINT_VAL:
                    results = searchManager.findLowestHitPoint();
                    searchManager.displayResults(results);
                    break;
                    
                case HIGHEST_HITPOINT_VAL:
                    results = searchManager.findHighestHitPoint();
                    searchManager.displayResults(results);
                    break;
                    
                case RETURN_PREV_MENU:
                    System.out.println("Returning to previous menu...");
                    handleCharacterAttributes();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
     /**
     * Handles speed search menu and operations
     */
    private void handleSpeedSearch() {
        boolean stayInMenu = true;
        
        while (stayInMenu) {
            int choice = menuManager.showCharacterSpeedValueMenu();
            TreeSet<PokemonCharacter> results = null;
            
            switch (choice) {
                case FASTEST_SPEED:
                    results = searchManager.findHighestSpeed();
                    searchManager.displayResults(results);
                    break;
                    
                case SLOWEST_SPEED:
                    results = searchManager.findLowestSpeed();
                    searchManager.displayResults(results);
                    break;
                    
                case TOP_3_FASTEST:
                    results = searchManager.findTop3FastestSpeeds();
                    searchManager.displayResults(results);
                    break;
                    
                case TOP_3_SLOWEST:
                    results = searchManager.findTop3SlowestSpeeds();
                    searchManager.displayResults(results);
                    break;
                    
                case SPECIFIC_RANGE_SPEED:
                    results = searchManager.searchBySpeedRange();
                    searchManager.displayResults(results);
                    break;
                    
                case TOP_3_SPEED_GROUPS:
                    searchManager.displayTop3SpeedGroups();
                    break;
                    
                case LARGEST_SPEED_GROUP:
                    searchManager.displayLargestSpeedGroup();
                    break;
                    
                case RETURN_TO_PREV:
                    System.out.println("Returning to previous menu...");
                    handleCharacterAttributes();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /**
     * Handles searching for a character by name
     */   
    public void handleSearchCharacter() {
        if (dataContain.isEmpty()) {
            System.out.println("No data loaded. Please open a file first.");
            return;
        }
        
        // Get all character names and sort them
        AnalyzePokemonData analyzer = new AnalyzePokemonData();
        HashSet<String> characterNames = analyzer.getAllCharacterNames(dataContain);
        TreeSet<String> sortedNames = new TreeSet<>(characterNames);
        
        System.out.print("Enter the Pokemon name to search for: ");
        String searchName = scnr.nextLine().trim();
        
        // Check if character exists in sorted list
        if (!sortedNames.contains(searchName)) {
            System.out.println("Pokemon '" + searchName + "' not found in the database.");
            return;
        }
        
        // Find and print the row data for the character
        for (String line : dataContain) {
            String[] columns = line.split(",");
            if (columns.length > 30) {
                String name = columns[30].trim().replace("\"", "");
                if (name.equals(searchName)) {
                    System.out.println("\n---- Pokemon Found ----");
                    System.out.println(line);
                    return;
                }
            }
        }
    }

    
    
        /**
         * methods called within main to handle the menu application
         * 
         * @param args
         */
    public static void main(String[] args) {
        MyApp app = new MyApp();
        MenuManager menuOpt = new MenuManager();
        boolean running = true;
        
        while(running) {
            int menuOptions = menuOpt.showMainMenu();
            
            switch (menuOptions) {
                case MyApp.EXIT_PROGRAM:
                    System.out.println("Exiting... Thanks for using this application");
                    running = false;
                    break;
                case MyApp.OPEN_FILE:
                    System.out.print("Enter the file name: ");
                    app.openDataFile();
                    break;
                case MyApp.UNIT_TESTING:
                    app.handleUnitTesting();
                    break;
                case MyApp.CHARACTER_ATTRIBUTES:
                    //method to sub-menu
                    app.handleCharacterAttributes();
                    break;
                case MyApp.SEARCH_CHARACTER:
                    app.handleSearchCharacter();
                    break;
                default:
                    System.out.println("Error: must enter a number of either 1, 2, 3, or 10");
                    break;
            }
        }
    }
}