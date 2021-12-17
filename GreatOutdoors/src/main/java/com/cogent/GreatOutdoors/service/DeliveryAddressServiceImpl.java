package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.DeliveryAddress;
import com.cogent.GreatOutdoors.repository.DeliveryAddressRepository;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
	
	@Autowired
	private DeliveryAddressRepository daRepository;
	
	@Override
	public String saveAddress(DeliveryAddress da) {
		// TODO Auto-generated method stub
		daRepository.save(da);
		return "Saved the address";
	}

	@Override
	public DeliveryAddress getAddressById(int id) {
		// TODO Auto-generated method stub
		DeliveryAddress da1 = daRepository.getById(id);
		return da1;
	}

	@Override
	public String updateAddress(int id, DeliveryAddress da) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddressById(int id) {
		// TODO Auto-generated method stub
		daRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public List<DeliveryAddress> getAllAddress() {
		// TODO Auto-generated method stub
		List<DeliveryAddress> daList = new ArrayList<DeliveryAddress>();
		daList = daRepository.findAll();
		return daList;
	}

	@Override
	public String deleteAllAddress() {
		// TODO Auto-generated method stub
		daRepository.deleteAll();
		return "Deleted all Address";
	}

}
