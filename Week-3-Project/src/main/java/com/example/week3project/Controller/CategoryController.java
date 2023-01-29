package com.example.week3project.Controller;

import com.example.week3project.Model.Category;
import com.example.week3project.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryServices;

    @GetMapping("")
    public ResponseEntity getCategories(){
        ArrayList<Category> categories= categoryServices.getCategories();
        return ResponseEntity.status(200).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategory(@PathVariable String id){
        if(categoryServices.getCategory(id) != null) {
            Category category = categoryServices.getCategory(id);
            return ResponseEntity.status(200).body(category);
        }
        return ResponseEntity.status(400).body("Category doesn't exist");
    }

    @PostMapping("")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        categoryServices.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category is Added successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateCategory(@PathVariable String id, @Valid @RequestBody Category category, Errors error){
        if(error.hasErrors()){
            String message= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if(categoryServices.updateCategory(id,category)){
            return ResponseEntity.status(200).body(new ApiResponse("Category is updated successfully"));
        }
        else {
            return ResponseEntity.status(400).body(new ApiResponse("Category does not exist"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){

        if(categoryServices.deleteCategory(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Category is deleted successfully"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("Category does not exist"));
        }
    }


}
