package mylab.order.entity;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product() {} // setter 주입용 기본 생성자

    public Product(String id, String name, double price) { // 생성자 주입용
        this.id = id; this.name = name; this.price = price;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
