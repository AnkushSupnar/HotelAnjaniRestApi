package com.anjani.service;

import com.anjani.entity.Category;
import com.anjani.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category save(Category category){
            repository.save(category);
            return category;
    }
    public List<Category>getAllCategory(){return repository.findAll();}
    public List<String> getAllCategoryNames(){
        return repository.findAllCategoryNames();
    }
    public List<Category>saveAll(List<Category>categories){
       return repository.saveAll(categories);
    }
    public Category getById(Long id){
        return repository.findById(id).orElse(null);
       // return repository.getById(id);
    }
    public Category getByName(String name){
    return repository.getByCategory(name);
    }
}
