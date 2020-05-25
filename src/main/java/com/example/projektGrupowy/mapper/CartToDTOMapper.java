package com.example.projektGrupowy.mapper;

import com.example.projektGrupowy.dto.CartDTO;
import com.example.projektGrupowy.model.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CartToDTOMapper {
    public CartDTO getCartDto(Cart cart) {
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
