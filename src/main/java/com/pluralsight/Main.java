package com.pluralsight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        //Preloading vehicles:
        Vehicle[] models = new Vehicle[20];
        models[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        models[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        models[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        models[3] = new Vehicle(101124, "Honda Accord", "White", 70000, 7500);
        models[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        models[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        //Display amount of cars in inventory
        int vehicleCount = 6;

        //while to show menu  + switch statement
        while(true){
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1 - List all vehicles" );
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.println("\nEnter your command:\n");
            int command = scanner.nextInt();
            scanner.nextLine(); //eats next line, because int

            //What each option does, each case is a choice
            //From the menu above
           switch (command){
               case 1:
                   listAllVehicles(models, vehicleCount);
                   break;
               case 2:
                   searchByModel(models, vehicleCount, scanner);
                   break;
               case 3:
                   searchByPrice(models, vehicleCount, scanner);
                   break;
               case 4:
                   searchByColor(models, vehicleCount, scanner);
                   break;
               case 5:
                   addAVehicle(models, vehicleCount, scanner);
                   break;
               case 6:
                   System.out.println("Goodbye!");
                   scanner.close();
                   System.exit(0);
                   break;
               default:
                   System.out.println("Invalid Option!");
            }
        }
    }
    //Making method to list all Vehicles when prompted to (option 1)
    public static void listAllVehicles(Vehicle[]models, int vehicleCount){
        for (int i = 0; i < vehicleCount; i++){
            System.out.println("Vehicle ID: " + models[i].getVehicleId()+
                    ", Make and Model: " + models[i].getMakeModel()+
                    ", Color: " + models[i].getColor()+
                    ", Odometer Reading: " + models[i].getOdometerReading()+
                    ", Price " + models[i].getPrice());
        }
    }
    public static void searchByModel(Vehicle[]models, int vehicleCount, Scanner scanner){
        System.out.println("Enter the make/model to search: "); //Test shown to user
        String makeModel = scanner.nextLine(); //This is input from user
        boolean foundModel = false; // add boolean in case no vehicles found
        for(int i = 0; i < vehicleCount; i++ ){ //Starts at 0 ends at amount of vehicles
            if (models[i].getMakeModel().equalsIgnoreCase(makeModel)){ //Checks models, compares to entered model
                System.out.println("Vehicles under " + makeModel + " found: " +
                        " Vehicle ID: " + models[i].getVehicleId()+
                        ", Color: " + models[i].getColor() +
                        ", Odometer Reading: " + models[i].getOdometerReading()+
                        ", Price: " + models[i].getPrice());
                foundModel = true; //this is only if vehicle is found with make/model

            }
        }
        if(!foundModel){
            System.out.println("Sorry, there are currently no vehicles under: " + makeModel); //No vehicle found message
        }
    }
    public static void searchByPrice(Vehicle[]models, int vehicleCount, Scanner scanner ){
        System.out.println("Enter minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.println("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();

        // Boolean flag to track
        boolean foundVehicle = false; //ref: make/model (same thing)
        for(int i = 0; i < vehicleCount; i++){
            if(models[i].getPrice() >= minPrice && models[i].getPrice() <= maxPrice){
              // Finding vehicles with price range
                System.out.println("Found: " + models[i].getMakeModel() +
                        " in " + models[i].getColor() +
                        " for $" + models[i].getPrice());
                foundVehicle = true; // Vehicle found successfully

            }
        }
        if (!foundVehicle){
            System.out.println("Sorry, there are currently no vehicles in this price range.");
        }
    }
public static void searchByColor(Vehicle[]models, int vehicleCount, Scanner scanner){
    System.out.println("Enter a color: ");
    String selectedColor = scanner.nextLine();
    boolean colorFound = false;

    for(int i = 0; i < vehicleCount; i++){
        if(models[i].getColor().equalsIgnoreCase(selectedColor)){
            System.out.println("Results: " + models[i].getMakeModel() +
                    " in " + models[i].getColor() +
                    " for $" + models[i].getPrice());
        }
    }
    if (!colorFound){
        System.out.println("Sorry, there are currently no vehicles matching your description: " + selectedColor);
    }
    }
public static int addAVehicle(Vehicle[]model, int vehicleCount, Scanner scanner) {
    if (vehicleCount >= 20) { // vehicle count cant be more than 20, array limit
        System.out.println("Sorry! The inventory is full!");
        return vehicleCount; // Returns unchanged count if the array is full
    }
    // Get vehicle details from user:
    System.out.println("Enter the vehicle ID (e.g., 124824): ");
    long vehicleId = scanner.nextLong();
    scanner.nextLine(); //eats line

    System.out.println("Enter the make and model (e.g., Honda Accord): ");
    String makeModel = scanner.nextLine();

    System.out.println("Enter the color (e.g., White): ");
    String color = scanner.nextLine();

    System.out.println("Enter the odometer reading (e.g., 50000): ");
    int odometerReading = scanner.nextInt();

    System.out.println("Enter the price (e.g., 14500.00): ");
    float price = scanner.nextFloat();

    //Create the new vehicle
    Vehicle newVehicle = new Vehicle(vehicleId, makeModel, color, odometerReading, price);

    // Adding the new vehicle to the array
    model[vehicleCount] = newVehicle;

    // Increment vehicle count after adding a vehicle
    vehicleCount++;

    // Show confirmation message
    System.out.println("New vehicle added!");
    System.out.println("Vehicle ID: " + newVehicle.getVehicleId()+
            ", Make/Model: " + newVehicle.getMakeModel()+
            ", Color: " + newVehicle.getColor() +
            ", Odometer: " + newVehicle.getOdometerReading() +
            ", Price: $" + newVehicle.getPrice());

    // return the updated vehicle count
    return vehicleCount;

    }
}