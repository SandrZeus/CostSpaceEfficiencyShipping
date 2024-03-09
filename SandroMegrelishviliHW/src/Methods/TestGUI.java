package Methods;
//Sandro Megrelishvili - MN: 39851214
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Containers.Container;
import Items.Item;

public class TestGUI extends JFrame {
    private JTextField orderTextField;
    private JTextArea outputTextArea;

    public TestGUI() {
        //Set up the frame
        setTitle("Shipping Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setLookAndFeel();

        //Create components
        orderTextField = new JTextField();
        orderTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 18));
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        //Add components to the frame
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(new JLabel("Enter your order details:"), BorderLayout.NORTH);
        inputPanel.add(orderTextField, BorderLayout.CENTER);
        inputPanel.add(calculateButton, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        //Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateShipping();
            }
        });
    }

    private void calculateShipping() {
        //Retrieve the order details from the text field
        String orderText = orderTextField.getText();

        //Creating a list to store items
        List<Item> items = new ArrayList<>();

        //Split the input into individual orders
        String[] orders = orderText.split(", ");

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

        //Clear the output text area
        outputTextArea.setText("");
        
        //Print the Items information
        outputTextArea.append("Items:\n");
        outputTextArea.append("-----------------------------------\n");
        for (Item item : calculation.getItems()) {
            outputTextArea.append("Item: " + item.getName() + "\n");
            outputTextArea.append("Quantity: " + item.getQuantity() + "\n");
            outputTextArea.append("Dimensions: " + item.getHeight() + " m x " + item.getWidth() + " m x " + item.getLength() + " m\n");
            outputTextArea.append("Weight: " + item.getWeight() + " kg\n\n");
        }

        //Print the shipping information
        outputTextArea.append("Shipping Information:\n");
        outputTextArea.append("-----------------------------------\n");
        for (Container container : calculation.getContainers()) {
            outputTextArea.append("Container: " + container.getName() + "\n");
            outputTextArea.append("Quantity: " + container.getQuantity() + "\n");
            outputTextArea.append("Dimensions: " + container.getHeight() + " m x " + container.getWidth() + " m x " + container.getLength() + " m\n");
            outputTextArea.append("Cost: " + container.getCost() * container.getQuantity() + " Euro\n\n");
                   
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TestGUI gui = new TestGUI();
                gui.setVisible(true);
            }
        });
    }
}
