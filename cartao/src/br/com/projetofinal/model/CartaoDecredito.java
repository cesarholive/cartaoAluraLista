package br.com.projetofinal.model;

import java.util.ArrayList;
import java.util.List;

public class CartaoDecredito {
	private double limite;
	private double saldo;
	private List<Compra> compras;
	
	public CartaoDecredito (double limite) {
		this.limite = limite;
		this.saldo = limite;
		this.compras = new ArrayList<>();
	}
	
	public boolean lancaCompras(Compra compra) {
		if(this.saldo > compra.getValor()) {
			this.saldo -= compra.getValor();
			this.compras.add(compra);
			return true;
		} 
		return false;
	}

	public double getLimite() {
		return limite;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Compra> getCompras() {
		return compras;
	}
	
}
