import java.util.Comparator;

/**
 * Represents a Pokemon character with various attributes.
 * Supports flexible sorting based on different attributes using Comparators.
 * 
 * @author Christopher Perez
 * @version 3.0
 */
public class PokemonCharacter {
    // will utilize a TreeSet
    private String EnglishName;
    private String japaneseName;
    private int hitPoints;
    int speed;
    String type;
    private int podexNumber;

    // enum created name, hp, speed, pokedex number
    public enum SortBy {
        NAME, HIT_POINTS, SPEED, POKEDEX_NUMBER;
    }
    private static SortBy currentSortCriteria = SortBy.NAME;

    public PokemonCharacter(String EnglishName, String japaneseName, int hitPoints,
    int speed, String tyoe, int podexNumber) {
        this.EnglishName = EnglishName;
        this.japaneseName = japaneseName;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.type = tyoe;
        this.podexNumber = podexNumber;
    }

    // Getters
    public String getEnglishName() { return EnglishName; }
    public String getJapaneseName() { return japaneseName; }
    public int getHitPoints() { return hitPoints; }
    public int getSpeed() { return speed; }
    public String getType() { return type; }
    public int getPokedexNumber() { return podexNumber; }

    // Setters
    public void setEnglishName(String englishName) { this.EnglishName = englishName; }
    public void setJapaneseName(String japaneseName) { this.japaneseName = japaneseName; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setType(String type) { this.type = type; }
    public void setPokedexNumber(int pokedexNumber) { this.podexNumber = pokedexNumber; }

    /**
     * Sets the current sorting criteria for all PokemonCharacter comparisons
     * @param criteria The attribute to sort by
     */
    public static void setSortCriteria(SortBy criteria) {
        currentSortCriteria = criteria;
    }

    /**
     * Compares this Pokemon to another based on the current sort criteria.
     * Uses a clever approach to handle multiple sorting attributes dynamically.
     * 
     * @param other The other Pokemon to compare to
     * @return negative if this < other, 0 if equal, positive if this > other
     */
    
    public int compareTo(PokemonCharacter other) {
        int result = 0;
        
        switch (currentSortCriteria) {
            case HIT_POINTS:
                result = Integer.compare(this.hitPoints, other.hitPoints);
                // If hit points are equal, sort by name as secondary criteria
                if (result == 0) {
                    result = this.EnglishName.compareTo(other.EnglishName);
                }
                break;
                
            case SPEED:
                result = Integer.compare(this.speed, other.speed);
                // If speed is equal, sort by name as secondary criteria
                if (result == 0) {
                    result = this.EnglishName.compareTo(other.EnglishName);
                }
                break;
                
            case POKEDEX_NUMBER:
                result = Integer.compare(this.podexNumber, other.podexNumber);
                break;
                
            case NAME:
            default:
                result = this.EnglishName.compareTo(other.EnglishName);
                break;
        }
        
        return result;
    }

    /**
     * Static Comparator for sorting by hit points
     */
    public static final Comparator<PokemonCharacter> BY_HIT_POINTS = 
        new Comparator<PokemonCharacter>() {
            @Override
            public int compare(PokemonCharacter p1, PokemonCharacter p2) {
                int result = Integer.compare(p1.hitPoints, p2.hitPoints);
                // Secondary sort by name if hit points are equal
                return result != 0 ? result : p1.EnglishName.compareTo(p2.EnglishName);
            }
        };

    /**
     * Static Comparator for sorting by speed
     */
    public static final Comparator<PokemonCharacter> BY_SPEED = 
        new Comparator<PokemonCharacter>() {
            @Override
            public int compare(PokemonCharacter p1, PokemonCharacter p2) {
                int result = Integer.compare(p1.speed, p2.speed);
                // Secondary sort by name if speed is equal
                return result != 0 ? result : p1.EnglishName.compareTo(p2.EnglishName);
            }
        };

    /**
     * Static Comparator for sorting by name
     */
    public static final Comparator<PokemonCharacter> BY_NAME = 
        new Comparator<PokemonCharacter>() {
            @Override
            public int compare(PokemonCharacter p1, PokemonCharacter p2) {
                return p1.EnglishName.compareTo(p2.EnglishName);
            }
        };

    @Override
    public String toString() {
        return String.format("%-20s %-20s HP: %-4d Speed: %-4d Type: %-10s Pokedex: %-4d",
            EnglishName, japaneseName, hitPoints, speed, type, podexNumber);
    }

    /**
     * Returns a formatted string with specific attributes for display
     * @return formatted string with English name, Japanese name, speed, and hit points
     */
    public String toDisplayString() {
        return String.format("English Name: %-20s Japanese Name: %-20s Speed: %-4d HP: %-4d",
            EnglishName, japaneseName, speed, hitPoints);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PokemonCharacter)) return false;
        PokemonCharacter other = (PokemonCharacter) obj;
        return this.EnglishName.equals(other.EnglishName) &&
               this.japaneseName.equals(other.japaneseName) &&
               this.hitPoints == other.hitPoints &&
               this.speed == other.speed &&
               this.podexNumber == other.podexNumber;
    }
    /**
     * Returns the prime number multiplied by the current reselt by 31
     * @return the results of the initial pokemonCharacter value times the prime number 31 and 17
     * to bitwise shift 
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + EnglishName.hashCode();
        result = 31 * result + japaneseName.hashCode();
        result = 31 * result + hitPoints;
        result = 31 * result + speed;
        result = 31 * result + podexNumber;
        return result;
    }
}


