package Items;
//Sandro Megrelishvili - MN: 39851214
public class Item { 
    private String name;
    private int quantity;
    private double length;
    private double width;
    private double height;
    private double weight;

    //Constructors
    public Item(String name, int quantity, double length, double width, double height, double weight) {
        this.name = name;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	//Calculate Volume Method
	public double calculateVolume() {
        return length * width * height;
    }

	//Print item Info
	public void printInfo() {
        System.out.println("Item Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Length: " + length + " m");
        System.out.println("Width: " + width + " m");
        System.out.println("Height: " + height + " m");
        System.out.println("Weight: " + weight + " kg");
    }
}