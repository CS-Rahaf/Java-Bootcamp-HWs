package com.example.week3project.Service;

import com.example.week3project.Model.Category;
import com.example.week3project.Model.Merchant;
import com.example.week3project.Model.Product;
import com.example.week3project.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();


    public ArrayList<Category> getCategories(){
        return categories;
    }

    public Category getCategory(String id){
        for (Category category: categories) {
            if(category.getId().equals(id))
                return category;
        }
        return null;

    }

    public int addCategory(Category category){
        if(isExist(category.getId())){
            return -1;
        }
        else{
            categories.add(category);
            return 0;
        }
    }

    public boolean updateCategory(String id, Category category){
        if(isExist(id)){
            for (Category categoryLoop: categories) {
                if(categoryLoop.getId().equals(id)){
                    int index= categories.indexOf(categoryLoop);
                    categories.set(index,category);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteCategory(String id){
        if(isExist(id)){
            for (Category categoryLoop: categories) {
                if(categoryLoop.getId().equals(id)){
                    int index= categories.indexOf(categoryLoop);
                    categories.remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(String id){
        for (Category category : categories) {
            if(category.getId().equals(id))
                return true;
        }
        return false;
    }

}
