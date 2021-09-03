package com.universitydataapp.junit.universityinfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;
import com.populationdataapp.model.UniversityClass;
import com.universitydataapp.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class CreateNewUniversity extends TestBase{
	
	static String country = "United States";
	static String stateProvince;
	static List<String> webPages;
	static String alphaTwoCode ="US";
	static String nameOfUniversity = "ISU";
	static List<String> domains;
	
	@WithTag("NegativeTestCase")
	@Title("This test is to check that no new record can be added")
	@Test
	public void  createNewUniversity() {
		ArrayList<String> webPages = new ArrayList<String>();
		webPages.add("www.ISU.com");
		ArrayList<String> domains = new ArrayList<String>();
		domains.add("ISU.edu");
		
		UniversityClass university = new UniversityClass();
		university.setCountry(country);
		university.setAlphaTwoCode(alphaTwoCode);
		university.setNameOfUniversity(nameOfUniversity);
		university.setStateProvince(stateProvince);
		university.setDomains(domains);
		university.setWebPages(webPages);

		RestAssured.given()
		.content(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(university)
		.post()
		.then()
		.log()
		.all()
		.statusCode(405);
	}
	

}
