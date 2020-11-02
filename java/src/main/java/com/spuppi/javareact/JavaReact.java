package com.spuppi.javareact;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JavaReact {

	public static void main(String[] args) {
		try {

			String listaJson = "./lista.json";
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(listaJson));
			JSONArray jsonArray = (JSONArray) obj;
			
			System.out.println(imparesList(jsonArray));	
			
			System.out.println(wordsCounter("Atirei o pau no gato, mas o gato não morreu."));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<JSONObject> imparesList(JSONArray jsonArray){
		
		List<JSONObject> imparesList = new ArrayList<JSONObject>();
		
		for(Object disciplina : jsonArray) {
			JSONObject jsonObject = (JSONObject) disciplina;
			if((Integer.parseInt(String.valueOf(jsonObject.get("startMinute")))) % 2 != 0){
				imparesList.add(jsonObject);
			}
		}
		
		return imparesList;
	}
	
	public static int wordsCounter(String text) {
		return new StringTokenizer(text).countTokens();
	}
	
	
	
}
