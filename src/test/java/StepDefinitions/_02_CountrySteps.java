package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne"); // Setup Click
        ln.findAndClick("parameters"); // Parameters Click
        ln.findAndClick("countries"); // Countries Click
    }

    @When("Create a country")
    public void createACountry() {

        String randomGenName= RandomStringUtils.randomAlphabetic(8);
        String randomGenCode= RandomStringUtils.randomAlphanumeric(4);
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", randomGenName);
        dc.findAndSend("codeInput", randomGenCode);
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        String randomGenName2= RandomStringUtils.randomAlphabetic(8);
        String randomGenCode2= RandomStringUtils.randomAlphanumeric(4);
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", randomGenName2);
        dc.findAndSend("codeInput", randomGenCode2);
        dc.findAndClick("saveButton");
    }
}
