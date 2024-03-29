package net.javaguides.springboottransactiondemo2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private String orDerTrackingNumber;
    private String status;
    private String message;
}
