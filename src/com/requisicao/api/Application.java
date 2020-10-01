package com.requisicao.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Application {

	public static void main(String[] args) throws IOException {
		Cep cp = new Cep();
		//Chamando a api viacep
		URL url = new URL("https://viacep.com.br/ws/"+cp.getCep()+"/json/");
		//abrindo a conexao
		URLConnection connection = url.openConnection();
		//aqui vem os dados 
		InputStream is = connection.getInputStream();
		//preparando a leitura
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		String cep = "";
		//juntar o retorno
		StringBuilder jsonCep = new StringBuilder();
		
		while((cep = br.readLine()) != null) {
			jsonCep.append(cep);
		}
		
		System.out.println(jsonCep.toString());
	}

}
