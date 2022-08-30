package com.baraldi.test;

import com.baraldi.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.baraldi.desconto.CalculadoraDescontoSegundaFaixa;
import com.baraldi.desconto.CalculadoraDescontoTerceiraFaixa;
import com.baraldi.desconto.CalculadoraFaixaDesconto;
import com.baraldi.desconto.SemDesconto;
import com.baraldi.model.ItemPedido;
import com.baraldi.model.Pedido;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	// Construtor
	// Instancia um pedido, já contendo a calculadora
	public PedidoBuilder() {
		
		// USANDO DESIGN PATTERN : CHAIN OF RESPONSABILITY
		// Veja que vamos encadeando as chamadas de nossa calculadora.
		// Cada um vai chamar a próxima classe de acordo com a responsabildade de cada uma...
		// Cada uma dessas classes instancia (em seus construtores) a próxima classe responsável.
		// Então elas saberão chamar o cálculo certinho (caso a faixa de desconto não seja
		// responsabilidade sua).
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 				
			new CalculadoraDescontoTerceiraFaixa(					
				new CalculadoraDescontoSegundaFaixa(						
					new CalculadoraDescontoPrimeiraFaixa(							
						new SemDesconto(null))));
		
		// Instanciamos um pedido que irá receber uma calculadora como 
		// parâmetro para injetar.
		// No caso, vai receber da 3º faixa.
		// Por si só, pelo padrão CHAIN OF RESPONSABILITY, essa calculadora da 
		// 3ª faixa saberá a quem delegar a responsabilidade de cálculo
		instancia = new Pedido(calculadoraFaixaDesconto);
		
	}
	
	// Adiciona item à instancia do pedido
	// Retorna um Builder (que é o nosso próprio Builder)
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade) );
		
		// Retornar nosso próprio Builder
		return this;
	}

	// Esse seria o Build (que retorna o objeto Pedido construído/finalizado)
	public Pedido construir() {
		return instancia;
	}
	
	
}
