package task_05;


import JAXB.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "flowers")
public class Flowers {

    // Каталог имеет список flower
    @XmlElement(name = "flower")
    private List<Flower> flowers = new ArrayList<>();

    // Определяем методы для добавления flower в каталог
    public void add(Flower flower) {
        flowers.add(flower);
    }

    // Метод ту стринг для представления содержания
    @Override
    public String toString() {
        return Arrays.deepToString(flowers.toArray());
    }

}
