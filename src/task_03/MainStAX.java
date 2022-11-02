package task_03;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

/*
Задание 3
Из задания первого урока. Определить метод,
производящий преобразование разработанного XML-документа в документ,
указанный в каждом задании.
 */

public class MainStAX {

    private static String stem_color;
    private static String leaf_color;
    private static int average_size;
    private static String name;
    private static String soil;
    private static String origin;
    private static String multiplying;
    private static ArrayList<Flower> flowerList = new ArrayList<Flower>();
    private static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        // Создаем фабрику
        XMLInputFactory factory = XMLInputFactory.newFactory();
        // Класс для чтения символов
        Reader reader = new FileReader("flower.xml");

        // Для обеспечения прямого доступа к чтению файла с помощью итератора
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);
        // Если есть следующий элемент, то мы его берем и анализируем

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                // Если это стартовый элемент, то получаем его имя
                case XMLStreamReader.START_ELEMENT:
                    String elem = xmlStreamReader.getName().toString();
                    // Анализируем полученный элемент. В зависимости от него осуществляем набор действий.
                    switch (elem) {
                        case "flower":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                switch (attributeName) {
                                    case "stem_color":
                                        stem_color = attributeValue;
                                        break;
                                    case "leaf_color":
                                        leaf_color = attributeValue;
                                        break;
                                    case "average_size":
                                        average_size = Integer.parseInt(attributeValue);
                                        break;
                                }
                            }
                            break;
                        case "name":
                            name = xmlStreamReader.getElementText();
                            break;
                        case "soil":
                            soil = xmlStreamReader.getElementText();
                            break;
                        case "origin":
                            origin = xmlStreamReader.getElementText();
                            break;
                        case "multiplying":
                            multiplying = xmlStreamReader.getElementText();
                            break;
                    }
                    break;

                case XMLStreamReader.END_ELEMENT:
                    String test = String.valueOf(xmlStreamReader.getName());

                    if( test.equals("flower") ){
                        System.out.println( "flower " + counter );
                        Flower testFlower_2 = new Flower(stem_color,leaf_color,average_size,name,soil,origin,multiplying);
                        flowerList.add(testFlower_2);
                        System.out.println( flowerList.get(counter).stringPrint() );
                        counter++;
                    }
                    break;
            }
        }



    }
}
