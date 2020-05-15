package com.capstore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.UserAddress;
import com.capstore.app.repository.CustomerRepository;
import com.capstore.app.service.AddressService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/addresses/{userId}")
	public ResponseEntity<List<UserAddress>> getAllAddresses(@PathVariable int userId){
		System.out.println("hii");
		return ResponseEntity.ok().body(addressService.getAllAddresses(userId));
	}
	
	@PostMapping("/address/{userId}")
	public ResponseEntity<List<UserAddress>> saveNewAddress(@PathVariable int userId, @RequestBody UserAddress address){
		addressService.saveNewAddress(userId, address);
		return  ResponseEntity.ok().body(addressService.getAllAddresses(userId));
	}
	@GetMapping("/")
	public List<CustomerDetails> getAllCustomer(){
		return customerRepository.findAll();
	}
	@GetMapping("/{id}")
	public CustomerDetails getCustomer(@PathVariable int id){
		return customerRepository.findById(id).get();
	}
	
}
