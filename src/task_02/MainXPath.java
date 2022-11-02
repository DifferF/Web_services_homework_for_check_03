package task_02;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
Задание 2+
Из задания первого урока с помощью XPath распарсить XML-документ.
 */

public class MainXPath {

    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory factory = XPathFactory.newInstance();
//      С помощью фабрики создаем экземпляр XPath
        XPath path = factory.newXPath();
//      Здесь нужно попробовать несколько вариантов написания выржаения, чтобы понять, что оно забирает из файла

        XPathExpression expression = path.compile("//flower/* | //flower/@*"); // - получение всех полей

//      Создаем файл и передаем туда наш xml файл
        File xml = new File("flower.xml");

        InputSource source = new InputSource(new FileInputStream(xml));

//      Передаем для оценки источник и вторым параметром определяем тот вид, в котором мы хотим получить результат
//      В нашем случае мы хотим получить упорядоченный набор узлов
        Object result = expression.evaluate(source, XPathConstants.NODESET);
//      Кастим принудительно полученный результат в нодлист для возможности обращаться к элементам во время перебора
        NodeList list = (NodeList) result;

//        Перебираем узлы и получаем данные для вывода
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.print("Node name: " + node.getNodeName());
            System.out.print("\t\t Node value: " + node.getFirstChild().getNodeValue());
            System.out.print("\n");
//      Разделитель между блоками по последнему тегу блока
            if (node.getNodeName().equals("multiplying")){
                System.out.println("\n");
            }

        }
    }
}
