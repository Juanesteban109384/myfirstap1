package co.edu.umanizales.myfirstap.controller;

import co.edu.umanizales.myfirstap.model.Store;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @GetMapping
    public String getStore() {



        return "hola";
    }
}
