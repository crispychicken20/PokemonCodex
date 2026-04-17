import java.util.Scanner;

/**
 * Manages all menu displays and user input collection.
 * Provides a centralized interface for presenting various menu/submenu options
 * to the user and capturing their selections.
 * 
\
 * 
 * @author Christopher Perez
 * @version 3.0
 * @see Scanner
 */
public class MenuManager {
    
    /** Scanner instance for reading user input from standard input */
    private Scanner scnr;

    /**
     * Constructs a new MenuManager instance.
     * 
     * <p>Initializes the Scanner for reading user input from standard input (System.in).
     * The Scanner is created with System.in as the input source and will remain
     * open for the lifetime of this MenuManager instance.</p>
     */
    public MenuManager() {
        this.scnr = new Scanner(System.in);
    }

    /**
     * Displays the main menu and returns the user's choice.
     * 
     * <p>Shows the primary menu options available in the application:
     * <ul>
     *     <li>1 - Exit the program</li>
     *     <li>2 - Open a data file (Pokemon CSV file)</li>
     *     <li>3 - Search for a specific character by name</li>
     *     <li>4 - Find characters by attributes (hit points, speed)</li>
     *     <li>10 - Run unit testing</li>
     * </ul>
     * </p>
     * 
     * @return the integer value representing the user's selected menu option.
     *         Valid options are 1, 2, 3, 4, or 10. Returns 0 for invalid input.
     * 
     * @see #getUserInput()
     */
    public int showMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Exit");
        System.out.println("2. Open Data File");
        System.out.println("3. Search for a Character");
        System.out.println("4. Find Characters by Attributes");
        System.out.println("10. Unit Testing");
        System.out.print("Enter your choice: ");
        return getUserInput();
    }

    /**
     * Displays the sub menu for file operations and returns the user's choice.
     * 
     * <p>Shows options for unit testing file operations:
     * <ul>
     *     <li>1 - Print the first 7 and last 7 lines of the loaded file</li>
     *     <li>2 - Write all unique character names to a file</li>
     * </ul>
     * </p>
     * 
     * <p>This menu is displayed when the user selects the Unit Testing option
     * from the main menu.</p>
     * 
     * @return the integer value representing the user's selected option (1 or 2).
     *         Returns 0 for invalid input.
     * 
     * @see #showMainMenu()
     * @see #getUserInput()
     */
    public int showSubMenu() {
        System.out.println("--- Sub Menu ---");
        System.out.println("1. Print first 7 and last 7 lines");
        System.out.println("2. Write character names to a file");
        System.out.print("Enter your choice: ");
        return getUserInput();
    }

    /**
     * Displays the secondary sub menu for character attribute searches.
     * 
     * 
     * @return the integer value representing the user's selected attribute type.
     *         Valid values are 1 (hit points) or 2 (speed). Returns 0 for invalid input.
     * 
     * @see #showCharacterAttributesSpecificHitMenu()
     * @see #showCharacterSpeedValueMenu()
     * @see #getUserInput()
     */
    public int showSecondarySubMenu() {
        System.out.println("--- Character Attribute Menu ---");
        System.out.println("1. Get all characters with a specific hit point value");
        System.out.println("2. Get all characters with a specific speed value");
        System.out.print("Enter (1 or 2): ");
        return getUserInput();
    }

    /**
     * Displays the menu for searching characters by hit point values.
     * 
   
     * @return the integer value representing the user's selected search option.
     *         Valid values are 1-5. Returns 0 for invalid input.
     * 
     * @see #showSecondarySubMenu()
     * @see #getUserInput()
     */
    public int showCharacterAttributesSpecificHitMenu() {
        System.out.println("1. Find a character with a specific hit point value");
        System.out.println("2. Find characters within a specific range of hit values");
        System.out.println("3. Find the character with the lowest hit point value");
        System.out.println("4. Find the character with the highest hit point value");
        System.out.println("5. Go back to the previous menu");
        return getUserInput();
    }

    /**
     * Displays the menu for searching characters by speed values.
     * 
     * 
     * @return the integer value representing the user's selected speed search option.
     *         Valid values are 1-8. Returns 0 for invalid input.
     * 
     * @see #showSecondarySubMenu()
     * @see #getUserInput()
     */
    public int showCharacterSpeedValueMenu() {
        System.out.println("1. Which character has the fastest speed");
        System.out.println("2. Which character has the slowest speed");
        System.out.println("3. Which characters are part of the top 3 fastest speeds");
        System.out.println("4. Which characters are part of the 3 slowest speeds");
        System.out.println("5. Which characters are part of a specific range of speeds");
        System.out.println("6. What are the top 3 speed groups, and what is the list of characters which are part of each speed group");
        System.out.println("7. Which group of characters represent the largest speed group");
        System.out.println("8. Go back to the previous menu");
        return getUserInput();
    }

    /**
     * Safely retrieves integer input from the user.
     * 
     * @return the integer value entered by the user. Returns 0 if the input
     *         is invalid or cannot be parsed as an integer.
     * 
     * @see Scanner#nextInt()
     * @see Scanner#nextLine()
     */
    private int getUserInput() {
        try {
            return scnr.nextInt();
        } catch (Exception e) {
            scnr.nextLine(); // Clear invalid input from scanner buffer
            return 0; // Return 0 to indicate invalid input
        }
    }
}