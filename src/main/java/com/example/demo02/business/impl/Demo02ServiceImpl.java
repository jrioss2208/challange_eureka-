package com.example.demo02.business.impl;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo02.business.Demo02Service;
import com.example.demo02.model.Persona;
import com.example.demo02.model.Usuario;
import com.example.demo02.config.ApplicationProperties;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Demo02ServiceImpl implements Demo02Service{

    @Autowired
    ApplicationProperties propiedades;

    public ResponseEntity<Persona> postBody(@RequestBody Persona person){

        person.setEmail(propiedades.getUrl());

        return new ResponseEntity<Persona>(person, HttpStatus.OK);

    };

    public String postBody2(@RequestParam String function ,@RequestParam String symbol){

        //adding the query params to the URL
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(propiedades.getUrl())
                .queryParam("function", function)//"TIME_SERIES_DAILY_ADJUSTED"
                .queryParam("symbol", symbol)//"IBM"
                .queryParam("apikey", propiedades.getKey());

        System.out.println(uriBuilder.toUriString());

        ResponseEntity<String> responseEntity2 = new RestTemplate(getClientHttpRequestFactory())
                                                 .getForEntity(uriBuilder.toUriString(), String.class);

        return responseEntity2.getBody();

    };

    public String postBody3(@RequestParam String nombre ,@RequestParam String correo){
        return propiedades.getKey();
    };

    //Override timeouts in request factory
    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() 
    {
        SimpleClientHttpRequestFactory clientHttpRequestFactory
                = new SimpleClientHttpRequestFactory();
        //Connect timeout
        clientHttpRequestFactory.setConnectTimeout(1000);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(1000);
        return clientHttpRequestFactory;
    }
    
}
