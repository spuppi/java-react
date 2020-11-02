package com.spuppi.javareact;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class JavaReactApplicationTests {



	@Test
	void testListaJson() {

		try {

			String listaJson = "./lista.json";
			ObjectMapper mapper = new ObjectMapper();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(listaJson));
			
			//Map<Long, Object> jsonMap = mapper.readValue();
			
			List<Object> results = (List<Object>) mapper.readValue(obj.toString(), Map.class);

			System.out.println(results);
			
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

}
