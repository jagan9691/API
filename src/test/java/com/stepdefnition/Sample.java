package com.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import com.endpoints.Endpoints;
import com.libglobal.Base;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;

import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Sample extends Base{
	@When("User add the payload for adding address")
	public void userAddThePayloadForAddingAddress() {
		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " +TC1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);
		AddAddress_Input_pojo add= new AddAddress_Input_pojo("jagan", "jackson", "454545615156", "lonewolf", 33, 3378, 101, "202020", "chennai", "home");
		addBody(add);
		Response requestType = requestType("POST", Endpoints.ADDADDDRESS);
		int responseCode = getResponseCode(requestType);
		System.out.println(responseCode);
		AddAddress_Output_pojo as = requestType.as(AddAddress_Output_pojo.class);
		String message = as.getMessage();
		System.out.println(message);
	}

}
