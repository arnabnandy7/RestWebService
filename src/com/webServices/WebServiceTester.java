package com.webServices;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

/**
 * Dependencies of imported packages : Jersey JAX-RS 2.1 RI bundle Repository
 * Link :
 * http://repo1.maven.org/maven2/org/glassfish/jersey/bundles/jaxrs-ri/2.28
 * /jaxrs-ri-2.28.zip
 * 
 * @author arnab
 *
 */

public class WebServiceTester {
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/RestWebService/rest/TestService/sample";

	private void init() {
		this.client = ClientBuilder.newClient();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebServiceTester tester = new WebServiceTester();
		// initialize the tester
		tester.init();
		// test get all users Web Service Method
		try {
			tester.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getText() throws Exception {
		GenericType<List<?>> list = new GenericType<List<?>>() {
		};

		String response = client.target(REST_SERVICE_URL)
				.request(MediaType.APPLICATION_JSON).get().toString();
		System.out.println(response);
		if (response.contains("status=200")) {
			/*
			 * List<HashMap<String, String>> output = (List<HashMap<String,
			 * String>>) client .target(REST_SERVICE_URL).path("/sample")
			 * .request(MediaType.APPLICATION_JSON).get(list);
			 * 
			 * System.out.println(output.get(0));//.get(1).get("8"));
			 */
			String strOutput = client.target(REST_SERVICE_URL)
					.request(MediaType.APPLICATION_JSON).get(list).toString();
			JsonParser parser = new JsonParser();
			JsonArray o = parser.parse(strOutput).getAsJsonArray();

			System.out.println(o.get(0).getAsJsonObject().get("1")
					.getAsString());
		} else {
			throw new Exception(response);
		}
	}

}
