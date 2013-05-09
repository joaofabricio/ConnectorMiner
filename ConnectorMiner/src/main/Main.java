package main;

import java.util.HashMap;
import java.util.List;

import conexao.GerenciadorConexao;



public class Main {

	public static void main(String[] args) {
		try {
			HashMap<String, List<String>> m = Montador.montarSaida();
				
				
			for (String key : m.keySet()) {
				System.out.print(key+"|");
				for (String string : m.get(key)) {
					System.out.print(string + "|");
				}
				System.out.println();
			}
		} finally {
			GerenciadorConexao.encerrarConexao();
		}
			
			
	}
	
}
