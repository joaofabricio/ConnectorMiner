package consulta;

import java.util.List;


public class QtdeLinksDiscussao extends Consulta {
	
	private String ini;
	private String fim;
	private String anterior = "";
	
	public QtdeLinksDiscussao(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}

	@Override
	public List<String> tratarRetorno(String bodyText, List<String> list, String key) {
		
		int amountLinks = bodyText.split("](http").length -1;
		if (anterior .equals(key)) {
			
			String qtAnterior = list.get(list.size()-1);
			list.remove(list.size()-1);
			amountLinks += Integer.parseInt(qtAnterior);
		}
		list.add(String.valueOf(amountLinks));
		return list;
	}
	
}