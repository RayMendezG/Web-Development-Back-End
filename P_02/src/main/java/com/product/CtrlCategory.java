package com.product;
/* 
 * Autor: Méndez García Raymundo
 * Número de cuenta: 113001958
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CtrlCategory {
    
    Category c1 = new Category(1, "Abarrotes");
    Category c2 = new Category(2, "Electrónica");
    Category c3 = new Category(3, "Línea Blanca");
    ArrayList<Category> l = new ArrayList<Category>();
    

    @GetMapping("/category")
    public ArrayList<Category> Lista() {
        
        l.add(c1);
        l.add(c2);
        l.add(c3);
        return l;
    }

}