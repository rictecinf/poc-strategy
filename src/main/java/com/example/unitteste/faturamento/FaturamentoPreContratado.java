package com.example.unitteste.faturamento;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FaturamentoPreContratado implements FaturamentoStrategy {

    private List<Double> totalRegistros = new ArrayList<>();
    private LocalDate dataIsencao = LocalDate.now().plusDays(20);
    private Double subTotal = Double.MIN_VALUE;

    @Override
    public void addProduto(DadosFatutamento dadosFatutamento) {
        totalRegistros.add((dadosFatutamento.getQuantidade()* getPrecoUnitario()) * getDesconto());
    }

    @Override
    public Double custoTotalFatura() {
        return totalRegistros.stream()
                .reduce(0.0, (a, b) -> a + b);
    }

    @Override
    public Double subTotal() {
        return subTotal;
    }

    @Override
    public FaturamentoStrategyNameEnum getStrategyName() {
        return FaturamentoStrategyNameEnum.FATURAMEMTO_PRE_CONTRATADO;
    }

    @Override
    public boolean hasIsencao() {
        return LocalDate.now().isAfter(dataIsencao);
    }

    private Double getDesconto(){
        return 0.1;
    }

    private Double getPrecoUnitario(){
        return 0.20;
    }
}
