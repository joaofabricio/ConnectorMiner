package consulta;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import conexao.FileUtils;
import conexao.SQLUtil;


public abstract class Consulta {
	
	protected static final String CARACTER_PARAM = "\\\\#";
	
	public String getSQL() {
		return FileUtils.getConteudoArquivo("consultas"+File.separator+this.getClass().getSimpleName());
	}
	
	protected abstract String[] getParametros();
	
	protected String tratarParametros() {
		String sql = getSQL();
		for (String param : getParametros()) {
			sql = sql.replaceFirst("#", param);
		}
		
		return sql;
	}
	
	public void executarConsulta() throws Exception {
		SQLUtil.imprimeResultado(tratarParametros());
	}
	
	public HashMap<String, List<String>> getMap(HashMap<String, List<String>> ini) throws Exception {
		return SQLUtil.getMap(tratarParametros(), ini, this);
	}

	public List<String> tratarRetorno(String result, List<String> list, String key) {
		list.add(result);
		return list;
	}
	
}
