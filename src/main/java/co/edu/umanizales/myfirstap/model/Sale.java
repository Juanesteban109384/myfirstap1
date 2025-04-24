package co.edu.umanizales.myfirstap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
public class Sale {
    private String product;
    private int quantity;
    private double price;
    private String date;
}
