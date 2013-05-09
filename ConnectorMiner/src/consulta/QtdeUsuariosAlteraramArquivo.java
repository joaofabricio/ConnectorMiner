package consulta;

public class QtdeUsuariosAlteraramArquivo extends Consulta {
	
	private String ini;
	private String fim;

	public QtdeUsuariosAlteraramArquivo(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
		
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}

}
