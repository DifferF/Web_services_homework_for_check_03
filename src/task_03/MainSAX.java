package task_03;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*
Задание 3
Из задания первого урока. Определить метод,
производящий преобразование разработанного XML-документа в документ,
указанный в каждом задании.
 */

public class MainSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        FlowerHandlerSAX ch = new FlowerHandlerSAX();

        File file = new File("flower.xml");
        parser.parse(file, ch);

        List<Flower> flowers = ch.getFlowers();

        System.out.println("All Flowers: ");

        for (Flower flower : flowers) {
            System.out.println(flower.getStem_color() + " " + flower.getLeaf_color() + " " + flower.getAverage_size() + " "
                    +  flower.getName() + " " +  flower.getSoil() + " " + flower.getOrigin() + " " + flower.getMultiplying());
        }

    }
}
