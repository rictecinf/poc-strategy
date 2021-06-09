package com.example.unitteste.faturamento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FaturamentoStrategyNameEnum{

        FATURAMEMTO_PRE_CONTRATADO("faturamentoPreContratado"),
        FATURAMEMTO_PADRAO_DESCONTO_TEMPORARIO("faturamentoPreContratado"),
        FATURAMENTO_PADRAO("faturamentoPadrao");

        private String strategyNome;
}