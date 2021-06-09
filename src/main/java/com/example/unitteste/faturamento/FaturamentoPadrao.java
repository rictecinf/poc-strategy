package com.example.unitteste.faturamento;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FaturamentoPadrao implements FaturamentoStrategy {

    private List<Double> totalFatura = new ArrayList<>();
    private LocalDate dataIsencao = LocalDate.now().minusDays(2);
    private Double subTotal = Double.MIN_VALUE;

    @Override
    public void addProduto(DadosFatutamento dadosFatutamento) {
        //TODO: validar faixa para definição de custo unitário
        log.info("Quantidade de Registro " + dadosFatutamento.getQuantidade());
        Double valorSemDesconto = (dadosFatutamento.getQuantidade().doubleValue() * getPrecoUnitario());
        Double valorComDesconto = getDesconto() > 1d ?  valorSemDesconto - (valorSemDesconto * getDesconto()) : valorSemDesconto;
        Double valorComVigencia = hasIsencao() ? (valorComDesconto * - 1) : valorComDesconto;
        subTotal = valorComVigencia;
        totalFatura.add(subTotal);
    }

    @Override
    public Double custoTotalFatura() {
       return totalFatura.stream().reduce(0d ,(a, b)-> a+ b);
    }

    @Override
    public Double subTotal() {
        return subTotal;
    }

    @Override
    public FaturamentoStrategyNameEnum getStrategyName() {
        return FaturamentoStrategyNameEnum.FATURAMENTO_PADRAO;
    }

    @Override
    public boolean hasIsencao() {
        return LocalDate.now().isAfter(dataIsencao); // verificar se o produto tem desconto vigente
    }


    private Double getDesconto(){
        return 1d; // padrao não tem desconto
    }

    private Double getPrecoUnitario(){
        return 0.0100; // usar faixa para determinar o preço unitário
    }
}
