package com.example.unitteste.faturamento;

public interface FaturamentoStrategy {

    void addProduto(DadosFatutamento dadosFatutamento);

    Double custoTotalFatura();

    Double subTotal();

    FaturamentoStrategyNameEnum getStrategyName();

    boolean hasIsencao();
}
