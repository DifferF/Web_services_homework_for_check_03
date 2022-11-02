package task_03;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
Задание 3
Из задания первого урока. Определить метод,
производящий преобразование разработанного XML-документа в документ,
указанный в каждом задании.
 */

public class MainDOM {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // Создаем экземпляр фабрики
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // Прописываем команду на игнорирование пробелов
        dbf.setIgnoringElementContentWhitespace(true);
        // Создаем документБилдер, с помощью которого будем парсить документ xml
        DocumentBuilder db = dbf.newDocumentBuilder();
        File xmlFile = new File("flower.xml");
        // Парсим объект DocumentBuilder и получаем объект Document
        Document document = db.parse(xmlFile);
        // Получаем корневой элемент
        Element root = document.getDocumentElement();
        // Получаем имя узла в зависимости от его типа
        System.out.println(root.getNodeName());
        // Числовой код полученного типа
        System.out.println(root.getNodeType());
        // С помощью NodeList мы получим список элементов flower(у нас 4 таких элемента в файле)
        NodeList list = root.getElementsByTagName("flower");
        ArrayList<Flower> flowerList = new ArrayList<Flower>();

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            // Обращаемся к i-му элементу, далее к его первому потомку (title) и вытягиваем из этого тега текст
            String stem_color = node.getAttributes().item(2).getNodeValue();
            System.out.println("stem_color: " + stem_color);
            String leaf_color = node.getAttributes().item(1).getNodeValue();
            System.out.println("leaf_color: " + leaf_color);
            int average_size = Integer.parseInt(node.getAttributes().item(0).getNodeValue());
            System.out.println("average_size: " + average_size);

            String name = root.getElementsByTagName("name").item(i).getFirstChild().getTextContent();
            System.out.println("name: " + name);
            String soil = root.getElementsByTagName("soil").item(i).getLastChild().getTextContent();
            System.out.println("soil: " + soil);
            String origin =  root.getElementsByTagName("origin").item(i).getLastChild().getTextContent();
            System.out.println("origin: " + origin);
            String multiplying = root.getElementsByTagName("multiplying").item(i).getLastChild().getTextContent();
            System.out.println("multiplying: " + multiplying);

            Flower testFlower_2 = new Flower(stem_color,leaf_color,average_size,name,soil,origin,multiplying);
            flowerList.add(testFlower_2);
        }



    }




}
