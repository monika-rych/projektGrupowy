package com.example.projektGrupowy.service;

import com.example.projektGrupowy.dto.CartDTO;
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

    public CartDTO getById(int id) {
        Cart cart = cartRepository.getById(id);
        return getCartDto(cart);
    }

    public void addCart(Cart cart){
        cartRepository.addCart(cart);
    }
    private CartDTO getCartDto(Cart cart) {
        if (cart == null) {
            return null;
        } else {
            CartDTO cartDTO = new CartDTO();
            cartDTO.id = cart.getId();
            cartDTO.name = "Moja nazwa to: " + cart.getName();
            return cartDTO;
        }
    }
}
