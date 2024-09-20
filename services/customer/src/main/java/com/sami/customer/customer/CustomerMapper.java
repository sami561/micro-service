package com.sami.customer.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if(request== null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .email(request.email())
                .address(request.address())
                .lastname(request.lastname())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getEmail(),
                customer.getLastname(),
                customer.getAddress()

        );
    }
}
