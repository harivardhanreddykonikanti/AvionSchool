  package com.AvionSchool.lms.generic.fileutlity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader reader=new FileReader("./configAppData/dataforcrm.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject mapp=(JSONObject)obj;
		 String data = (String) mapp.get(key);
		
		return data;
	}
	
}
