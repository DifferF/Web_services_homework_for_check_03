package task_03;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class FlowerHandlerSAX extends DefaultHandler {

    private String currentQName;
    private List<Flower> flowers;
    // ссылка на текущее растение будет меняться в зависимости от того, на какой строке документа находится парсер
    private Flower currentFlower;  //
    private String stemAttribute;
    private String leafAttribute;
    private String averageAttribute;

    public FlowerHandlerSAX() {
        flowers = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        currentQName = qName;

        if (attributes.getLength() > 0) {
            stemAttribute = attributes.getValue(0);
            leafAttribute = attributes.getValue(1);
            averageAttribute = attributes.getValue(2);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
        switch (currentQName) {
            case "flower" :
                currentFlower = new Flower();
                currentFlower.setStem_color(stemAttribute);
                currentFlower.setLeaf_color(leafAttribute);
                currentFlower.setAverage_size(Integer.parseInt(averageAttribute));
                break;
            case "name" :
                currentFlower.setName(value);
                break;
            case "soil" :
                currentFlower.setSoil(value);
                break;
            case "origin" :
                currentFlower.setOrigin(value);
            case "multiplying" :
                currentFlower.setMultiplying(value);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        currentQName = "";

        if (qName.equals("flower")) {
            flowers.add(currentFlower);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

}
