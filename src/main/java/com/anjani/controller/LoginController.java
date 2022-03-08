package com.anjani.controller;

import com.anjani.entity.Login;
import com.anjani.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired private LoginService service;

    @PostMapping("/save")
    public ResponseEntity<Login>saveLogin(@RequestBody Login login){
        service.saveLogin(login);
        return new ResponseEntity<Login>(service.saveLogin(login),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Login>>getAllLogin(){
        return new ResponseEntity<List<Login>>(service.getAllLogin(),HttpStatus.FOUND);
    }
    @GetMapping("/validate")
    public ResponseEntity<Login>validateLogin(@RequestParam("username")String username,@RequestParam("password")String password){
        return new ResponseEntity<Login>(service.validateLogin(username,password),HttpStatus.FOUND);
    }
    @GetMapping("/allusernames")
    public ResponseEntity<List<String>>getAllUserNames(){
        return new ResponseEntity<List<String>>(service.getAllUsernames(),HttpStatus.FOUND);
    }

}
