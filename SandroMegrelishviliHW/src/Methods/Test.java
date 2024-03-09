package Methods;
//Sandro Megrelishvili - MN: 39851214
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Items.Item;

public class Test {
    public static void main(String[] args) {
        //Creating a list to store items
        List<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //Entering order details using Scanner
        System.out.println("What do you want to order? (F.E. 100 Laptop, 200 Mouse, 150 Desktop, 200 LCD Screen)");
        String input = scanner.nextLine();

        //Split the input into individual orders
        String[] orders = input.split(", ");

        //Process each order
        for (String order : orders) {
            //Split the order into quantity and item name
            String[] parts = order.split(" ");
            int quantity = Integer.parseInt(parts[0]);
            String itemName = parts[1];

            //Set default values for item dimensions and weight
            double height = 0.0;
            double width = 0.0;
            double length = 0.0;
            double weight = 0.0;

            //Set item dimensions and weight based on the item name
            switch (itemName.toLowerCase()) {
                case "laptop":
                    height = 0.6;
                    width = 0.5;
                    length = 0.5;
                    weight = 6.5;
                    break;
                case "mouse":
                    height = 0.3;
                    width = 0.3;
                    length = 0.2;
                    weight = 0.2;
                    break;
                case "desktop":
                    height = 1.0;
                    width = 1.5;
                    length = 0.5;
                    weight = 20.0;
                    break;
                case "lcd":
                case "lcd screen":
                    height = 1.2;
                    width = 1.4;
                    length = 0.8;
                    weight = 2.6;
                    break;
            }

            //Create the Item object with the provided details
            Item item = new Item(itemName, quantity, height, width, length, weight);

            //Add the item to the list
            items.add(item);
        }

        //Create Calculation object
        Calculation calculation = new Calculation();

        //Add items to the Calculation object
        calculation.addItem(items);

        //Calculate the shipping method
        calculation.calculateShipping();

        //Print the shipping information
        calculation.printShippingInfo();

        //Close Scanner
        scanner.close();
    }
}
