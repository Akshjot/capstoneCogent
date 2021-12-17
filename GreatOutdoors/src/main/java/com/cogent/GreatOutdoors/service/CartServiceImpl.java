package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.Cart;
import com.cogent.GreatOutdoors.dto.User;
import com.cogent.GreatOutdoors.repository.CartRepository;
import com.cogent.GreatOutdoors.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Cart addCart(Cart c) {
		// TODO Auto-generated method stub
		Cart c1 = cartRepository.save(c);
		return c1;
	}

	@Override
	public String updateCart(int id, Cart c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCartById(int id) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public List<Cart> getCartById(int id) {
		// TODO Auto-generated method stub
		return cartRepository.findById(id);
	}

	@Override
	public String deleteAllCart() {
		// TODO Auto-generated method stub
		cartRepository.deleteAll();
		return "Deleted All";
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		List<Cart> cartList = new ArrayList<Cart>();
		cartList = cartRepository.findAll();
		return cartList;
	}

	@Override
	public List<Cart> getCartByUserId(int id) {
		// TODO Auto-generated method stub
		User user = userRepository.getById(id);
		return cartRepository.findByUser(user);
	}

	@Override
	public void deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.delete(cart);
	}
	
	

}
