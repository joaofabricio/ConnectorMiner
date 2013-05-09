package consulta;


public class QtdeCommitsPorArquivo extends Consulta {
	
	private String ini;
	private String fim;
	
	public QtdeCommitsPorArquivo(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}
}