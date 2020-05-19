package com.capstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstore.app.models.UserAddress;

public interface UserAddressRepositiry extends JpaRepository<UserAddress,Integer> {

}
