package com.capstore.app.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/addresses/{userId}")
	public ResponseEntity<List<UserAddress>> getAllAddresses(@PathVariable int userId){
		return ResponseEntity.ok().body(addressService.getAllAddresses(userId));
	}
	
	@PostMapping("/address/create/{userId}")
	public ResponseEntity<List<UserAddress>> saveNewAddress(@PathVariable int userId, @RequestBody UserAddress address){
		addressService.saveNewAddress(userId, address);
		return  ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/address/delete/{userId}/{addressId}")
	public ResponseEntity<List<UserAddress>> deleteAddress(@PathVariable int userId, @PathVariable int addressId){
		addressService.deleteAddress(addressId);
		return  ResponseEntity.ok().body(addressService.getAllAddresses(userId));
	}
	
	// Below two methodes written only for checking purpose..
	@GetMapping("/")
	public List<CustomerDetails> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public CustomerDetails getCustomer(@PathVariable int id){
		return customerRepository.findById(id).get();
	}
	
}
