package com.anjani.controller;

import com.anjani.entity.Category;
import com.anjani.entity.Item;
import com.anjani.service.CategoryService;
import com.anjani.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;
    @Autowired
    private CategoryService categoryService;
    public ItemController(ItemService service)
    {
        this.service = service;
    }
   // @GetMapping
    public ResponseEntity<List<Item>>saveAll(){
        List<Item>itemList = new ArrayList<>();
        // FileReader fileReader = new FileReader("src/main/resources/data.txt");
        File file = new File("src/main/resources/data.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
            {
                String[] arr = st.split(",");
                System.out.println(arr[0]);
                itemList.add(
                        Item.builder()
                                .id(Long.parseLong(arr[0]))
                                .itemname(arr[1])
                                .catid(categoryService.getById(Long.parseLong(arr[2])))
                                .rate(Float.parseFloat(arr[3]))
                                .itemcode(Integer.parseInt(arr[4]))
                                .build()
                );

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<List<Item>>(service.saveAll(itemList),HttpStatus.FOUND);

    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Item>getById(@PathVariable("id")Long id){
        return new ResponseEntity<Item>(service.getById(id),HttpStatus.FOUND);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Item>>getAllItems(){
        return new ResponseEntity<List<Item>>(service.getAllItem(),HttpStatus.OK);
    }
    @GetMapping("/allnames")
    public ResponseEntity<List<String>>getAllNames(){
       return new ResponseEntity<List<String>>(service.getAllItemNames(),HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<Item>getByNames(@PathVariable("name")String name){
       return new ResponseEntity<Item>(service.getByItemname(name),HttpStatus.OK);
    }
    @GetMapping("/byCatid/{id}")
    public ResponseEntity<List<Item>>getByCatId(@PathVariable("id")Long id){
        return new ResponseEntity<List<Item>>(service.getByCategoryId(id),HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Item>saveItem(@RequestBody Item item){
        return new ResponseEntity<Item>(service.save(item),HttpStatus.OK);
    }
    @GetMapping("/bycategoryname/{name}")
    public ResponseEntity<List<String>>getBycategoryName(@PathVariable("name") String name){
        service.getItemNamesByCategoryName(name).stream().forEach(System.out::println);
        return new ResponseEntity<List<String>>(service.getItemNamesByCategoryName(name),HttpStatus.OK);
    }

}
