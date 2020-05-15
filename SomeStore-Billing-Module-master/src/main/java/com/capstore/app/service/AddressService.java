package com.capstore.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.UserAddress;
import com.capstore.app.repository.CustomerRepository;

@Service
public class AddressService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<UserAddress> getAllAddresses(int userId){
		CustomerDetails customer=customerRepository.findById(userId).get();
		List<UserAddress> addresses= new ArrayList<UserAddress>(customer.getAddresses());
		return addresses;
	}
	
	@Transactional
	public void saveNewAddress(int userId,UserAddress address) {
		CustomerDetails customer=customerRepository.getOne(userId);
		Set<UserAddress> addresses = customer.getAddresses();
		addresses.add(address);
		customer.setAddresses(addresses);
		
	//	customerRepository.save(customer);
		customerRepository.updateUser(address, userId);
		
	}
}
