package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private DiscountService discountService;

    public double total(Order order) {
        double discount = discountService.discount(order);
        double shipping = shippingService.shipment(order);
        return order.getBasic() - discount + shipping;
    }
}
