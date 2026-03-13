/**
 * <h1>Book My Stay Application - Use Case 2</h1>
 * This version introduces Object-Oriented Programming concepts like
 * Abstraction, Inheritance, and Encapsulation.
 * * @author User
 * @version 2.0
 */

// --- Domain Model ---

/**
 * Abstract class representing the general concept of a Room.
 */
abstract class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price per Night: $" + price);
        System.out.println("Amenities: " + amenities);
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 100.0, "Single Bed, Wi-Fi, Coffee Maker");
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 180.0, "Queen Bed, Wi-Fi, Mini Fridge");
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 350.0, "King Bed, Living Area, Ocean View, Mini Bar");
    }
}

// --- Main Application ---

public class bookmystay {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Book My Stay - Room Management System v2.0    ");
        System.out.println("=================================================");

        // 1. Initialize Room Objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRm = new DoubleRoom();
        Room suite = new SuiteRoom();

        // 2. Static Availability Representation
        // Note: Using variables here highlights the need for Collections later!
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // 3. Display Room Details and Current State
        System.out.println("\n--- Available Room Types ---");

        single.displayDetails();
        System.out.println("Current Availability: " + singleAvailable + " rooms left.");
        System.out.println("-------------------------------------------------");

        doubleRm.displayDetails();
        System.out.println("Current Availability: " + doubleAvailable + " rooms left.");
        System.out.println("-------------------------------------------------");

        suite.displayDetails();
        System.out.println("Current Availability: " + suiteAvailable + " rooms left.");
        System.out.println("-------------------------------------------------");

        System.out.println("\nApplication execution completed.");
    }
}