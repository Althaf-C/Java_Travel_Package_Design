import org.junit.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Represents a destination in a travel package.
 */
class Destination {
    private final String name;
    private final List<Activity> activities;

    /**
     * Constructs a Destination with the given name.
     *
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        activities = new ArrayList<>();
    }

    /**
     * Gets the name of the destination.
     *
     * @return The name of the destination.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of activities available at the destination.
     *
     * @return The list of activities available at the destination.
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}

/**
 * Represents an activity available at a destination.
 */
class Activity {
    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private final Destination destination;

    /**
     * Constructs an Activity with the given parameters.
     *
     * @param name        The name of the activity.
     * @param description The description of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    /**
     * Gets the name of the activity.
     *
     * @return The name of the activity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity.
     *
     * @return The description of the activity.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the cost of the activity.
     *
     * @return The cost of the activity.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Gets the capacity of the activity.
     *
     * @return The capacity of the activity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the destination where the activity takes place.
     *
     * @return The destination where the activity takes place.
     */
    public Destination getDestination() {
        return destination;
    }
}

/**
 * Represents a passenger.
 */
class Passenger {
    private final String name;
    private final int passengerNumber;

    /**
     * Constructs a Passenger with the given parameters.
     *
     * @param name           The name of the passenger.
     * @param passengerNumber The passenger number.
     */
    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
    }

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the passenger number.
     *
     * @return The passenger number.
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }
}

/**
 * Represents a standard passenger with a balance.
 */
class StandardPassenger extends Passenger {
    private double balance;

    /**
     * Constructs a StandardPassenger with the given parameters.
     *
     * @param name           The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance        The balance of the passenger.
     */
    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    /**
     * Gets the balance of the standard passenger.
     *
     * @return The balance of the standard passenger.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deducts the specified amount from the balance.
     *
     * @param amount The amount to deduct.
     */
    public void deductBalance(double amount) {
        balance -= amount;
    }
}

/**
 * Represents a gold passenger with a balance and discounts.
 */
class GoldPassenger extends Passenger {
    private double balance;

    /**
     * Constructs a GoldPassenger with the given parameters.
     *
     * @param name           The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance        The balance of the passenger.
     */
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    /**
     * Gets the balance of the gold passenger.
     *
     * @return The balance of the gold passenger.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Applies a discount to the balance based on the specified percentage.
     *
     * @param percentage The discount percentage.
     */
    public void applyDiscount(double percentage) {
        double discount = percentage / 10000 * balance;
        balance -= discount;
    }
}

/**
 * Represents a premium passenger.
 */
class PremiumPassenger extends Passenger {
    /**
     * Constructs a PremiumPassenger with the given parameters.
     *
     * @param name           The name of the passenger.
     * @param passengerNumber The passenger number.
     */
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
    }
}

/**
 * Represents a travel package containing destinations and passengers.
 */
class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private final List<Destination> itinerary;
    private final List<Passenger> passengers;

    /**
     * Constructs a TravelPackage with the given parameters.
     *
     * @param name             The name of the travel package.
     * @param passengerCapacity The passenger capacity of the travel package.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        itinerary = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    /**
     * Adds a destination to the travel package's itinerary.
     *
     * @param destination The destination to add.
     */
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    /**
     * Adds a passenger to the travel package.
     *
     * @param passenger The passenger to add.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Gets the itinerary of the travel package.
     *
     * @return The itinerary of the travel package.
     */
    public List<Destination> getItinerary() {
        return itinerary;
    }

    /**
     * Gets the passengers enrolled in the travel package.
     *
     * @return The passengers enrolled in the travel package.
     */
    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Prints the itinerary of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: ₹ " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
            System.out.println();
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() + " - Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * Prints the details of a specific passenger, including their name, passenger number, and activities enrolled.
     *
     * @param passenger The passenger whose details to print.
     */
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger) {
            System.out.println("Balance: ₹" + ((StandardPassenger) passenger).getBalance());
        }
        List<String> activities = new ArrayList<>();
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getDestination() == destination) {
                    activities.add(activity.getName() + " at " + destination.getName() + " - ₹" + activity.getCost());
                }
            }
        }
        if (!activities.isEmpty()) {
            System.out.println("Activities Enrolled:");
            for (String activity : activities) {
                System.out.println(activity);
            }
        }
    }

    /**
     * Prints the available activities in the travel package, along with the remaining capacity for each activity.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int remainingCapacity = activity.getCapacity();
                for (Passenger passenger : passengers) {
                    if (passenger instanceof StandardPassenger || passenger instanceof GoldPassenger) {
                        remainingCapacity--;
                    }
                }
                if (remainingCapacity > 00) {
                    System.out.println(activity.getName() + " at " + destination.getName() + " - Spaces Available: " + remainingCapacity);
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Destination destination1 = new Destination("Paris");
        Destination destination2 = new Destination("Tokyo");

        Activity activity1 = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 500.00, 200, destination1);
        Activity activity2 = new Activity("Disneyland Visit", "Visit to Disneyland theme park", 700.00, 300, destination2);

        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        TravelPackage travelPackage = new TravelPackage("Dream Vacation", 500);
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        StandardPassenger standardPassenger = new StandardPassenger("Alice", 1, 10000.00);
        StandardPassenger standardPassenger1 = new StandardPassenger("Jack", 4, 40000.00);
        GoldPassenger goldPassenger = new GoldPassenger("Bob", 2, 20000.00);
        PremiumPassenger premiumPassenger = new PremiumPassenger("Charlie", 3);

        travelPackage.addPassenger(standardPassenger);
        travelPackage.addPassenger(standardPassenger1);
        travelPackage.addPassenger(goldPassenger);
        travelPackage.addPassenger(premiumPassenger);

        travelPackage.printItinerary();
        System.out.println();
        travelPackage.printPassengerList();
        System.out.println();
        travelPackage.printPassengerDetails(standardPassenger);
        System.out.println();
        travelPackage.printAvailableActivities();
    }

    // Unit tests
    @Test
    public void testDestinationAddActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 500.00, 200, destination);
        destination.addActivity(activity);

        assertTrue(destination.getActivities().contains(activity));
    }

    @Test
    public void testActivityGetters() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 500.00, 200, destination);

        assertEquals("Test Activity", activity.getName());
        assertEquals("Description", activity.getDescription());
        assertEquals(500.00, activity.getCost());
        assertEquals(200, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void testPassengerGetters() {
        Passenger passenger = new StandardPassenger("Test Passenger", 1, 10000.00);

        assertEquals("Test Passenger", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
    }

    @Test
    public void testStandardPassengerDeductBalance() {
        StandardPassenger passenger = new StandardPassenger("Test Passenger", 1, 10000.00);
        passenger.deductBalance(500.00);

        assertEquals(500.00, passenger.getBalance());
    }

    @Test
    public void testGoldPassengerApplyDiscount() {
        GoldPassenger passenger = new GoldPassenger("Test Passenger", 1, 10000.00);
        passenger.applyDiscount(100.00); // Applying 100% discount

        assertEquals(900.00, passenger.getBalance());
    }

    @Test
    public void testPremiumPassengerGetters() {
        Passenger passenger = new PremiumPassenger("Test Passenger", 1);

        assertEquals("Test Passenger", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
    }

    @Test
    public void testTravelPackageAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 500);
        Destination destination = new Destination("Test Destination");
        travelPackage.addDestination(destination);

        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    public void testTravelPackageAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 500);
        Passenger passenger = new StandardPassenger("Test Passenger", 1, 10000.00);
        travelPackage.addPassenger(passenger);

        assertTrue(travelPackage.getPassengers().contains(passenger));
    }
}