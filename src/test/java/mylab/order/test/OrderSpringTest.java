package mylab.order.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mylab.order.entity.ShoppingCart;
import mylab.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired private ShoppingCart shoppingCart;
    @Autowired private OrderService orderService;

    @Test
    public void testShoppingCartInjected() {
        System.out.println("\n=== [TEST] 장바구니 주입 및 내용 확인 ===");
        System.out.println("shoppingCart bean = " + shoppingCart);

        assertNotNull("shoppingCart 주입 실패", shoppingCart);
        assertNotNull("products 가 null", shoppingCart.getProducts());

        System.out.println("products size = " + shoppingCart.getProducts().size());
        shoppingCart.getProducts().forEach(p ->
            System.out.println(" - " + p.getId() + " / " + p.getName() + " / " + p.getPrice())
        );

        assertEquals("상품 수 불일치", 2, shoppingCart.getProducts().size());
        assertEquals("첫 번째 상품명이 다름", "노트북",
                shoppingCart.getProducts().get(0).getName());
        assertEquals("두 번째 상품명이 다름", "스마트폰",
                shoppingCart.getProducts().get(1).getName());
    }

    @Test
    public void testOrderServiceInjected() {
        System.out.println("\n=== [TEST] 주문 서비스 주입 및 총합 확인 ===");

        assertNotNull("orderService 주입 실패", orderService);
        assertNotNull("orderService.shoppingCart 주입 실패", orderService.getShoppingCart());

        double total = orderService.placeOrderTotal();
        System.out.printf("총 주문 금액 = %,.0f%n", total);

        assertEquals("총액 불일치", 950000.0, total, 0.0001);
    }
}