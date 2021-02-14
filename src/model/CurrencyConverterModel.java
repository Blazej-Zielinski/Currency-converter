package model;

import repo.DataRepo;

public class CurrencyConverterModel {
    private final DataRepo dataRepo;
    private double calculatedValue;

    public CurrencyConverterModel(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public void calculate(int firstCurrency, int secondCurrency, double amount){

        double firstCurrencyValue = dataRepo.getCurrencyValue(firstCurrency);
        double secondCurrencyValue = dataRepo.getCurrencyValue(secondCurrency);

        int firstCurrencyRatio = dataRepo.getCurrencyRatio(firstCurrency);
        int secondCurrencyRatio = dataRepo.getCurrencyRatio(secondCurrency);

        calculatedValue = Math.round((firstCurrencyValue*amount/firstCurrencyRatio)/(secondCurrencyValue/secondCurrencyRatio)*10000)/10000.0;

    }

    public double getCalculatedValue() {
        return calculatedValue;
    }
}
