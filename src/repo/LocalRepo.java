package repo;

import java.util.ArrayList;

public interface LocalRepo {
    ArrayList<String> getNames();
    double getCurrencyValue(int index);
    int getCurrencyRatio(int index);
}
