package com.baraldi.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto {

	// Construtor
	// O Construtor receberá um objeto do mesmo tipo, mas que é responsável 
	// pela próxima faixa de cálculo
	// Como essa é a última classe da cadeia, ao instanciar vamos passar o 
	// valor null para ser o "próximo"
	public SemDesconto(CalculadoraFaixaDesconto proximo) {
		super(proximo);		
	}

	// Calculo especifico dessa classe (Sem desconto...)
	// Esse método será chamado pelo método desconto, herdado da classe
	// mãe abstrata
	@Override
	protected double calcular(double valorTotal) {
		
		// Se chegar nesse nível, indica que não tem desconto
		// Repare que aqui não tem próximo (não retornamos -1)
		return 0; 
	}

}
