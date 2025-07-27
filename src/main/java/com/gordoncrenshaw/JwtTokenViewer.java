package com.gordoncrenshaw;


import java.io.StringReader;
/*
 * Code taken from https://www.baeldung.com/java-jwt-token-decode
 */
import java.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

public class JwtTokenViewer {
    public static void main(String[] args) throws Exception {
        System.out.println("\nDisplays the contents of JWT Token");
        System.out.println("----------------------------------\n");

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMjdHNUwiLCJzdWIiOiIySDJQSEYiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJ3aHIgd3BybyB3bnV0IHdzbGUgd2VjZyB3c29jIHdhY3Qgd294eSB3dGVtIHd3ZWkgd2NmIHdzZXQgd2xvYyB3cmVzIiwiZXhwIjoxNzIyMTAyMDgyLCJpYXQiOjE3MjIwMTU2ODJ9.NVe2eZZxmaUcmWAsQoSyZuk-Abj60ZeIGcy1tsKAWyA";
        
        decodeJwt(token);
        System.out.println();

    }

    public static void decodeJwt(String token) throws Exception {

        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0])); // provides the algorithm
        String payload = new String(decoder.decode(chunks[1])); // provides the contents of the JWT token

        System.out.println("HEADER\n" + toPrettyFormat(header));
        System.out.println();
        System.out.println("PAYLOAD\n" + toPrettyFormat(payload));

    }

	public static String toPrettyFormat(String jsonString) throws JsonSyntaxException {

		String prettyJson;

		try {

			JsonReader jsonReader = 
				new JsonReader(new StringReader(jsonString));
			jsonReader.setLenient(true);
			JsonElement jsonElement = JsonParser.parseReader(jsonReader);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			
			// Enable pretty printing of JSON
			Gson gson = new GsonBuilder()
							.setPrettyPrinting()
							.setLenient()
							.create();
			prettyJson = gson.toJson(jsonObject);
	
		} finally {
			
		}
		return prettyJson;

    }
}
