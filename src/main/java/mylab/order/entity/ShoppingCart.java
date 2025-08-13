package mylab.order.entity;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public double totalPrice() {
        if (products == null) return 0.0;
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}