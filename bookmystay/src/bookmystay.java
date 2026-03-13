import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Book My Stay Application - Use Case 3</h1>
 * This version introduces Centralized Inventory Management using HashMaps.
 * It separates the "Room definition" from the "Inventory state."
 * * @author User
 * @version 3.0
 */

// --- Domain Model (From Use Case 2) ---

abstract class Room {
    private String type;
    private double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() { return type; }
    public double getPrice() { return price; }
}

class SingleRoom extends Room { public SingleRoom() { super("Single", 100.0); } }
class DoubleRoom extends Room { public DoubleRoom() { super("Double", 180.0); } }
class SuiteRoom extends Room { public SuiteRoom() { super("Suite", 350.0); } }

// --- Inventory Management (New Concept) ---

/**
 * Manages the counts of available rooms using a HashMap for O(1) lookups.
 */
class RoomInventory {
    // HashMap stores: Room Type (Key) -> Available Count (Value)
    private Map<String, Integer> inventory;

    public RoomInventory() {
        this.inventory = new HashMap<>();
    }

    /**
     * Registers or updates a room type in the system.
     */
    public void updateInventory(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /**
     * Retrieves current availability for a specific room type.
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Displays the entire inventory state.
     */
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Room Type: " + entry.getKey() + " | Available: " + entry.getValue());
        }
    }
}

// --- Main Application ---

public class bookmystay {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Book My Stay - Inventory Management v3.0      ");
        System.out.println("=================================================");

        // 1. Initialize Inventory
        RoomInventory hotelInventory = new RoomInventory();

        // 2. Setup Initial Stock (Centralized)
        hotelInventory.updateInventory("Single", 10);
        hotelInventory.updateInventory("Double", 5);
        hotelInventory.updateInventory("Suite", 2);

        // 3. Display initial state
        hotelInventory.displayInventory();

        // 4. Demonstrate controlled updates
        System.out.println("\n[System Update]: Booking confirmed for 1 Single Room.");
        int currentSingle = hotelInventory.getAvailability("Single");
        hotelInventory.updateInventory("Single", currentSingle - 1);

        // 5. Final State
        hotelInventory.displayInventory();

        System.out.println("=================================================");
    }
}