package com.baraldi.desconto;

public class CalculadoraDescontoTerceiraFaixa extends CalculadoraFaixaDesconto {

	// Construtor
	// O Construtor receberá um objeto do mesmo tipo, mas que é responsável 
	// pela próxima faixa de cálculo
	public CalculadoraDescontoTerceiraFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);	
	}

	// Calculo especifico dessa classe de 3ª Faixa
	// Esse método será chamado pelo método desconto, herdado da classe
	// mãe abstrata
	@Override
	protected double calcular(double valorTotal) {
		
		// Calculando a 3ª faixa
		if (valorTotal > 1000.0) {
			return valorTotal * 0.08;
		}
		
		// Aqui indica que estamos passando a responsa para o próximo
		return -1;  
	}

}
