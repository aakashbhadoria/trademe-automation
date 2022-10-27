package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.services.payload;
import org.junit.Assert;

import java.util.ArrayList;

public class ServiceStep {
    payload py = new payload();
    public static final String BASE_URL = "https://api.trademe.co.nz";
    public static Response response;
    public static String jsonString;
    ArrayList<String> charityList;

    @Given("^the user launches the charity API end point and gets the response$")
    public void the_user_launches_the_API_end_point_and_get_the_response() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/v1/Charities.json");
        jsonString = response.asString();
        charityList = JsonPath.from(jsonString).get("Description");
        System.out.println(charityList);
    }

    @Then("^the user verifies the response list contains the charity name in the list (.*)$")
    public void the_user_verifies_the_response_list_contains_the_charity_name_in_the_list_Sedan(String data) {
        boolean status = charityList.contains(data);
        if (status)
            System.out.println("Expected charity name is present in the list : " + data);
        else
            System.out.println("Expected charity name is not present in the list : " + data);
    }

    @Given("^the user launches the add listing API end point and gets the response$")
    public void newListing() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Authorization", "OAuth oauth_consumer_key=4E0D082355116884742E5F33B8A199F411, oauth_token=86EE20AFF655C34CB34873449A5F98020B, oauth_signature_method=PLAINTEXT, oauth_signature=160FCF77971DC92A38596288DB071A8CA5%265333F645901F003CD98A69589C45BBC158");
        request.body(py.createListingData);
        response = request.post("/v1/Selling.json");
        jsonString = response.asString();
        System.out.println(jsonString);
    }

    @Then("^the user verifies the new listing has been created successfully (.*)$")
    public void validateNewListingCreation(int stCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, stCode);
    }

}
