package com.cogent.GreatOutdoors.service;

import java.util.List;

import com.cogent.GreatOutdoors.dto.Orders;

public interface OrdersService {
	public String addOrder(Orders order);
	public Orders getOrderById(int id);
	public String updateOrder(int id, Orders order);
	public String deleteOrderById(int id);
	public List<Orders> getAllOrders();
	public String deleteAllOrders();
}
