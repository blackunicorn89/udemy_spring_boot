package net.javaguides.springboottransactiondemo2.repository;

import net.javaguides.springboottransactiondemo2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
