package com.baraldi.model;

import java.util.Objects;

public class ResumoPedido {
	

	private double valorTotal;
	private double desconto;

	public ResumoPedido(double valorTotal, double desconto) {
		super();
		this.valorTotal = valorTotal;
		this.desconto = desconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getDesconto() {
		return desconto;
	}
 
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	
	// Equals and HashCode
	@Override
	public int hashCode() {
		return Objects.hash(desconto, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ResumoPedido other = (ResumoPedido) obj;
		
		return Double.doubleToLongBits(desconto) == Double.doubleToLongBits(other.desconto)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal);
	}


	// toString
	@Override
	public String toString() {
		return "ResumoPedido [valorTotal=" + valorTotal + ", desconto=" + desconto + "]";
	}

}
