package com.anjani.service;

import com.anjani.entity.Item;
import com.anjani.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item>getAllItem(){return repository.findAll();}
    public List<String>getAllItemNames(){return repository.findAllItemName();}
    public Item getById(Long id){return repository.findById(id).orElse(null);}
    public Item getByItemname(String itemname){return repository.findByItemname(itemname).orElse(null);}
    public List<Item>getByCategoryId(Long catid){return repository.findByCatid_IdOrderByItemnameAsc(catid);}

    public List<Item>saveAll(List<Item>itemlist){return repository.saveAll(itemlist);}
    public Item save(Item item){return repository.save(item);}
    public List<String>getItemNamesByCategoryName(String name){
        return repository.findItemNameByCategoryName(name);
    }
    public Item getByCode(Integer code){
        return repository.findByItemcode(code);
    }
}
