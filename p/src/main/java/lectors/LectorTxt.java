package lectors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import lectors.interfaces.ILector;
import validators.ValidatorLectorTxt;

public class LectorTxt implements ILector{
	private String json;
	private String routeTxt;
	private ValidatorLectorTxt validatorLectorTxt;
	
	public LectorTxt(final String routeTxt) {
		this.json = "";
		this.routeTxt = routeTxt;
		this.validatorLectorTxt = new ValidatorLectorTxt();
		isAValidRoute();
	}
	
	public void isAValidRoute() {
		if (!this.validatorLectorTxt.isValidRoute(this.routeTxt)) {
			throw new IllegalArgumentException("This is not a valid route of actions.txt");
		}
	}
	
	public void readFile(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.routeTxt));
		    StringBuilder sb = new StringBuilder();
		    String line = reader.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append("\n");
		        line = reader.readLine();
		    }
		    this.json = sb.toString();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getListOfJson(String keyValue){
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(this.json);
			JSONArray leng = (JSONArray) jsonObject.get(keyValue);
			return leng;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getJson() {
		return json;
	}
}
