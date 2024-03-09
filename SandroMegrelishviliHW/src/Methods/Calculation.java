package Methods;
//Sandro Megrelishvili - MN: 39851214
import Containers.Container;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private List<Item> items;
    private List<Container> containers;

    public Calculation() {
        items = new ArrayList<>();
        containers = new ArrayList<>();
    }

    //every Items Total Volume
    public double calculateTotalVolume() {
        double totalVolume = 0.0;
        for (Item item : items) {
            totalVolume += item.calculateVolume() * item.getQuantity();
        }
        return totalVolume;
    }

    //every containers Total Volume
    public double calculateTotalContainerVolume() {
        double totalContainerVolume = 0.0;
        for (Container container : containers) {
            totalContainerVolume += container.calculateVolume() * container.getQuantity();
        }
        return totalContainerVolume;
    }

    //Best Shipping Method
    public void calculateShipping() {
        double totalVolume = calculateTotalVolume();

        //Sort containers options
        Container smallContainer = new Container("Small Container", 2.59, 2.43, 6.06, 1000, 0);
        Container bigContainer = new Container("Big Container", 2.59, 2.43, 12.01, 1800, 0);

        //Calculate maximum quantity of big containers that can be used
        int maxBigContainerQuantity = (int) Math.floor(totalVolume / bigContainer.calculateVolume());

        //Calculate quantity of small containers needed to fulfill the total volume requirement
        int smallContainerQuantity = (int) Math.ceil(totalVolume / smallContainer.calculateVolume());

        //Calculate the cost of using only small containers and only big containers
        double costSmallOnly = smallContainerQuantity * smallContainer.getCost();
        double costBigOnly = maxBigContainerQuantity * bigContainer.getCost();

        //If cost of using only small containers is lower or equal then choose that option
        if (costSmallOnly <= costBigOnly) {
            smallContainer.setQuantity(smallContainerQuantity);
            containers.add(smallContainer);
        } else {
            //Calculate remaining volume after using maximum big containers
            double remainingVolume = totalVolume - maxBigContainerQuantity * bigContainer.calculateVolume();

            //Calculate quantity of small containers needed for the remaining volume
            int smallContainerQuantityRemaining = (int) Math.ceil(remainingVolume / smallContainer.calculateVolume());

            //Set quantities for both containers
            smallContainer.setQuantity(smallContainerQuantityRemaining);
            bigContainer.setQuantity(maxBigContainerQuantity);

            //Add containers to the list
            containers.add(smallContainer);
            containers.add(bigContainer);
        }
    }

    //Total Weight Method
    public double calculateTotalWeight() {
        double totalWeight = 0.0;
        for (Item item : items) {
            totalWeight += item.getWeight() * item.getQuantity();
        }
        return totalWeight;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(List<Item> itemList) {
        items.addAll(itemList);
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Container> getContainers() {
        return containers;
    }
    
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    //Mostly everything below is printing
    public void printItemInfo() {
        int itemIndex = 1;
        for (Item item : items) {
            System.out.println("Item " + itemIndex + ": " + item.getName());
            System.out.println("Quantity: " + item.getQuantity());
            itemIndex++;
        }
    }

    public void printShippingInfo() {
        double totalVolume = calculateTotalVolume();
        double totalWeight = calculateTotalWeight();
        double totalContainerVolume = calculateTotalContainerVolume();
        double totalCost = 0.0;

        System.out.println("Items Information:");
        int itemIndex = 1;
        for (Item item : items) {
            System.out.println("Item " + itemIndex + ": " + item.getName());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Weight: " + item.getWeight() + " kg");
            System.out.println("Dimensions: " + item.getLength() + " m x " + item.getWidth() + " m x " + item.getHeight() + " m");
            System.out.println();
            itemIndex++;
        }

        System.out.println("Total Volume of all Items: " + totalVolume + " cubic meters");
        System.out.println("Total Weight of all Items: " + totalWeight + " kg");
        System.out.println("Total Volume of all Containers: " + totalContainerVolume + " cubic meters");

        System.out.println("Best Shipping Method:");
        for (Container container : containers) {
            System.out.println("- Container: " + container.getName());
            System.out.println("  Quantity: " + container.getQuantity());
            System.out.println("  Dimensions: " + container.getHeight() + " m x " + container.getWidth() + " m x " + container.getLength() + " m");
            System.out.println("  Cost: " + container.getCost() * container.getQuantity() + " Euro");

            //Update and printing total cost
            totalCost += container.getCost() * container.getQuantity();
            System.out.println("Total Cost: " + totalCost + " Euro");
        }
    
    }

}
