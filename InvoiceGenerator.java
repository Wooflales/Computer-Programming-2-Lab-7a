import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InvoiceGenerator extends JFrame {
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel inputPnl;
    JPanel buttonPnl;
    JLabel invoiceTitle;
    JLabel productNameLbl;
    JLabel quantityLbl;
    JLabel priceLbl;
    JTextArea productNameTA;
    JTextArea quantityTA;
    JTextArea priceTA;
    JButton addNewBtn;
    JButton createInvoiceBtn;
    JButton quitBtn;
    String productStr;
    int quantityInt;
    double quantityDbl;
    double unitPriceDbl;
    double totalPrice;
    double finalTotal;
    LineItem lineItem;
    Customer customer;
    public InvoiceGenerator(){
        System.out.printf("%25s", "Invoice\n");
        customer = new Customer("A Business","Calhoun st","Cincinnati","OH","123123");
        System.out.println(customer.generateAddressBlock());
        System.out.println("==================================================\n");
        System.out.printf("%-10s%-15s%-15s%10s", "Product", "Quantity", "Unit Price", "Total Price\n");
        setTitle("Invoice Generator");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTitlePanel();
        mainPnl.add(titlePnl, BorderLayout.NORTH);
        createInputPanel();
        mainPnl.add(inputPnl,BorderLayout.CENTER);
        createButtonPanel();
        mainPnl.add(buttonPnl,BorderLayout.SOUTH);
        add(mainPnl);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createTitlePanel() {
        titlePnl = new JPanel();
        titlePnl.setLayout(new BorderLayout());
        invoiceTitle = new JLabel("Invoice Generator");
        titlePnl.add(invoiceTitle);
    }
    private void createInputPanel() {
        inputPnl = new JPanel();
        inputPnl.setLayout(new GridLayout(6,1));
        productNameLbl = new JLabel("Product Name");
        quantityLbl = new JLabel("Quantity");
        priceLbl = new JLabel("Unit Price");
        productNameTA = new JTextArea(1,30);
        quantityTA = new JTextArea(1,3);
        priceTA = new JTextArea(1,8);
        inputPnl.add(productNameLbl);
        inputPnl.add(productNameTA);
        inputPnl.add(quantityLbl);
        inputPnl.add(quantityTA);
        inputPnl.add(priceLbl);
        inputPnl.add(priceTA);

    }
    private void createButtonPanel() {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));
        productStr = "";
        quantityInt = 0;
        quantityDbl = 0;
        unitPriceDbl = 0;
        totalPrice = 0;
        finalTotal = 0;
        addNewBtn = new JButton("Add Item");
        addNewBtn.addActionListener((ActionEvent ae) ->{
            productStr = productNameTA.getText();
            quantityInt = Integer.parseInt(quantityTA.getText());
            quantityDbl = Double.parseDouble(quantityTA.getText());
            unitPriceDbl = Double.parseDouble(priceTA.getText());
            totalPrice = quantityDbl*unitPriceDbl;
            finalTotal += totalPrice;
            lineItem = new LineItem(productStr,quantityInt,unitPriceDbl,totalPrice);
            System.out.printf("%-10s",lineItem.generateDisplay()+"\n");
            productNameTA.setText("");
            quantityTA.setText("");
            priceTA.setText("");
                });
        createInvoiceBtn = new JButton("Get Total");
        createInvoiceBtn.addActionListener((ActionEvent ae) ->{
            System.out.println("==================================================\n");
            System.out.printf("%25s", "Total amount: $"+finalTotal+"\n");
            int response;
            response = JOptionPane.showConfirmDialog(null, "Do you want make another invoice?", "Make another invoice",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                finalTotal = 0;
                System.out.printf("%25s", "Invoice\n");
                System.out.println(customer.generateAddressBlock());
                System.out.println("==================================================\n");
                System.out.printf("%-10s%-15s%-15s%10s", "Product", "Quantity", "Unit Price", "Total Price\n");
            }
            if (response == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
                });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        {
            System.exit(0);
        });
        buttonPnl.add(addNewBtn);
        buttonPnl.add(createInvoiceBtn);
        buttonPnl.add(quitBtn);

    }

}
