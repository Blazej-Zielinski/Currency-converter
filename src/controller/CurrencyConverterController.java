package controller;

import model.CurrencyConverterModel;
import view.CurrencyConverterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterController {
    private final CurrencyConverterView theView;
    private final CurrencyConverterModel theModel;

    public CurrencyConverterController(CurrencyConverterView theView, CurrencyConverterModel theModel){
         this.theView = theView;
         this.theModel = theModel;

         this.theView.addCalculationListener(new ConvertListener());
    }

    class ConvertListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int firstCurrency,secondCurrency;
            double amount;

            try{
                firstCurrency = theView.getFirstCurrency();
                secondCurrency = theView.getSecondCurrency();
                amount = theView.getAmount();

                theModel.calculate(firstCurrency,secondCurrency,amount);

                theView.setCalculatedValue(theModel.getCalculatedValue());
            }catch (NumberFormatException ex){
                theView.displayErrorMessage("Enter the amount");
            }

        }
    }
}
