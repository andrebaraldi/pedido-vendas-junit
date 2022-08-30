package com.baraldi.model;

import java.util.ArrayList;
import java.util.List;

import com.baraldi.desconto.CalculadoraFaixaDesconto;
import com.baraldi.test.QuantidadeItensInvalidosException;

public class Pedido {
	
	// Itens do Pedido
	private List<ItemPedido> itens = new ArrayList<>();
	
	// Injetando nossa calculdora de faixa de desconto..
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto; 
	
	// No Construtor do Pedido, já injetamos...
	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}

	// Adicionar Item
	public void adicionarItem(ItemPedido itemPedido) {
		
		validarQuantidadeItens(itemPedido);	
		itens.add(itemPedido); 		
	}
	
	// Valida quantidade de Itens e lança exception
	public void validarQuantidadeItens(ItemPedido itemPedido) {
		
		if (itemPedido.getQuantidade() < 0 ) throw new QuantidadeItensInvalidosException();
	}
		
	
	// Retorna o resumo do Pedido
	public ResumoPedido resumo() {
	
		// Somamos o valor total x Quantidade (Stream JAVA 8)
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
		
		// Passamos o valor total à nossa calculadora
		// No caso, foi injetada, pela classe de Teste, uma calculadora
		// na 3ª faixa de Cálculo (esta chamará as classes das faixas subsquentes)
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
		
		// Retornamos o resumo do pedido..
		return new ResumoPedido(valorTotal, desconto);
	}
	

}
