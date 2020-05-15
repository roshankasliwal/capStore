package com.capstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstore.app.models.CustomerDetails;
import com.capstore.app.models.User;
import com.capstore.app.models.UserAddress;

public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer> {
	
	@Modifying
    @Query(value = "UPDATE customer_details  set address_id =:address where  user_id=:userId",
            nativeQuery = true)
    void updateUser(@Param("address")UserAddress address, @Param("userId") Integer userId);
}
