package json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ParseTest {
	public static void main(String[] args) {
		String param = "{\"name\":\"홍길동\"}";
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(param, Map.class);
		
		param = param.replace("\"", "");
		String[] params = param.split(":");
	
		
	}
}
