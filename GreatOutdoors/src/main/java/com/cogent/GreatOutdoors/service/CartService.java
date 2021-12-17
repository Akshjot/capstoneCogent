package com.cogent.GreatOutdoors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.Cart;
import com.cogent.GreatOutdoors.dto.User;

@Service
public interface CartService {
	public Cart addCart(Cart c);
	public String updateCart(int id, Cart c);
	public String deleteCartById(int id);
	public List<Cart> getCartById(int id);
	public String deleteAllCart();
	public List<Cart> getAllCarts();
	public List<Cart> getCartByUserId(int id);
	public void deleteCart(Cart cart);
}
