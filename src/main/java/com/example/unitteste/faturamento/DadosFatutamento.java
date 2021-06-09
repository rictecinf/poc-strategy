package com.example.unitteste.faturamento;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DadosFatutamento {

    private String seguradora;
    private Integer Quantidade;
    private String dsProduto;

}
