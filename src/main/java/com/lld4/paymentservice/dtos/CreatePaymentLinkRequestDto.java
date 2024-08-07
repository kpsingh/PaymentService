package com.lld4.paymentservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkRequestDto {
    Long orderId;
}
