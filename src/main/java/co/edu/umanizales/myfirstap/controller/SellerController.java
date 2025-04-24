package co.edu.umanizales.myfirstap.controller;

import co.edu.umanizales.myfirstap.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/seller")
public class SellerController {
    @GetMapping
    public Seller getSeller() {
        Seller juan = new Seller ("2355155","juan ","carvajal",'M', (byte) 23, "Manizales");
        Seller sebas = new Seller("52515565","sebas","ocampo",'M', (byte) 25, "Manizales");
        Seller esteban = new Seller("524854655","esteban","gil",'M', (byte) 22, "Manizales");
        Seller maria = new Seller ("5115121215","maria","arenas",'F', (byte)25 , "Manizales");
        Seller jose = new Seller ("2555155","jose","rodriguez",'M', (byte) 27, "Manizales");

        return juan ;

    }


}




