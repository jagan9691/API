package com.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import com.libglobal.Base;

import io.cucumber.java.en.Given;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CommanSteps extends Base{
	@Given("User add Headers")
	public void userAddHeaders() {
		
		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " +TC1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);
	}
	

}
