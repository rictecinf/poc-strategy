package com.example.unitteste.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "itp", url = "http://localhost:8081/itp/teste/")
public interface DomainClient {

    @GetMapping(name = "/todos")
    AgenteTipo obterAgenteTipo();

    @GetMapping(name = "/{id}")
    AgenteTipo obterAgenteTipo2(@RequestParam("id") String id);
}
