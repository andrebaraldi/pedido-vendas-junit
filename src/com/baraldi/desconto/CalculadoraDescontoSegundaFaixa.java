package com.baraldi.desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculadoraFaixaDesconto {

	// Construtor
	// O Construtor receberá um objeto do mesmo tipo, mas que é responsável 
	// pela próxima faixa de cálculo
	public CalculadoraDescontoSegundaFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo); 
	}

	// Calculo especifico dessa classe de 3ª Faixa
	// Esse método será chamado pelo método desconto, herdado da classe
	// mãe abstrata
	@Override
	protected double calcular(double valorTotal) {
		
		// Calculando a 2ª faixa
		if (valorTotal > 800.0 && valorTotal <= 1000.0) {
			return valorTotal * 0.06;
		}
		
		// Aqui indica que estamos passando a responsa para o próximo
		return -1; 
	}

}
