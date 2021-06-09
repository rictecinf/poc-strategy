package com.example.unitteste.client;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AgenteTipo {
    private Long id;
    private String nome;
    private String situacao;
}
