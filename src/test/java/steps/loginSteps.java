package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by shashavali.j on 3/13/2017.
 */
public class loginSteps {

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws Throwable {
        System.out.println("Given");
    }

    @When("^I enter username and password$")
    public void iEnterUsernameAndPassword() throws Throwable {
        System.out.println("When");
    }

    @Then("^I should see the username$")
    public void iShouldSeeTheUsername() throws Throwable {
        System.out.println("Then");
    }
}
