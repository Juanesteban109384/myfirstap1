package co.edu.umanizales.myfirstap.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
public class Seller
{
   private String identification;
   private String name;
   private String lastName;
   private char gender;
   private byte age;
   private String city;



}