package br.com.projetofinal.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.projetofinal.model.CartaoDecredito;
import br.com.projetofinal.model.Compra;

public class Principal {

	public static void main(String[] args) {

		var leitura = new Scanner(System.in);

		System.out.println("Favor informar o limite do cartão:");
		double limite = leitura.nextDouble();

		var cartao = new CartaoDecredito(limite);

		int opcao = 1;
		while (opcao != 0) {
			System.out.println("Digite a descrição do produto");
			String descricao = leitura.next();

			System.out.println("Digite o valor do produto: ");
			double valor = leitura.nextDouble();

			var compra = new Compra(descricao, valor);

			boolean compraRealizada = cartao.lancaCompras(compra);

			if (compraRealizada) {
				System.out.println("Compra realizada com sucesso!");
				System.out.println("Caso deseja realizar uma nova compra digite 1 e para sair digite 0");
				opcao = leitura.nextInt();
			} else {
				System.out.println("Saldo insuficiente, o saldo atual é de: " + cartao.getLimite()
						+ "e o valor da compra é" + compra.getValor());
				opcao = 1;
			}
		}

		for (Compra c : cartao.getCompras()) {
			System.out.println(" Realizada a compra do produto: " + c.getDescricao() + " no valor de: R$" + c.getValor());
			

		}
		System.out.println("\n********* SYSTEM ABC *********");
		System.out.println("\nO saldo restante é de: " + cartao.getSaldo());
		
		//for (Compra cOrdenado : cartao.getCompras()) {
		//	System.out.println("Valor ordenado pro nome" + cOrdenado.getDescricao());
		//}
		
		Collections.sort(cartao.getCompras());
		System.out.println("******************");
		
		System.out.println("Ordenando alfabeticamente: "+cartao.getCompras());
		System.out.println("Ordenando por preço: ");
		
			}

}
