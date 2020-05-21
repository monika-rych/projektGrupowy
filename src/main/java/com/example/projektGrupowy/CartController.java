package com.example.projektGrupowy;

import com.example.projektGrupowy.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
//localhost::port + " cokolwiek jest przy adnotacji" - jezeli bez requestMapping
//localhost::port + " adnotacja przy requestMapping"+" cokolwiek jest przy adnotacji"
@RequestMapping("/cart") // sciezka web
public class CartController {

    private List<Cart> cartList = new ArrayList<>();

    @Autowired
    public CartController() {
        cartList.add(new Cart("koszyk1", 1));
        cartList.add(new Cart("koszyk2", 2));
        cartList.add(new Cart("koszyk3", 3));
    }

    @GetMapping
    public List<Cart> getSomething(){
        return cartList;
    }


    //@PathVariable - najczescie uzywane identyfikatory - UUID, int, long, String
    //stworzone do odbierania danych z serwera
    @GetMapping("/{id}")
    public String getById(@PathVariable int id){
        return "Wyslane id " + id;
    }

    // !NIEZWYKLE ISTOTNE INFORMACJE!
    // !!!post mapping i put mapping - konieczna jest adnotacja @RequestBody przy parametrze metody!!!
    @PostMapping
    public void putThat(@RequestBody String str){
        System.out.println("Zrobione " + str);
    }

}
