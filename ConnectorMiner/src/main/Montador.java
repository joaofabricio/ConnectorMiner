package main;

import java.util.HashMap;
import java.util.List;

import consulta.Consulta;
import consulta.DiscussionParticipants;
import consulta.QtdeCaracteresPullrequest;
import consulta.QtdeCommitsPorArquivo;
import consulta.QtdeLinksDiscussao;
import consulta.QtdePullrequest;
import consulta.QtdeUsuariosAlteraramArquivo;

public class Montador {
	
	private static final String INI = "2010-01-01";
	private static final String FIM = "2013-12-31";
	
	private static Consulta[] consultas = new Consulta[] {
															new QtdeUsuariosAlteraramArquivo(INI, FIM),
															new DiscussionParticipants(INI, FIM),
															new QtdeCaracteresPullrequest(INI, FIM),
															new QtdeCommitsPorArquivo(INI, FIM),
															new QtdeLinksDiscussao(INI, FIM),
															new QtdePullrequest(INI, FIM),
										  };

	public static HashMap<String, List<String>> montarSaida() {
		try {
			HashMap<String, List<String>> mapa = null;
			for (Consulta consulta : consultas) {
				mapa = consulta.getMap(mapa);
			}
			return mapa;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
