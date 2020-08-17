package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BellyDefinitions {
    @Given("I have {int} cukes in my belly")
    public void i_have_cukes_in_my_belly(Integer int1) {
        System.out.println("I have "+ int1+" cukes in my belly");

    }

    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
    System.out.println("I wait "+int1+" hour");
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        System.out.println("my belly should growl");
    }


}
