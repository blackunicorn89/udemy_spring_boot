package net.javaguides.springboottransactiondemo2.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboottransactiondemo2.entity.Order;
import net.javaguides.springboottransactiondemo2.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
