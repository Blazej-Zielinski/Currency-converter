package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CurrencyConverterView extends JFrame implements ConverterView{
    private final JComboBox<String> firstCurrency = new JComboBox<>();
    private final JComboBox<String> secondCurrency = new JComboBox<>();

    private final JTextField currencyAmount = new JTextField(10);
    private final JButton calculateButton = new JButton("Calculate");
    private final JTextField calculatedValue = new JTextField(10);

    public CurrencyConverterView(ArrayList<String> namesList){
        super();
        for (String name:namesList) {
            firstCurrency.addItem(name);
            secondCurrency.addItem(name);
        }
        calculatedValue.setFocusable(false);

        JPanel firstCPanel = new JPanel();
        Label firstC = new Label("From:");
        firstCPanel.setMaximumSize(new Dimension(250,80));
        firstCPanel.add(firstC);
        firstCPanel.add(firstCurrency);
        firstCPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel secondCPanel = new JPanel();
        Label secondC = new Label("To:");
        secondCPanel.setMaximumSize(new Dimension(250,80));
        secondCPanel.add(secondC);
        secondCPanel.add(secondCurrency);
        secondCPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel comboBoxesContainer = new JPanel();
        comboBoxesContainer.setLayout(new BoxLayout(comboBoxesContainer,BoxLayout.PAGE_AXIS));
        comboBoxesContainer.add(firstCPanel);
        comboBoxesContainer.add(secondCPanel);

        JPanel amountFieldPanel= new JPanel();
        Label amountText = new Label("Amount: ");
        amountFieldPanel.setPreferredSize(new Dimension(120,80));
        amountFieldPanel.add(amountText);
        amountFieldPanel.add(currencyAmount);
        amountFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel convertContainer = new JPanel();
        convertContainer.setMaximumSize(new Dimension(250,200));
        convertContainer.add(amountFieldPanel);
        convertContainer.add(calculateButton);
        convertContainer.add(Box.createRigidArea(new Dimension(250,20)));
        convertContainer.add(calculatedValue);
        convertContainer.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new GridLayout(1,2));
        mainContainer.add(comboBoxesContainer);
        mainContainer.add(convertContainer);

        this.add(mainContainer);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Currency Converter");
    }

    public int getFirstCurrency(){
        return firstCurrency.getSelectedIndex()+1;
    }
    public int getSecondCurrency(){
        return secondCurrency.getSelectedIndex()+1;
    }
    public double getAmount(){
        return Double.parseDouble(currencyAmount.getText());
    }
    public void setCalculatedValue(double value){ calculatedValue.setText(Double.toString(value));}
    public void addCalculationListener(ActionListener handleClick){
        calculateButton.addActionListener(handleClick);
    }
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }
}
