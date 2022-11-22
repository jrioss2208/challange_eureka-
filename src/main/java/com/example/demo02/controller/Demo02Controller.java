package com.example.demo02.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import com.example.demo02.business.Demo02Service;
import com.example.demo02.model.Persona;
import com.example.demo02.model.Usuario;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/demo02")
@RequiredArgsConstructor
public class Demo02Controller {

    private final Demo02Service service;

    @RequestMapping("/controller")
    public String index() {
        return "Hello Spring Boot!";
    }

    @RequestMapping(value="/get" , method = RequestMethod.GET)
    public List<Object> get() {

        String url = "";
        RestTemplate restTemp = new RestTemplate();

        Object[] objects = restTemp.getForObject(url, Object[].class);

        return Arrays.asList(objects);
    }

    @RequestMapping(value="/post" , headers = "key=HRW98SVT92PUFH1J", method = RequestMethod.POST)
    public List<Object> post() {

        String url = "";
        RestTemplate restTemp = new RestTemplate();

        Object[] objects = restTemp.getForObject(url, Object[].class);

        return Arrays.asList(objects);
    }

    @RequestMapping(value="/postbody" , headers = "key=HRW98SVT92PUFH1J", method = RequestMethod.POST)
    public ResponseEntity<Persona> postBody(@RequestBody Persona person) {        

        return service.postBody(person);   

    }

    @RequestMapping(
        value="/postbody2" , 
        headers = "key=HRW98SVT92PUFH1J",
        method = RequestMethod.POST, 
        produces="application/json")
    public String postBody2(@RequestParam String function ,@RequestParam String symbol) {
        return service.postBody2(function,symbol);
    }

    
    @RequestMapping(
        value="/postbody3" , 
        method = RequestMethod.POST,
        produces="application/json",
        params={"nombre","correo"})
    public String postBody3(@RequestParam String nombre ,@RequestParam String correo) {        

        return service.postBody3(nombre,correo);   

    }

    
}
