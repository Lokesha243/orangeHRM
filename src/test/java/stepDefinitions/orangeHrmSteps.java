package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.orangeHRMPageObjects;

public class orangeHrmSteps {
    orangeHRMPageObjects hrmPageObjects = new orangeHRMPageObjects();

    @Given("^user launches application$")
    public void user_launches_application() {
        hrmPageObjects.driverSetup();
    }

    @When("^user enters the credentials and clicks on login$")
    public void user_enters_the_credentials_and_clicks_on_login() throws Exception {
        hrmPageObjects.enterCredentials();
    }

    @Then("^user validates title page$")
    public void user_validates_title_page() {
        hrmPageObjects.validateTitlePage();
    }

    @Then("^user Navigates to MyInfo$")
    public void user_navigates_to_my_info() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        hrmPageObjects.MyInfo();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("^user Enters Employee Details$")
    public void user_enters_employee_details() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        hrmPageObjects.EmployeeDetails();
//        throw new io.cucumber.java.PendingException();
    }

    @Then("user Saves the Details")
    public void user_saves_the_details() {
        // Write code here that turns the phrase above into concrete actions
        hrmPageObjects.saveDetails();
        //  throw new io.cucumber.java.PendingException();
    }

    @And("^user closed the application$")
    public void user_closed_the_application() {
        hrmPageObjects.closeApplication();
    }

}
