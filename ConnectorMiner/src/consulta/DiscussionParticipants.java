package consulta;


public class DiscussionParticipants extends Consulta {
	
	private String ini;
	private String fim;
	
	public DiscussionParticipants(String ini, String fim) {
		this.ini = ini;
		this.fim = fim;
	}

	@Override
	protected String[] getParametros() {
		return new String[]{ini, fim};
	}
}