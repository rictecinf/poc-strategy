package com.example.unitteste.faturamento;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProcessaFaturamento {

    @Autowired
    private FaturamentoFactory faturamentoFactory;
    private FaturamentoStrategy faturamentoStrategy;

    public void selecionaTipoFaturamento(FaturamentoStrategyNameEnum fatutamento){
        faturamentoStrategy = faturamentoFactory.findPagamentoStrategyPorNome(fatutamento);
    }

    public void addProduto(DadosFatutamento dadosFatutamento){
        faturamentoStrategy.addProduto(dadosFatutamento);
    }

    public Double getTotal(){
        return faturamentoStrategy.custoTotalFatura();
    }

    public Double subTotal(){
        return faturamentoStrategy.subTotal();
    }

}
