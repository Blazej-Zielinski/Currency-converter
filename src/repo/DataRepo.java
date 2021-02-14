package repo;

import Entity.CurrencyEntity;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class DataRepo implements LocalRepo {
    private ArrayList<CurrencyEntity> dataList;

    private void fetch(String url) {
        ArrayList<CurrencyEntity> dataList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new URL(url).openStream());
            NodeList listaWalut = doc.getElementsByTagName("pozycja");
            for (int i = 0; i < listaWalut.getLength(); i++) {
                Node p = listaWalut.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    CurrencyEntity entity = new CurrencyEntity();
                    entity.setcId(i + 1);
                    ArrayList<String> tempArray = new ArrayList<>();

                    Element pozycja = (Element) p;
                    NodeList attrList = pozycja.getChildNodes();
                    for (int j = 0; j < attrList.getLength(); j++) {
                        Node attr = attrList.item(j);
                        if (attr.getNodeType() == Node.ELEMENT_NODE) {
                            Element atrybuty = (Element) attr;
                            tempArray.add(atrybuty.getTextContent());
                        }
                    }
                    entity.setName(tempArray.get(0));
                    entity.setRatio(Integer.parseInt(tempArray.get(1)));
                    entity.setCode(tempArray.get(2));
                    entity.setValue(Double.parseDouble(parseValue(tempArray.get(3))));
                    dataList.add(entity);
                }
            }
            dataList.add( new CurrencyEntity(listaWalut.getLength()+1,"Złoty polski",1,"PLN",1));
            this.dataList = dataList;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseValue(String text) {
        return text.replace(",", ".");
    }

    public DataRepo(String url) {
        fetch(url);
    }

    public ArrayList<String> getNames() {
        ArrayList<String> namesList = new ArrayList<>();

        for (CurrencyEntity entity : dataList) {
            namesList.add(entity.getName());
        }
        return namesList;
    }

    public double getCurrencyValue(int index) {
        for (CurrencyEntity entity : dataList) {
            if (entity.getcId() == index) {
                return entity.getValue();
            }
        }
        return 0.0;
    }

    public int getCurrencyRatio(int index) {
        for (CurrencyEntity entity : dataList) {
            if (entity.getcId() == index) {
                return entity.getRatio();
            }
        }
        return 0;
    }
}
