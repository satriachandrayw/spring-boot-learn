package com.belajar.springboot.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllByName(String name) {
        return this.customerRepository.findByName(name);
    }

	public Customer addCustomer(Customer customer) {
		return this.customerRepository.save(customer);
	}

}
