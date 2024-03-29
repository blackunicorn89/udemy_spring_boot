package net.javaguides.springboottransactiondemo2.service;

import net.javaguides.springboottransactiondemo2.dto.OrderRequest;
import net.javaguides.springboottransactiondemo2.dto.OrderResponse;
import net.javaguides.springboottransactiondemo2.entity.Order;
import org.springframework.stereotype.Service;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

}
