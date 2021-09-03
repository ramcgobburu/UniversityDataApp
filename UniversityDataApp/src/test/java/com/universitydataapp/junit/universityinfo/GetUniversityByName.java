package com.universitydataapp.junit.universityinfo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.universitydataapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class GetUniversityByName extends TestBase {
	
	@Title("Test that if University Name is given it will retrive all the university details")
	@Test
	public void getUniversityInfo() {
		
		Response response = RestAssured.given()
		 .param("name", "Marywood University")
		 .when()
	     .get("/search")
	     .then()
	     .log()
	     .all()
	     .statusCode(200)
	     .extract().response();		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String country = jsonPathEvaluator.get("country[0]");
		String alpha2Code = jsonPathEvaluator.get("alpha_two_code[0]");
		String univName = jsonPathEvaluator.get("name[0]");
		Assert.assertEquals(country,"United States");	
		Assert.assertEquals(alpha2Code, "US");
		Assert.assertEquals(univName, "Marywood University");
			
}

	@WithTag("NegativeTestCase")
	@Title("Test that if host is wrong the application gives an error")
	@Test
	public void getErrorForHost() {
		
		RestAssured.given()
		 .when()
	     .get("/xyz")
	     .then()
	     .log()
	     .all()
	     .statusCode(404);
	
			
}
	
}
