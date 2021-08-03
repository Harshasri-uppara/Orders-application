package com.zivame.orderapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zivame.orderapp.models.Order;
import com.zivame.orderapp.repositories.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public List<Order> list(){
		return orderRepository.findAll(); 
	}
	
	@GetMapping
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Optional<Order> get(@PathVariable int id) {
		return orderRepository.findById(id);
	}
	
	@PostMapping
	public Order create(@RequestBody final Order order) {
		return orderRepository.saveAndFlush(order); 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		orderRepository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Order update(@PathVariable int id,@RequestBody Order order) {
		Order existingOrder = orderRepository.findById(id).get();
		BeanUtils.copyProperties(order, existingOrder, "order_id");
		return orderRepository.saveAndFlush(existingOrder);
	}
}
