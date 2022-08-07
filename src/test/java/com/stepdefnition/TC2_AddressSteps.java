package com.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.endpoints.Endpoints;
import com.libglobal.Base;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAdddress_Output_pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC2_AddressSteps extends Base {

	String ID;

	@When("User add headers for add address endpoint")
	public void userAddHeadersForAddAddressEndpoint() {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User add the payload{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} for adding address")
	public void userAddThePayloadForAddingAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		AddAddress_Input_pojo load = new AddAddress_Input_pojo(first_name, last_name, mobile, apartment,
				Integer.parseInt(state), Integer.parseInt(city), Integer.parseInt(country), zipcode, address,
				address_type);
		addBody(load);
	}

	@When("User send POST request for Addaddress Endpoint")
	public void userSendPOSTRequestForAddaddressEndpoint() {
		response = requestType("POST", Endpoints.ADDADDDRESS);
	}

	@Then("User verify the status code is {int} for adding address")
	public void userVerifyTheStatusCodeIsForAddingAddress(Integer int1) {
		int code = getResponseCode(response);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);
	}

	@Then("User verify the address response body message {string} and save the address id")
	public void userVerifyTheAddressResponseBodyMessageAndSaveTheAddressId(String string) {
		AddAddress_Output_pojo out = response.as(AddAddress_Output_pojo.class);
		String msg = out.getMessage();
		System.out.println(msg);
		Assert.assertEquals("Verifyadd address", "Address added successfully", msg);
		int address_id = out.getAddress_id();
		ID = String.valueOf(address_id);
		System.out.println(ID);

	}

	@When("User add headers for update address endpoint")
	public void userAddHeadersForUpdateAddressEndpoint() {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User add the payload {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} for updating the address with address_Id")
	public void userAddThePayloadForUpdatingTheAddressWithAddress_Id(String string, String string2, String string3,
			String string4, String string5, String string6, String string7, String string8, String string9,
			String string10) {

		UpdateAddress_Input_Pojo input = new UpdateAddress_Input_Pojo("17157", string, string2, string3, string4,
				Integer.parseInt(string5), Integer.parseInt(string6), Integer.parseInt(string7), string8, string9,
				string10);
		System.out.println(ID);
		addBody(input);

	}

	@When("user sent PUT request for Update endpoints")
	public void userSentPUTRequestForUpdateEndpoints() {
		response = requestType("PUT", Endpoints.UPDATEADDRESS);
	}

	@Then("User verify the status code is {int} for update address")
	public void userVerifyTheStatusCodeIsForUpdateAddress(Integer int1) {
		int code = getResponseCode(response);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);
	}

	@Then("User verify the update address response body message {string}")
	public void userVerifyTheUpdateAddressResponseBodyMessage(String string) {
		UpdateAddress_Output_Pojo out = response.as(UpdateAddress_Output_Pojo.class);
		String message = out.getMessage();
		Assert.assertEquals("Verify update address", "Address updated successfully", message);
		System.out.println(message);
	}

	@When("User add headers foe delete address")
	public void userAddHeadersFoeDeleteAddress() {

		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h2 = new Header("Content-Type", "application/json");
		l.add(h);
		l.add(h1);
		l.add(h2);
		Headers h3 = new Headers(l);
		addHeaders(h3);

	}

	@When("User add the payload for deleting the address with address_Id")
	public void userAddThePayloadForDeletingTheAddressWithAddress_Id() {

		DeleteAddress_Input_Pojo del = new DeleteAddress_Input_Pojo("17175");
		System.out.println(ID);
		addBody(del);
	}

	@When("user sent DELETE request for delete endpoints")
	public void userSentDELETERequestForDeleteEndpoints() {
		response = requestType("DELETE", Endpoints.DELETEADDRESS);
	}

	@Then("User verify the status code is {int} for deleting address")
	public void userVerifyTheStatusCodeIsForDeletingAddress(Integer int1) {
		int code = getResponseCode(response);
		System.out.println(code);
		Assert.assertEquals("verify", 200, code);

	}

	@Then("User verify the delete address response body message {string}")
	public void userVerifyTheDeleteAddressResponseBodyMessage(String string) {
		DeleteAdddress_Output_pojo output_pojo = response.as(DeleteAdddress_Output_pojo.class);
		String message = output_pojo.getMessage();
		Assert.assertEquals("Verify delete address", "Address deleted successfully", message);
		System.out.println(message);
	}

	@When("User add headers for get address")
	public void userAddHeadersForGetAddress() {
		List<Header> l = new ArrayList<>();
		Header h = new Header("accept", "application/json");
		Header h1 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		l.add(h);
		l.add(h1);
		Headers h3 = new Headers(l);
		addHeaders(h3);
	}

	@When("User send GET request for Getaddress Endpoint")
	public void userSendGETRequestForGetaddressEndpoint() {
		response = requestType("GET", Endpoints.GETADDRESS);
	}

	@Then("User verify the status code is {int} for get address")
	public void userVerifyTheStatusCodeIsForGetAddress(Integer int1) {
		int code = getResponseCode(response);
		Assert.assertEquals("verify", 200, code);
		System.out.println(code);

	}

	@Then("User verify the address response body message {string}")
	public void userVerifyTheAddressResponseBodyMessage(String string) {
		GetAddress_Output_Pojo out = response.as(GetAddress_Output_Pojo.class);
		String message = out.getMessage();
		Assert.assertEquals("Verify get address", "OK", message);
		System.out.println(message);

	}
}
