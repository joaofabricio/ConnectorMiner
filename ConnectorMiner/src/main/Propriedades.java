package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {
	
	private static Propriedades instance = new Propriedades();
	private Properties props;

	private Propriedades() {
		props = new Properties();
		try {
			props.load(new FileInputStream("connectorminer.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Propriedades getInstance() {
		return instance;
	}
	
	public String getPropriedade(String nome) {
		return props.getProperty(nome);
	}

}
