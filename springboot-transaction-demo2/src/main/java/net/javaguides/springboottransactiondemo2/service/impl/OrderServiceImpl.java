package net.javaguides.springboottransactiondemo2.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboottransactiondemo2.dto.OrderRequest;
import net.javaguides.springboottransactiondemo2.dto.OrderResponse;
import net.javaguides.springboottransactiondemo2.entity.Order;
import net.javaguides.springboottransactiondemo2.entity.Payment;
import net.javaguides.springboottransactiondemo2.repository.PaymentRepository;
import net.javaguides.springboottransactiondemo2.exception.PaymentException;
import net.javaguides.springboottransactiondemo2.repository.OrderRepository;
import net.javaguides.springboottransactiondemo2.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;


    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {

        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("In progress");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("Debit")) {
            throw new PaymentException("Payment card type isn't supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrDerTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
