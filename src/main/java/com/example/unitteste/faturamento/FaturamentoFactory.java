package com.example.unitteste.faturamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class FaturamentoFactory {

    private Map<FaturamentoStrategyNameEnum, FaturamentoStrategy> strategies = new HashMap<FaturamentoStrategyNameEnum, FaturamentoStrategy>();

    public FaturamentoStrategy findPagamentoStrategyPorNome(FaturamentoStrategyNameEnum strategyNome) {
        return strategies.get(strategyNome);
    }

    @Autowired
    public FaturamentoFactory(Set<FaturamentoStrategy> strategySet) {
        createStrategy(strategySet);
    }

    private void createStrategy(Set<FaturamentoStrategy> strategySet) {
        strategySet.forEach(
                strategy ->strategies.put(strategy.getStrategyName(), strategy));
    }


}
