package com.universitydataapp.junit.universityinfo;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.universitydataapp.testbase.TestBase;

//import io.restassured.RestAssured;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FullUniversityList extends TestBase{
	
	
	@Title("This Test gives all the universities information")
	@Test
	public void getAllUniversitiesData() {
		RestAssured.given()
		.when().get("/search")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
	
	@Title("This Test gives all the US universities information and the country for the first record is United States")
	@Test
	public void getAllUSUniversitiesData() {
		
		Response response = RestAssured.given()
		 .param("country", "United States")
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
		Assert.assertEquals(country,"United States");
		Assert.assertEquals(alpha2Code, "US");
	}
	
		@Title("This Test gives all the India universities information and the country for the first record is India")
		@Test
		public void getAllIndianUniversitiesData() {
			
			Response response = RestAssured.given()
			 .param("country", "India")
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
			Assert.assertEquals(country,"India");	
			Assert.assertEquals(alpha2Code, "IN");
		
	}
		
		
	
	
	
	

}
