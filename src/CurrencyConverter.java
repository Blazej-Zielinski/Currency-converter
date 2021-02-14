import controller.CurrencyConverterController;
import model.CurrencyConverterModel;
import repo.DataRepo;
import view.CurrencyConverterView;

public class CurrencyConverter {
    public static void main(String[] args) {
        DataRepo dataRepo = new DataRepo("https://www.nbp.pl/kursy/xml/lasta.xml");

        CurrencyConverterView theView = new CurrencyConverterView(dataRepo.getNames());
        CurrencyConverterModel theModel = new CurrencyConverterModel(dataRepo);

        new CurrencyConverterController(theView,theModel);
    }
}
