package com.universitydataapp.testbase;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://universities.hipolabs.com";
		
	}

}
