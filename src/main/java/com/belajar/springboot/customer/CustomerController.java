package com.belajar.springboot.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTOResponse> findByName(@RequestParam String customerName) {
        List<Customer> customers = this.customerService.findAllByName(customerName);
        return customers.stream().map(customer -> CustomerDTOResponse.parse(customer)).collect(Collectors.toList());
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTOResponse> addCustomer(@RequestBody CustomerDTORequest customerDTORequest) {
        Customer customer = Customer.parse(customerDTORequest);
        Customer customerResult = this.customerService.addCustomer(customer);
        CustomerDTOResponse customerDTOResponse = CustomerDTOResponse.parse(customerResult);
        return new ResponseEntity<>(customerDTOResponse, HttpStatus.CREATED);
    }
}
