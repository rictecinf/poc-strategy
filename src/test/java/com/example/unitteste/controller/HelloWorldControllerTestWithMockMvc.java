package com.example.unitteste.controller;

import com.example.unitteste.usecase.HelloWorldUserCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTestWithMockMvc {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWorldUserCase helloWorldUserCase;

//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(helloWorldController).isNotNull();
//    }

    @Test
    @DisplayName("Deveria retornar Hello World")
    void getMessage() throws Exception {

        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }



    @Test
    @DisplayName("Deveria retornar mensages")
    void getMessages() throws Exception {
        List<String> retorno = new ArrayList<>();
        retorno.add(" 1");
        when(helloWorldUserCase.obterStrings()).thenReturn(retorno);

        this.mockMvc.perform(get("/hello/messages")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }




    void getMessageById() throws Exception {


        final Exception exception = assertThrows(Exception.class, () ->
                helloWorldUserCase.obterStrings()
        );
        //assertThat(exception.getMessage(), is("intimacao.abertura.nao.encontrada"));
        //verify(processoTJRJService, never()).atualizarPorIntimacaoAsync(anyString());


        List<String> retorno = new ArrayList<>();
        retorno.add(" 1");

        when(helloWorldUserCase.obterStrings()).thenReturn(retorno);

        //AssertionError.
        this.mockMvc.perform(get("/hello/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }
}