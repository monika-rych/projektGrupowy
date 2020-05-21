package com.example.projektGrupowy.repository;

import com.example.projektGrupowy.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    private List<Cart> cartList = new ArrayList<>();

    public CartRepository() {
        cartList.add(new Cart("koszyk1", 1));
        cartList.add(new Cart("koszyk2", 2));
        cartList.add(new Cart("koszyk3", 3));
    }

    public List<Cart> getAll() {
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
