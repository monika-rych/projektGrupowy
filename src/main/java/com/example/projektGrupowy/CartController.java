package com.example.projektGrupowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//localhost::port + " cokolwiek jest przy adnotacji" - jezeli bez requestMapping
//localhost::port + " adnotacja przy requestMapping"+" cokolwiek jest przy adnotacji"
@RequestMapping("/cart") // sciezka web
public class CartController {

    @Autowired
    public CartController() {

    }

    @GetMapping
    public String getSomething(){
        return "Bla bla";
    }




    // !NIEZWYKLE ISTOTNE INFORMACJE!
    // !!!post mapping i put mapping - konieczna jest adnotacja @RequestBody przy parametrze metody!!!
    @PostMapping
    public void putThat(@RequestBody String str){
        System.out.println("Zrobione " + str);
    }

}
