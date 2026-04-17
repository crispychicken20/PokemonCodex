import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Manages character searches based on hit points and speed values.
 * Automatically determines and displays valid ranges.
 * 
 * @author Christopher Perez
 * @version 1.0
 */
public class CharacterSearchManager {
    private ArrayList<PokemonCharacter> allCharacters;
    private Scanner scnr;

    public CharacterSearchManager(ArrayList<PokemonCharacter> characters) {
        this.allCharacters = characters;
        this.scnr = new Scanner(System.in);
    }

    /**
     * Gets the minimum and maximum hit points from all characters
     * @return int array [min, max]
     */
    public int[] getHitPointRange() {
        if (allCharacters.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (PokemonCharacter character : allCharacters) {
            int hp = character.getHitPoints();
            if (hp < min) min = hp;
            if (hp > max) max = hp;
        }
        
        return new int[]{min, max};
    }

    /**
     * Gets the minimum and maximum speed values from all characters
     * @return int array [min, max]
     */
    public int[] getSpeedRange() {
        if (allCharacters.isEmpty()) {
            return new int[]{0, 0};
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (PokemonCharacter character : allCharacters) {
            int speed = character.getSpeed();
            if (speed < min) min = speed;
            if (speed > max) max = speed;
        }
        
        return new int[]{min, max};
    }

    /**
     * Searches for characters with a specific hit point value
     * Returns results sorted by hit points in ascending order
     * @return TreeSet of matching characters
     */
    public TreeSet<PokemonCharacter> searchBySpecificHitPoint() {
        int[] range = getHitPointRange();
        System.out.println("Hit Point range: " + range[0] + " - " + range[1]);
        System.out.print("Enter specific hit point value: ");
        int targetHP = scnr.nextInt();
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_HIT_POINTS);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getHitPoints() == targetHP) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Searches for characters within a range of hit points
     * Returns results sorted by hit points in ascending order
     * @return TreeSet of matching characters
     */
    public TreeSet<PokemonCharacter> searchByHitPointRange() {
        int[] range = getHitPointRange();
        System.out.println("Hit Point range: " + range[0] + " - " + range[1]);
        System.out.print("Enter minimum hit point value: ");
        int minHP = scnr.nextInt();
        System.out.print("Enter maximum hit point value: ");
        int maxHP = scnr.nextInt();
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_HIT_POINTS);
        
        for (PokemonCharacter character : allCharacters) {
            int hp = character.getHitPoints();
            if (hp >= minHP && hp <= maxHP) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Finds character(s) with the lowest hit point value
     * @return TreeSet of characters with lowest HP
     */
    public TreeSet<PokemonCharacter> findLowestHitPoint() {
        int[] range = getHitPointRange();
        int lowestHP = range[0];
        System.out.println("Lowest hit point value: " + lowestHP);
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_HIT_POINTS);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getHitPoints() == lowestHP) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Finds character(s) with the highest hit point value
     * @return TreeSet of characters with highest HP
     */
    public TreeSet<PokemonCharacter> findHighestHitPoint() {
        int[] range = getHitPointRange();
        int highestHP = range[1];
        System.out.println("Highest hit point value: " + highestHP);
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_HIT_POINTS);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getHitPoints() == highestHP) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Searches for characters with a specific speed value
     * Returns results sorted by speed in ascending order
     * @return TreeSet of matching characters
     */
    public TreeSet<PokemonCharacter> searchBySpecificSpeed() {
        int[] range = getSpeedRange();
        System.out.println("Speed range: " + range[0] + " - " + range[1]);
        System.out.print("Enter specific speed value: ");
        int targetSpeed = scnr.nextInt();
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getSpeed() == targetSpeed) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Searches for characters within a range of speed values
     * Returns results sorted by speed in ascending order
     * @return TreeSet of matching characters
     */
    public TreeSet<PokemonCharacter> searchBySpeedRange() {
        int[] range = getSpeedRange();
        System.out.println("Speed range: " + range[0] + " - " + range[1]);
        System.out.print("Enter minimum speed value: ");
        int minSpeed = scnr.nextInt();
        System.out.print("Enter maximum speed value: ");
        int maxSpeed = scnr.nextInt();
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        
        for (PokemonCharacter character : allCharacters) {
            int speed = character.getSpeed();
            if (speed >= minSpeed && speed <= maxSpeed) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Finds character(s) with the lowest speed value
     * @return TreeSet of characters with lowest speed
     */
    public TreeSet<PokemonCharacter> findLowestSpeed() {
        int[] range = getSpeedRange();
        int lowestSpeed = range[0];
        System.out.println("Lowest speed value: " + lowestSpeed);
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getSpeed() == lowestSpeed) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Finds character(s) with the highest speed value
     * @return TreeSet of characters with highest speed
     */
    public TreeSet<PokemonCharacter> findHighestSpeed() {
        int[] range = getSpeedRange();
        int highestSpeed = range[1];
        System.out.println("Highest speed value: " + highestSpeed);
        
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        
        for (PokemonCharacter character : allCharacters) {
            if (character.getSpeed() == highestSpeed) {
                results.add(character);
            }
        }
        
        return results;
    }

    /**
     * Finds characters with the top 3 fastest speeds
     * @return TreeSet of characters sorted by speed in descending order
     */
    public TreeSet<PokemonCharacter> findTop3FastestSpeeds() {
        // Get all unique speed values and sort them in descending order
        TreeSet<Integer> uniqueSpeeds = new TreeSet<>(Collections.reverseOrder());
        for (PokemonCharacter character : allCharacters) {
            uniqueSpeeds.add(character.getSpeed());
        }
        
        // Get top 3 speed values
        ArrayList<Integer> top3Speeds = new ArrayList<>();
        int count = 0;
        for (Integer speed : uniqueSpeeds) {
            if (count >= 3) break;
            top3Speeds.add(speed);
            count++;
        }
        
        // Find all characters with these top 3 speeds
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        for (PokemonCharacter character : allCharacters) {
            if (top3Speeds.contains(character.getSpeed())) {
                results.add(character);
            }
        }
        
        System.out.println("Top 3 fastest speeds: " + top3Speeds);
        return results;
    }

    /**
     * Finds characters with the top 3 slowest speeds
     * @return TreeSet of characters sorted by speed in ascending order
     */
    public TreeSet<PokemonCharacter> findTop3SlowestSpeeds() {
        // Get all unique speed values and sort them in ascending order
        TreeSet<Integer> uniqueSpeeds = new TreeSet<>();
        for (PokemonCharacter character : allCharacters) {
            uniqueSpeeds.add(character.getSpeed());
        }
        
        // Get top 3 slowest speed values
        ArrayList<Integer> top3Speeds = new ArrayList<>();
        int count = 0;
        for (Integer speed : uniqueSpeeds) {
            if (count >= 3) break;
            top3Speeds.add(speed);
            count++;
        }
        
        // Find all characters with these top 3 slowest speeds
        TreeSet<PokemonCharacter> results = new TreeSet<>(PokemonCharacter.BY_SPEED);
        for (PokemonCharacter character : allCharacters) {
            if (top3Speeds.contains(character.getSpeed())) {
                results.add(character);
            }
        }
        
        System.out.println("Top 3 slowest speeds: " + top3Speeds);
        return results;
    }

    /**
     * Displays the top 3 speed groups and lists characters in each group
     * A speed group consists of all characters sharing the same speed value
     */
    public void displayTop3SpeedGroups() {
        // Create a map of speed values to list of characters
        TreeMap<Integer, ArrayList<PokemonCharacter>> speedGroups = new TreeMap<>(Collections.reverseOrder());
        
        for (PokemonCharacter character : allCharacters) {
            int speed = character.getSpeed();
            speedGroups.putIfAbsent(speed, new ArrayList<>());
            speedGroups.get(speed).add(character);
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       Top 3 Speed Groups                   ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        int groupCount = 0;
        for (Map.Entry<Integer, ArrayList<PokemonCharacter>> entry : speedGroups.entrySet()) {
            if (groupCount >= 3) break;
            
            int speed = entry.getKey();
            ArrayList<PokemonCharacter> characters = entry.getValue();
            
            System.out.println("\n┌─ Speed Group " + (groupCount + 1) + " ─────────────────────┐");
            System.out.println("│ Speed Value: " + speed);
            System.out.println("│ Number of Characters: " + characters.size());
            System.out.println("└──────────────────────────────────────────┘");
            System.out.println("Characters in this group:");
            
            // Sort characters by name for display
            TreeSet<PokemonCharacter> sortedChars = new TreeSet<>(PokemonCharacter.BY_NAME);
            sortedChars.addAll(characters);
            
            for (PokemonCharacter character : sortedChars) {
                System.out.println("  • " + character.toDisplayString());
            }
            
            groupCount++;
        }
        
        if (speedGroups.isEmpty()) {
            System.out.println("No speed groups found.");
        }
    }

    /**
     * Displays the largest speed group (the speed value with the most characters)
     * If multiple speed groups have the same maximum size, all are displayed
     */
    public void displayLargestSpeedGroup() {
        // Create a map of speed values to list of characters
        HashMap<Integer, ArrayList<PokemonCharacter>> speedGroups = new HashMap<>();
        
        for (PokemonCharacter character : allCharacters) {
            int speed = character.getSpeed();
            speedGroups.putIfAbsent(speed, new ArrayList<>());
            speedGroups.get(speed).add(character);
        }
        
        // Find the maximum group size
        int maxGroupSize = 0;
        for (ArrayList<PokemonCharacter> group : speedGroups.values()) {
            if (group.size() > maxGroupSize) {
                maxGroupSize = group.size();
            }
        }
        
        // Find all speed groups with the maximum size
        ArrayList<Integer> largestSpeeds = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<PokemonCharacter>> entry : speedGroups.entrySet()) {
            if (entry.getValue().size() == maxGroupSize) {
                largestSpeeds.add(entry.getKey());
            }
        }
        
        // Sort the speeds for consistent display
        Collections.sort(largestSpeeds);
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       Largest Speed Group(s)               ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Group size: " + maxGroupSize + " character(s)");
        System.out.println();
        
        int groupNum = 1;
        for (Integer speed : largestSpeeds) {
            ArrayList<PokemonCharacter> characters = speedGroups.get(speed);
            
            System.out.println("┌─ Group " + groupNum + " ─────────────────────────────┐");
            System.out.println("│ Speed Value: " + speed);
            System.out.println("└──────────────────────────────────────────┘");
            System.out.println("Characters in this group:");
            
            // Sort characters by name for display
            TreeSet<PokemonCharacter> sortedChars = new TreeSet<>(PokemonCharacter.BY_NAME);
            sortedChars.addAll(characters);
            
            for (PokemonCharacter character : sortedChars) {
                System.out.println("  • " + character.toDisplayString());
            }
            System.out.println();
            groupNum++;
        }
        
        if (speedGroups.isEmpty()) {
            System.out.println("No speed groups found.");
        }
    }

    /**
     * Gets all unique speed values and their counts
     * Useful for debugging and analysis
     * @return Map of speed values to count of characters with that speed
     */
    public Map<Integer, Integer> getSpeedDistribution() {
        TreeMap<Integer, Integer> distribution = new TreeMap<>();
        
        for (PokemonCharacter character : allCharacters) {
            int speed = character.getSpeed();
            distribution.put(speed, distribution.getOrDefault(speed, 0) + 1);
        }
        
        return distribution;
    }

    /**
     * Displays statistics about speed distribution
     * Shows number of unique speed values and distribution
     */
    public void displaySpeedStatistics() {
        Map<Integer, Integer> distribution = getSpeedDistribution();
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       Speed Statistics                     ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Total characters: " + allCharacters.size());
        System.out.println("Unique speed values: " + distribution.size());
        
        int[] range = getSpeedRange();
        System.out.println("Speed range: " + range[0] + " - " + range[1]);
        
        // Find most common speed value(s)
        int maxCount = Collections.max(distribution.values());
        ArrayList<Integer> mostCommonSpeeds = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostCommonSpeeds.add(entry.getKey());
            }
        }
        
        System.out.println("\nMost common speed value(s): " + mostCommonSpeeds);
        System.out.println("Number of characters with this speed: " + maxCount);
    }

    /**
     * Displays a TreeSet of Pokemon characters
     * @param characters The TreeSet to display
     */
    public void displayResults(TreeSet<PokemonCharacter> characters) {
        if (characters.isEmpty()) {
            System.out.println("No characters found matching the criteria.");
        } else {
            System.out.println("\nFound " + characters.size() + " character(s):");
            System.out.println("=".repeat(80));
            for (PokemonCharacter character : characters) {
                System.out.println(character.toDisplayString());
            }
            System.out.println("=".repeat(80));
        }
    }
}