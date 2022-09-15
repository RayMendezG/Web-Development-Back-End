/* 
 * Autor: Méndez García Raymundo
 * Número de cuenta: 113001958
*/
package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

@RestController
@RequestMapping("/category")
public class CtrlCategory {

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        
        Category c1 = new Category();
        c1.setCategory_id(1);
        c1.setCategory("Abarrotes");
        c1.setStatus(1);

        Category c2 = new Category();
        c2.setCategory_id(2);
        c2.setCategory("Electrónica");
        c2.setStatus(1);

        List<Category> categories = new ArrayList<>();
        categories.add(c1);
        categories.add(c2);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getCategory(@PathVariable int category_id) {     
        Category c1 = new Category();
        c1.setCategory_id(1);
        c1.setCategory("Abarrotes");
        c1.setStatus(1);

        return new ResponseEntity<>(c1, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {    
        String message = "";

        if(bindingResult.hasErrors()) { 
            message = bindingResult.getAllErrors().get(0).getDefaultMessage(); 
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (category.getCategory().equals("Abarrotes") || category.getCategory().equals("Electrónica")) {
            message = "category already exists";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        message = "category created";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{category_id}") 
    public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category, BindingResult bindingResult) {     
        String message = ""; 
        
        if(bindingResult.hasErrors()) { 
            message = bindingResult.getAllErrors().get(0).getDefaultMessage(); 
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST); 
        } else if (category_id != 1 && category_id != 2 ) { 
            message = "category does not exists"; 
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND); 
         }else if (!(category.getCategory().equals("Abarrotes")) && !(category.getCategory().equals("Electrónica"))) { 
            message = "category does not exist"; 
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST); 
        } 
 
        message = "category update"; 
        return new ResponseEntity<>(message, HttpStatus.OK); 
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int category_id) {    
        String message = "";

        if(category_id != 1 && category_id != 2) {
            message = "category does not exists";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        message = "category removed";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}