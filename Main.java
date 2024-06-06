package DemoResturant;



import java.util.Scanner;
import static java.lang.Thread.sleep;

abstract class Restaurant {
    String name;
    String location;
    String time;
    String delivery;
    int phoneno;
    int total = 0;
    String[] menuItems;
    int[] prices;
    Scanner sc = new Scanner(System.in);
    public Restaurant(String name, String location, int phoneno, String time, String delivery) {
        this.name = name;
        this.location = location;
        this.phoneno = phoneno;
        this.time = time;
        this.delivery = delivery;
    }

    public void displayWelcomeMessage() {
        System.out.println("\n\n\t\t\t\t\t\t\t\t   Welcome to " + name);
        System.out.println("\t\t\t\t\t\t\t\t═══════════════════════════");
    }

    public void displayRestaurantInfo() {
        System.out.println("***** Restaurant Details *****");
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneno);
        System.out.println("Location: " + location);
        System.out.println("Opening Hours: " + time);
        System.out.println("Delivery: " + delivery);
    }

    public void displayMenu() {
        System.out.println("**************** Welcome to " + name + " ****************");
        System.out.println("=========================================================");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i] + " - " + prices[i] + "/-");
        }
        System.out.println((menuItems.length + 1) + ". Generate Bill");
        System.out.println("=========================================================");
    }

    public void order() {
        while (true) {
            displayMenu();
            System.out.print("Enter Your Choice: ");
            try {
                int choice = sc.nextInt();
                if (choice == menuItems.length + 1) {
                    generateBill();
                    System.exit(1);
                } else if (choice > 0 && choice <= menuItems.length) {
                    System.out.println("You have selected " + menuItems[choice - 1]);
                    System.out.print("Enter the desired quantity: ");
                    int quantity = sc.nextInt();
                    total += quantity * prices[choice - 1];
                } else {
                    System.out.println("Invalid choice. Please select from the menu.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
            System.out.println();
            System.out.print("Do you wish to order anything else (Y/N): ");
            String again = sc.next();
            if (!again.equalsIgnoreCase("Y")) {
                generateBill();
                System.exit(1);
            }
        }
    }

    public void generateBill() {
        System.out.println("\n\n***************** Thank you for ordering ******************");
        System.out.println("**************** Your Bill is : " + total + " *****************");
    }
}

// Specific Restaurant Classes
class Chaiyard extends Restaurant {
    public Chaiyard() {
        super("Chaiyard", "Society Nawabshah", 252563367, "6PM - 3AM", "Available");
        menuItems = new String[]{"Burger", "Pizza", "Cold Coffee", "Iced Tea"};
        prices = new int[]{350, 1200, 150, 150};
    }
}

class RajputRestaurant extends Restaurant {
    public RajputRestaurant() {
        super("Rajput Restaurant", "Station Road Nawabshah", 987654310, "6 PM - 3 AM", "Available");
        menuItems = new String[]{"Biryani Beef", "Karahi Mutton", "Nihari", "Chicken Tikka Masala", "Chapli Kebab"};
        prices = new int[]{400, 2000, 200, 500, 400};
    }
}

class Mirchi360 extends Restaurant {
    public Mirchi360() {
        super("Mirchi360", "Bilawal complex Nawabshah", 243563467, "6PM - 3AM", "Available");
        menuItems = new String[]{"Seekh Kebabs", "Chicken Tikka", "Grilled Fish", "Grilled Paneer Tikka", "Limka"};
        prices = new int[]{250, 500, 1000, 550, 150};
    }
}

// Main Class
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Restaurant rst = new Restaurant("Restaurants", "Nawabshah", 0, "", "") {
            @Override
            public void order() { }
        };
        rst.displayWelcomeMessage();
        System.out.println("Please choose a restaurant:");
        System.out.println("1. Rajput Restaurant");
        System.out.println("2. Chaiyard");
        System.out.println("3. Mirchi360");
        System.out.print("Enter your choice: ");

        try {
            int choice = sc.nextInt();
            System.out.println("Please Wait....");
            sleep(2500);

            switch (choice) {
                case 1:
                    RajputRestaurant rajput = new RajputRestaurant();
                    rajput.displayRestaurantInfo();
                    rajput.order();
                    break;
                case 2:
                    Chaiyard chaiyard = new Chaiyard();
                    chaiyard.displayRestaurantInfo();
                    chaiyard.order();
                    break;
                case 3:
                    Mirchi360 mirchi = new Mirchi360();
                    mirchi.displayRestaurantInfo();
                    mirchi.order();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}
