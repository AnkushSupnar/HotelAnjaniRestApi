package com.anjani.service;

import com.anjani.entity.Login;
import com.anjani.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepository repository;

    public Login saveLogin(Login login)
    {
        repository.save(login);
        return login;
    }
    public List<Login> getAllLogin(){
        return repository.findAll();
    }
    public Login validateLogin(String username,String password){
        return repository.findByUsernameAndPassword(username,password).orElse(null);
    }
    public List<String>getAllUsernames(){
        return repository.findUsernameAsc();
    }
}
