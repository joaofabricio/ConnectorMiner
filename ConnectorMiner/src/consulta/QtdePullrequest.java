package consulta;


public class QtdePullrequest extends Consulta {
	
	private String ini;
	private String fim;
	
	public QtdePullrequest(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}
}