package com.example.unitteste;

import com.example.unitteste.client.DomainClient;
import com.example.unitteste.faturamento.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
public class PocFaturamentoApplication {

	@Autowired
	private ProcessaFaturamento processaFaturamento;

	public static void main(String[] args) {
		SpringApplication.run(PocFaturamentoApplication.class, args);
	}

	@PostConstruct
	public  void processarFatutamentoPOC(){


		final DadosFatutamento dadosFatutamentoPadraoA = DadosFatutamento.builder()
				.seguradora("1")
				.dsProduto("Condição Produto - Seguro A")
				.Quantidade(500000)
				.build();
		/*
			tipo de faturamento : FATURAMEMTO_PADRAO_DESCONTO_TEMPORARIO / FATURAMEMTO_PADRAO / FATURAMEMTO_PRE_CONTRATADO
		 */

		processaFaturamento.selecionaTipoFaturamento(FaturamentoStrategyNameEnum.FATURAMEMTO_PADRAO_DESCONTO_TEMPORARIO);
		processaFaturamento.addProduto(dadosFatutamentoPadraoA);
		System.out.println("Sub-Total - "+ dadosFatutamentoPadraoA.getDsProduto()+ " - "+ processaFaturamento.subTotal());


		final DadosFatutamento dadosFatutamentoPadraoB = DadosFatutamento.builder()
				.seguradora("1")
				.dsProduto("Condição Produto - Seguro B")
				.Quantidade(100000)
				.build();


		processaFaturamento.addProduto(dadosFatutamentoPadraoB);
		System.out.println("Sub-Total - "+ dadosFatutamentoPadraoB.getDsProduto()+ " - "+ processaFaturamento.subTotal());


		final DadosFatutamento dadosFatutamentoPadraoC = DadosFatutamento.builder()
				.seguradora("1")
				.dsProduto("Condição Produto - Seguro B")
				.Quantidade(15000)
				.build();

		processaFaturamento.addProduto(dadosFatutamentoPadraoC);
		System.out.println("Sub-Total - "+ dadosFatutamentoPadraoC.getDsProduto()+ " - "+ processaFaturamento.subTotal());


		System.out.println(" Total FATURA "+ processaFaturamento.getTotal());

	}
}
