package mylab.order.service;

import mylab.order.entity.ShoppingCart;

public class OrderService {
    private ShoppingCart shoppingCart; // DI 대상

    public OrderService() {}
    public OrderService(ShoppingCart shoppingCart) { // 생성자 주입도 가능
        this.shoppingCart = shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) { // setter 주입
        this.shoppingCart = shoppingCart;
    }
    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public double placeOrderTotal() { // 총액 계산 예시
        return shoppingCart != null ? shoppingCart.totalPrice() : 0.0;
    }
}