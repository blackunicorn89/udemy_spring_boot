package net.javaguides.springboottransactiondemo2.repository;

import net.javaguides.springboottransactiondemo2.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
