package com.example.projektGrupowy.service;

import com.example.projektGrupowy.model.Cart;
import com.example.projektGrupowy.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAll(){

        return cartRepository.getAll();
    }

    public Cart getById(int id){
        return cartRepository.getById(id);
    }

    public void addCart(Cart cart){
        cartRepository.addCart(cart);
    }

}
