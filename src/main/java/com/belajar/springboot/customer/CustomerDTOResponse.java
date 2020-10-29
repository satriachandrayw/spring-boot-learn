package com.belajar.springboot.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTOResponse {
    private Long id;
    private String name;

    public static CustomerDTOResponse parse(Customer customer) {
        return CustomerDTOResponse.builder().id(customer.getId()).name(customer.getName()).build();
    }
}
