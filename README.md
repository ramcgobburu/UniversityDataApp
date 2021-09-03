# UniversityDataApp
This is a demo for Rest Assured Automation framework program for the UniversityData open api. 

This is a simple open-api retrieved from https://apipheny.io/free-api/. This app gives the list of all universities across the world. The details it includes is University name, Country , Domains, web pages and two charcater country code. <br />

I used serenity BDD Rest Assured framework to automate and test this application. I referred the serenity documentation website for pom dependencies.https://serenity-bdd.info/documentation/ <br />

This is a simple api which has GET operations. Any POST operations are not allowed and i tested that using a negative test case. <br />

The query parameters it would take is country name, university name, webpages, domains and two character country code. <br />

**Pros and Cons of this framework:** <br />

**Pros:** <br />
This framework gives a very beautiful reports of the test execution. The report comprises of story details, feature details and all the steps involved. <br />
Easy to undertand: The BDD framework would help in understanding the flow of the test, as it will be coded in given , when and then , any user can understand what and why the result is yielded. <br />
Serenity BDD provides us many annotations such as @Title, @Runwith, @WithTags to differentiate the tests we run and cluster them. <br />
Data driven testing is also possible by using annotation @RunWith(SerenityParametrizedRunner.class) which takes the input from a csv file. ( which is not used here in the demo) <br />

**Cons:**
We will not have the request details ( the input JSON) to see what request we have passed to get any particular result. <br />
However we can overcome this by using SerenityRest framework on this to achieve that. <br />

**To run the test suite**
We can run the test suite with junit and also with maven builder. <br />
To run , we need to set the run configuration with **Goal : clean verify serenity:aggregate. **   <br />

**Sources:** <br />
https://apipheny.io/free-api/ <br />
https://serenity-bdd.github.io/theserenitybook/latest/index.html  <br />
http://jsonviewer.stack.hu/ <br />



