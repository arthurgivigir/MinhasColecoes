package com.agivigir.mycollections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.AsyncTask;

public class RetrieveFeedTask extends AsyncTask<String, Void, String> {

	 private Exception exception;
	 String URL = "http://sandbox.buscape.com/service/findProductList/564771466d477a4458664d3d/?keyword=9788580570915&format=json";
     String linha = "";
     Boolean Erro = true;

	    protected String doInBackground(String... urls) {
	        try {
	        	HttpClient client = new DefaultHttpClient();
                HttpGet requisicao = new HttpGet();
                //requisicao.setHeader("Content-Type","text/plain; charset=utf-8");
                requisicao.setURI(new URI(URL));
                HttpResponse resposta = client.execute(requisicao);
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent(), "UTF-8"));
                String json = reader.readLine();
                /*JSONTokener tokener = new JSONTokener(json);
                JSONArray finalResult = new JSONArray(tokener);*/
                JSONObject jsonObject = new JSONObject(json);
                JSONArray array = jsonObject.getJSONArray("product");
 
                
 
	        } catch (Exception e) {
	            this.exception = e;
	            return null;
	        }
			return linha;
	    }

	    protected void onPostExecute(String feed) {
	        // TODO: check this.exception 
	        // TODO: do something with the feed
	    }
	
	
}
