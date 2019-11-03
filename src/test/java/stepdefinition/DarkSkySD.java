package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSky;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class DarkSkySD{

     DarkSky darkSky = new DarkSky();

    //Test-1

    @Given("^I am on home Page of DarkSky$")
    public void iAmOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - Broadway, New York, NY");
    }
    @When("^I click on Dark Sky API$")
        public void clickOnDarkSkyAPI(){
        darkSky.clickOnDarkSkyAPI();
    }
    @When("^I click on Sing Up$")
    public void clickOnSignUp(){
        darkSky.clickOnSignUp();
    }
    @When("^I click on Register$")
    public void clickOnRegister(){
        darkSky.clickOnRegister();
    }
    @Then("^I verify that the error is displayed$")
    public void verifyErrorMessage(){
        Assert.assertTrue(darkSky.verifyErrorMessage());
    }



    //Test-2

    @Then("^I verify current temp is not greater or less then temps$")
    public void scenarioTwo(){
        Assert.assertTrue(darkSky.verifyIsCurrentTempIsInBetweenTimeLine());
    }


    // Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline



    //Go scroll down, click on today, check lowest and highest temp

    @When("^I scroll down to Daily Temperatures$")
    public void scrollDown() throws InterruptedException{
        darkSky.scrollDown();
        Thread.sleep(2000);


    }
    @And("^I click today's temperature$")
    public void clickOn(){
        darkSky.clickOnToday();
    }
    @And("^I check is lowest is equal to lowest$")
    public void lowestToLowest(){
        darkSky.isLowestEqualToLowers();
    }

    @And("^I check is highest is equal to highest$")
        public void highestToHighest () {
            darkSky.isHighestEqualToHighest();
        }
    @Then("^Verify Lowest Equal To Lowest$")
    public void verifyErrorOne(){
        Assert.assertTrue(darkSky.isLowestEqualToLowers());
    }
    @And("^Verify highest equal to highest$")
    public void verifyErrorTwo(){
        Assert.assertTrue(darkSky.verifyTwoArrayEqual());
      //  Assert.assertTrue(darkSky.isHighestEqualToHighest());

    }

    //test-4


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void Verify(){
       // Assert.assertTrue(darkSky.verifyTwoArrayEqual());
        Assert.assertTrue(darkSky.veryfyEqialityOfTwoArrays());
    }



}
