package com.baraldi.desconto;

public abstract class CalculadoraFaixaDesconto {

	// Indicador do próximo responsável
	// É do mesmo tipo da nossa classe abstrata
	private CalculadoraFaixaDesconto proximo;
	
	// No construtor de cada classe filha, será recebido o próximo
	// responsável. Construtores não são herdaddos e devem ser implementados
	// pelas classes filhas
	public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto proximo) {
		this.proximo = proximo;
	}
	
	// Retorna o desconto.
	// NÃO SERÁ implementado por cada subclasse
	// Elas vão ganhar de graça esse método
	public double desconto(double valorTotal) {	
		
		// Calcula o desconto,
		// aplicando o desconto dentro da sua faixa de responsabilidade	
		double desconto  = calcular(valorTotal);
		
		// Se o valor retornado de calcular() for -1, significa que a faixa de 
		// calculo de desconto é do próximo objeto da mesma classe... 
		if (desconto == -1)
			return proximo.desconto(valorTotal); // vai para próximo objeto, para calcular 		
		
		return desconto;
		
	}
	
	// Método que vai ser implementado nas subclasses, 
	// para calcular o desconto dentro da sua faixa de responsabilidade	
	protected abstract double calcular(double valorTotal); 
	
}
