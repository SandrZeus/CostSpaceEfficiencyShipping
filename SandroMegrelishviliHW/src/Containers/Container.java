package Containers;
//Sandro Megrelishvili - MN: 39851214
public class Container {
    private String name;
    private double height;
    private double width;
    private double length;
    private double cost;
    private int quantity;

    //Constructors
    public Container(String name, double height, double width, double length, double cost, int quantity) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.length = length;
        this.cost = cost;
        this.quantity = quantity;
    }

    //Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//Calculate Volume Method
		public double calculateVolume() {
	    	return length * width * height;
	    }

	//Print Container Info
    public void printInfo() {
        System.out.println("Container Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Length: " + length + " m");
        System.out.println("Width: " + width + " m");
        System.out.println("Height: " + height + " m");
        System.out.println("Cost: " + cost + " Euro");
    }
}

