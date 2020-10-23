package homework.作业1;

public class Product implements Comparable<Product>{
    String name;
    int id, price;

    public Product() { Object obj;}

    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        if(this.id == other.id) return this.price < other.price ? 1 : -1;
        return this.id < other.id ? -1 : (this.id==other.id ? 0 : 1);
    }
}
