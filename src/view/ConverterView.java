package view;

import java.awt.event.ActionListener;

public interface ConverterView {
     int getFirstCurrency();
     int getSecondCurrency();
     double getAmount();
     void setCalculatedValue(double value);
     void addCalculationListener(ActionListener handleClick);
     void displayErrorMessage(String errorMessage);
}
