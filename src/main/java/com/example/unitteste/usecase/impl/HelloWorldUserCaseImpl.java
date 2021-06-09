package com.example.unitteste.usecase.impl;

import com.example.unitteste.usecase.HelloWorldUserCase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldUserCaseImpl implements HelloWorldUserCase {
    @Override
    public List<String> obterStrings() {
        return Arrays.asList( "Hello","World");
    }
}
