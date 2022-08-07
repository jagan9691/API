
package com.libglobal;

import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	RequestSpecification req;
	protected Response response;

	public void addHeader(String key, String value) {

		req = RestAssured.given().header(key, value);

	}

	public void addHeaders(Headers header) {
		req = RestAssured.given().headers(header);
	}

	public Response requestType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = req.get(endpoint);
			break;
		case "POST":
			response = req.post(endpoint);
			break;
		case "PUT":
			response = req.put(endpoint);
			break;
		case "DELETE":
			response = req.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public void addBody(Object json) {
		req = req.body(json);
	}

	public int getResponseCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getPrettyString(Response response) {
		String pretty = response.asPrettyString();
		return pretty;
	}

	public void basicAuth(String username, String password) {
		req = req.auth().preemptive().basic(username, password);
	}

	public int parse(String s) {
		int int1 = Integer.parseInt(s);
		return int1;
	}
	public String id(int i ) {
		String string = String.valueOf(i);
		return string;

	}
	
}
