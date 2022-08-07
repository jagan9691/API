package com.stepdefnition;

import org.junit.Assert;

import com.endpoints.Endpoints;
import com.libglobal.Base;
import com.pojo.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends Base {
	public static String logtoken;
	Response response2;

	@Given("User add Header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	@Given("User add basic Authentication {string},{string}for login")
	public void userAddBasicAuthenticationForLogin(String username, String password) {

		basicAuth(username, password);
	}

	@When("User send POST request for Loginendpoint")
	public void userSendPOSTRequestForLoginendpoint() {
	   response2 = requestType("POST", Endpoints.POSTMANBASICAUTHLOGIN);

	}
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(Integer int1) {
		int code = getResponseCode(response2);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);
	}

	@Then("User verify the login response body firstname is {string}and save the login token.")
	public void userVerifyTheLoginResponseBodyFirstnameIsAndSaveTheLoginToken(String string) {
		Login_Output_Pojo out = response2.as(Login_Output_Pojo.class);
		String firstname = out.getData().getFirst_name();
		Assert.assertEquals("verify", "Jagan", firstname);
		System.out.println(firstname);
		logtoken = out.getData().getLogtoken();
	}

}
