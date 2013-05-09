package consulta;


public class QtdeCaracteresPullrequest extends Consulta {
	
	private String ini;
	private String fim;
	
	public QtdeCaracteresPullrequest(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}
}