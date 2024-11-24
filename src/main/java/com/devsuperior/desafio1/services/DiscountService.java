package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double discount(Order order) {
        return order.getBasic() * (order.getDiscount() / 100);
    }
}
