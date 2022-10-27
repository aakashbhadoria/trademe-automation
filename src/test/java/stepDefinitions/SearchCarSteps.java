package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.browserActions.BaseWebActions;
import org.example.pages.SearchCar;

public class SearchCarSteps {
    SearchCar sc = new SearchCar();

    @Given("^the user opens the browser and launches the web application$")
    public void the_user_opens_the_browser_and_launches_the_web_application() {
        sc.launchApplication();
    }

    @Then("^the user enters the filter values as Make - (.*) Model - (.*) BodyType - (.*)$")
    public void the_user_enters_the_keywords_for_searching_used_cars(String make, String Model, String bodyType) throws InterruptedException {
        sc.navigateToMotors();
        sc.clickOnUsed();
        sc.selectMake(make);
        sc.selectModel(Model);
        sc.selectBodyType(bodyType);
        sc.clickOnSearchButton();
    }
    @Then("^the user enters the filter values as Make - (.*) Search Text - (.*) BodyType - (.*)$")
    public void SearchUsedCar(String make, String searchText, String bodyType) throws InterruptedException {
        sc.navigateToMotors();
        sc.clickOnUsed();
        sc.selectMake(make);
        sc.inputSearchText(searchText);
        sc.selectBodyType(bodyType);
        sc.clickOnSearchButton();
    }

    @Then("^the user verifies the count of search results$")
    public void the_user_verifies_the_count_of_search_results() throws InterruptedException {
        Thread.sleep(7000);
        sc.verifySearchCount();
        BaseWebActions.closeBrowser();
    }

    @Then("^the user navigates to the car details page$")
    public void navigateToDetails() throws InterruptedException {
        Thread.sleep(4000);
        sc.clickOnSearchResult();
    }

    @Then("^the user verifies the displayed car details$")
    public void getCarDetails() throws InterruptedException {
        Thread.sleep(4000);
        sc.verifyCarDetailsDisplayed();
    }

    @Then("^the user validate the car details (.*) (.*) (.*)$")
    public void getCarDetails(String Kilometers, String NumberPlate, String BodyStyle) throws InterruptedException {
        Thread.sleep(4000);
        sc.validateResult(Kilometers, NumberPlate, BodyStyle);
        BaseWebActions.closeBrowser();
    }
}