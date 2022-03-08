package com.anjani.controller;
import com.anjani.entity.Category;
import com.anjani.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/save")
    public ResponseEntity<Category>saveCategory(@RequestBody Category cat){
        return new ResponseEntity<Category>(service.save(cat), HttpStatus.ACCEPTED);
    }
    @GetMapping("/allnames")
    public ResponseEntity<List<String>>getAllCategoryNames(){
        return new ResponseEntity<List<String>>(service.getAllCategoryNames(),HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Category>>saveAll(){
        List<Category>catList = new ArrayList<>();
       // FileReader fileReader = new FileReader("src/main/resources/data.txt");
        File file = new File("src/main/resources/data.txt");
        BufferedReader br
                = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
            {
                String[] arr = st.split("&");
                System.out.println(arr[0]);
                catList.add(Category.builder()
                                .id(Long.parseLong(arr[0].trim()))
                                .category(arr[1].trim())
                                .stock(arr[2].trim())
                        .build());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Category>>(service.saveAll(catList),HttpStatus.FOUND);

    }
}
