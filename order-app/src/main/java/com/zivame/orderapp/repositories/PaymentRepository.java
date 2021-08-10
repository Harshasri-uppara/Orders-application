package com.zivame.orderapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zivame.orderapp.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{
	void deleteByOrderId(int order_id);
}
