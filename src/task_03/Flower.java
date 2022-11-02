package task_03;

/*
Задание 3
Из задания первого урока. Определить метод,
производящий преобразование разработанного XML-документа в документ,
указанный в каждом задании.
 */

public class Flower implements Comparable<Flower> {

    private String stem_color;
    private String leaf_color;
    private int average_size;
    private String name;
    private String soil;
    private String origin;
    private String multiplying;



    public Flower() {
    }

    public Flower(String stem_color, String leaf_color, int average_size, String name, String soil, String origin, String multiplying) {
        this.stem_color = stem_color;
        this.leaf_color = leaf_color;
        this.average_size = average_size;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.multiplying = multiplying;
    }

    public String getStem_color() {
        return stem_color;
    }

    public void setStem_color(String stem_color) {
        this.stem_color = stem_color;
    }

    public String getLeaf_color() {
        return leaf_color;
    }

    public void setLeaf_color(String leaf_color) {
        this.leaf_color = leaf_color;
    }

    public int getAverage_size() {
        return average_size;
    }

    public void setAverage_size(int average_size) {
        this.average_size = average_size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "\n" +  " average_size = " + average_size + " name = " + name;
    }

    public String stringPrint() {
        return " stem_color : " + stem_color + " | "
                + " leaf_color : " + leaf_color + " | "
                + " average_size : " + average_size + " | "
                + " name : " + name + " | "
                + " soil : " + soil + " | "
                + " origin : " + origin + " | "
                + " multiplying : " + multiplying;



    }

    @Override
    public int compareTo(Flower o) {
        {
            if (this.average_size != o.getAverage_size()) {
                return this.average_size - o.getAverage_size();
            }
            return this.name.compareTo(o.getName());
        }
    }
}
