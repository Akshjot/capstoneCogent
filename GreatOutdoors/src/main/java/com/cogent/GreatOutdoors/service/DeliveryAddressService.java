package com.cogent.GreatOutdoors.service;

import java.util.List;

import com.cogent.GreatOutdoors.dto.DeliveryAddress;

public interface DeliveryAddressService {
	public String saveAddress(DeliveryAddress da);
	public DeliveryAddress getAddressById(int id);
	public String updateAddress(int id, DeliveryAddress da);
	public String deleteAddressById(int id);
	public List<DeliveryAddress> getAllAddress();
	public String deleteAllAddress();
}
