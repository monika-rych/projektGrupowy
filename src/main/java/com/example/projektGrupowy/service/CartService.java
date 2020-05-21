package com.example.projektGrupowy.service;

import com.example.projektGrupowy.model.Cart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<Cart> cartList = new ArrayList<>();

    public CartService() {
        cartList.add(new Cart("koszyk1", 1));
        cartList.add(new Cart("koszyk2", 2));
        cartList.add(new Cart("koszyk3", 3));
    }

    public List<Cart> getAll(){
        return cartList;
    }

    public Cart getById(int id){
        return cartList.stream()
                .filter(cart -> cart.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCart(Cart cart){
        cartList.add(cart);
    }

}
