package service;

import com.google.gson.Gson;
import entity.Endereco;
import jdk.jshell.execution.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnderecoService {
    static String baseUrl = "https://viacep.com.br/ws/";

    public static Endereco buscaEnderecoPorCep(String cep){
        String urlCompleta = baseUrl + cep + "/json";
        try{
            URL url = new URL(urlCompleta);
            HttpURLConnection conexao =  (HttpURLConnection) url.openConnection();

            if(conexao.getResponseCode() != 200){
                System.out.println("Houve um erro ao consultar a API.");
                return null;
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));

            String respostaString, jsonToString = "";
            while ((respostaString = resposta.readLine()) != null) {
                jsonToString += respostaString;
            }

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonToString, Endereco.class);

            return endereco;
        }catch (Exception e){
            System.out.println("Houve um erro ao consultar a API.");
            return null;
        }

    }


}
