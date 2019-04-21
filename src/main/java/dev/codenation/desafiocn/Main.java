package dev.codenation.desafiocn;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	private static final String URI_GET = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=";
	private static final String URI_POST = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=";
	private static final String TOKEN = "ca673cf041ccebe726b1c0e4fafdb4487e72d4cd";

	public static void main(String[] args) throws Exception {
		
		//sendGet( );
		sendPost( );
	}

	
	public static void sendPost() throws Exception {
		
		 HTTPConnection.post(URI_POST, TOKEN, "answer.json");
		
	}
	
	
	/**
	 * conecta o endpoint e recupera o json, converte para java object, salva em arquivo, gera o valor decifrado e salva,
	 * gera o resumo criptografico e salva.
	 * 
	 * @throws Exception
	 */
	public static void sendGet() throws Exception {
		String body = HTTPConnection.get(URI_GET, TOKEN);

		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		Answer answer = gson.fromJson(body, Answer.class);
		saveFile(gson.toJson(answer));

		answer.setDecifrado(Caesar.decrypt(answer.getCifrado(), answer.getNumeroCasas()));
		saveFile(gson.toJson(answer));

		answer.setResumoCriptografico(SHA1.encryptSHA1Hex(answer.getDecifrado()));
		saveFile(gson.toJson(answer));

		System.err.println(answer.toString());
	}

	
	/**
	 * salva o arquivo
	 * 
	 * @param answerJson
	 * @throws Exception
	 */
	public static void saveFile(String answerJson) throws Exception {
		File answerFile = new File("answer.json");
		FileWriter answerFileWriter = new FileWriter(answerFile);
		PrintWriter printWriter = new PrintWriter(answerFileWriter);
		printWriter.print(answerJson);

		answerFileWriter.flush();
		answerFileWriter.close();

		printWriter.close();
		printWriter.flush();

	}

}
