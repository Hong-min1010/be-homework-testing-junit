package com.springboot.homework;
import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import com.springboot.stamp.Stamp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        //given
        int nowCount = 5;
        int earned = 3;
        //when
        int actual = StampCalculator.calculateStampCount(nowCount, earned);
        int expected = nowCount + earned;
        //then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(10);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));
        // when
        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();
        int actual = StampCalculator.calculateEarnedStampCount(order);
        // then
        assertEquals(expected, actual);
    }
}


//1.
//// TODO 여기에 테스트 케이스를 작성해주세요.
//// 주문 한 커피의 수 만큼 증가
//// given
//Stamp stamp = new Stamp();
//        stamp.setStampCount(0);
//OrderCoffee orderCoffee = new OrderCoffee();
//        orderCoffee.setQuantity(3);
//StampCalculator calculator = new StampCalculator();
//
//int expectedCount = calculator.calculateStampCount(stamp.getStampCount(), orderCoffee.getQuantity());
//
//assertEquals(3, expectedCount, "실패 ~");

//2.
//Stamp stamp = new Stamp();
//        stamp.setStampCount(5);
//OrderCoffee orderCoffee = new OrderCoffee();
//        orderCoffee.setQuantity(5);
//Order order = new Order();
//        order.addOrderCoffee(orderCoffee);
//
//int earnedStampCount = StampCalculator.calculateEarnedStampCount(order);
//int sumOrderedCoffees = StampCalculator.calculateStampCount(stamp.getStampCount(), earnedStampCount);
//
//assertEquals(10, sumOrderedCoffees, "fail");
