package br.com.icorrea.exemplos.ioc;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	static List<Produto> produtos;
	
	public static void main(String[] args) {
		
		Pedido.produtos = new ArrayList<>();

		Produto roupa = new Produto("Roupa de ginastica", 199, "Adidas");
		
		Pedido.produtos.add(roupa);
	}

}
