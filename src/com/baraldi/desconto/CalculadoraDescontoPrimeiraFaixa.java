package com.baraldi.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

	// Construtor
	// O Construtor receberá um objeto do mesmo tipo, mas que é responsável 
	// pela próxima faixa de cálculo
	public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);		 
	}

	// Calculo especifico dessa classe de 3ª Faixa 
	// Esse método será chamado pelo método desconto, herdado da classe
	// mãe abstrata
	@Override
	protected double calcular(double valorTotal) {
		
		// Calculando a 1ª faixa
		if (valorTotal > 300.0 && valorTotal <= 800.0) {
			return valorTotal * 0.04;
		}
		
		// Aqui indica que estamos passando a responsa para o próximo
		return -1; 
	}

}
