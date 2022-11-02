package task_05;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/*
Задание 5+
Из задания первого урока. С помощью JAXB распарсить XML-документ.
 */

public class Main {

    public static void main(String[] args) {
        // Создаем каталог и добавляем туда цветы

        Flowers flowers = new Flowers();
        flowers.add(new Flower("Зеленый_1","Зеленый_2",10,"Растения_01","подзолистая","место происхождения_01","листьями"));
        flowers.add(new Flower("Зеленый_2","Зеленый_2",20,"Растения_02","подзолистая_2","место происхождения_02","листьями_2"));

        try {
            // Создаем файл
            File file = new File("flower_task_05.xml");
            // Вызываем статический метод JAXBContext и указываем что корневым элементом будет Flowers
            JAXBContext jaxbContext = JAXBContext.newInstance(Flowers.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельное форматирование. Указываем маршалеру характеристики
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем каталог в файл, marshal(из памяти, в файл)
            mar.marshal( flowers, file);
            // А также указываем, что каталог выводим и в стандартный вывод - в консоль
            mar.marshal( flowers, System.out);

            // Теперь используя контекст, создаем демаршеллер
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            // Получаем наш каталог из файла и выводим его
            flowers = (Flowers) unmar.unmarshal(file);
            System.out.println( flowers);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}