package xin.codedream.java8.chap3;

/**
 * 苹果
 *
 * @author NGLSL
 * @date 2018/8/2
 */
public class Apple {
    private Integer weight;
    private String color;
    private String country;

    public Apple() {
        super();
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight, String color, String country) {
        this.weight = weight;
        this.color = color;
        this.country = country;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
