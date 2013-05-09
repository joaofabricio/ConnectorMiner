package conexao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import consulta.Consulta;


public class SQLUtil {
	
	private static String SEPARADOR_COLUNA = "|";
	private static String SEPARADOR_LINHA = "\n";
	
	

	public static void imprimeResultado(String sql) throws Exception {
		GerenciadorConexao gc = GerenciadorConexao.getInstance();
		
		ResultSet rs = gc.executeSQL(sql);
		
		while (rs.next()) {
			try {
				int i = 1;
				while (true) {
					System.out.print(SEPARADOR_COLUNA);
					System.out.print(rs.getString(i++));
				}
			} catch (Exception e){
				System.out.print(SEPARADOR_LINHA);
			}
		}
	}
	
	public static HashMap<String, List<String>> getMap(String sql, HashMap<String, List<String>> ini, Consulta consulta) 
			throws Exception {
		
		HashMap<String, List<String>> map = ini;
		int start = 0;
		if (map == null) {
			map = new HashMap<String, List<String>>();
		} else {
			start = map.get(map.keySet().iterator().next()).size();
		}
		
		GerenciadorConexao gc = GerenciadorConexao.getInstance();
		
		PriorityQueue<String> processed = new PriorityQueue<String>();
		
		ResultSet rs = gc.executeSQL(sql);
		
		while (rs.next()) {
			String key = rs.getString(1);
			List<String> list = map.get(key);
			processed.add(key);
			try {
				if (list == null) {
					list = new ArrayList<String>();
					int c = 0;
					for (c=0; c<start; c++) {
						list.add("0");
					}
				}
				
				int i = 2;
				while (true) {
					String result = rs.getString(i++);
					list = consulta.tratarRetorno(result, list, key);
				}
			} catch (Exception e){
				map.remove(key);
				map.put(key, list);
			}
		}
		
		for (String key : map.keySet()) {
			if (!processed.contains(key)) {
				List<String> list = map.get(key);
				list.add("0");
			}
		}
		
		return map;
	}

}
