package conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	public static String getConteudoArquivo(String string) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(string));
			String conteudo = "";
			while (br.ready()) {
				conteudo += br.readLine() + "\n";
			}
			br.close();
			return conteudo;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
