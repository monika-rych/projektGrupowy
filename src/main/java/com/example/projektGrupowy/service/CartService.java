package com.example.projektGrupowy.service;

import com.example.projektGrupowy.dto.CartDTO;
import com.example.projektGrupowy.mapper.CartToDTOMapper;
import com.example.projektGrupowy.model.Cart;
import com.example.projektGrupowy.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    CartRepository cartRepository;
    CartToDTOMapper cartToDTOMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CartToDTOMapper cartToDTOMapper) {
        this.cartRepository = cartRepository;
        this.cartToDTOMapper = cartToDTOMapper;
    }

    public List<CartDTO> getAll(){
        List<Cart> carts = cartRepository.getAll();
        return carts.stream().map(cart -> cartToDTOMapper.getCartDto(cart)).collect(Collectors.toList());
    }

    public CartDTO getById(int id) {
        Cart cart = cartRepository.getById(id);
        return cartToDTOMapper.getCartDto(cart);
    }
// do przejrzenia dla Lukasza
    public void addCart(CartDTO cartDTO){
        Cart cart = new Cart(cartDTO.name, cartDTO.id);
         cartRepository.addCart(cart);
    }
}
