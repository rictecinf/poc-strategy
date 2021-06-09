package com.example.unitteste.controller;


import com.example.unitteste.usecase.HelloWorldUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final HelloWorldUserCase helloWorldUserCase;

    @GetMapping("hello")
    public HttpEntity<?> getMessage(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("hello/{id}")
    public HttpEntity<?> getMessageById(@PathVariable("id") Long id) throws Exception {
        throw new Exception("Erro");
        //return ResponseEntity.ok(id);
    }

    @GetMapping("hello/messages")
    public HttpEntity<List<?>> getMessages(){
        return ResponseEntity.ok(helloWorldUserCase.obterStrings());
    }
}
