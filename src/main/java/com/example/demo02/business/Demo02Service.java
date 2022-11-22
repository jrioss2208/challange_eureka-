package com.example.demo02.business;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo02.model.Persona;
//import com.example.demo02.model.Usuario;

public interface Demo02Service {

    ResponseEntity<Persona> postBody(@RequestBody Persona person);

    String postBody2(@RequestParam String function ,@RequestParam String symbol);

    String postBody3(@RequestParam String nombre ,@RequestParam String correo);
    
}
