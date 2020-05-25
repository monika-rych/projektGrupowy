package com.example.projektGrupowy;

import com.example.projektGrupowy.dto.CartDTO;
import com.example.projektGrupowy.model.Cart;
import com.example.projektGrupowy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


//DTO - Data Transfer Object

//localhost::port + " cokolwiek jest przy adnotacji" - jezeli bez requestMapping
//localhost::port + " adnotacja przy requestMapping"+" cokolwiek jest przy adnotacji"
@RestController
@RequestMapping("/cart") // sciezka web
public class CartController {

    CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }


    public CartController() {
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getSomething() {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    //@PathVariable - najczescie uzywane identyfikatory - UUID, int, long, String
    //stworzone do odbierania danych z serwera

    // nie powinno zwracac null
    //TODO zwrocic 404
    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getById(@PathVariable int id) {
        CartDTO cart = service.getById(id);
        if(cart != null){
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // !NIEZWYKLE ISTOTNE INFORMACJE!
    // !!!post mapping i put mapping - konieczna jest adnotacja @RequestBody przy parametrze metody!!!
    @PostMapping
    public ResponseEntity putThat(@RequestBody CartDTO cartDTO) {
        if(cartDTO.name.length()>50){
            return new ResponseEntity("Za dluga nazwa ",HttpStatus.BAD_REQUEST);
        }
        service.addCart(cartDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
//@PutMapping, @PatchMapping,@DeleteMapping dopisac te metody
}
