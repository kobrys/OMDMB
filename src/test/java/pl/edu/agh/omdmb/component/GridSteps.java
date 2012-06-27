package pl.edu.agh.omdmb.component;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GridSteps {

    @Given("the text 0")
    public void given() {
        System.out.println("given");
    }

    @When("the text 1")
    public void when() {
        System.out.println("when");
    }

    @Then("the text 2")
    public void then() {
        System.out.println("then");
    }

}