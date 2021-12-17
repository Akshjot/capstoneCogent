package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.Orders;
import com.cogent.GreatOutdoors.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		ordersRepository.save(order);
		return "Saved the order";
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		Orders o1 = ordersRepository.getById(id);
		return o1;
	}

	@Override
	public String updateOrder(int id, Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrderById(int id) {
		// TODO Auto-generated method stub
		ordersRepository.deleteById(id);
		return "Order deleted";
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> orderList = new ArrayList<Orders>();
		orderList = ordersRepository.findAll();
		return orderList;
	}

	@Override
	public String deleteAllOrders() {
		// TODO Auto-generated method stub
		ordersRepository.deleteAll();
		return "Deleted all orders";
	}

}
