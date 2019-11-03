package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import org.testng.Assert;

/**
 * Created by AMIR
 */

public class HomeWorkSD {
    private HomePage homePage = new HomePage();

    @Given("^I am on home pagee$")
    public void iAmOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Invalid home paga");
    }
    @When("^I enter(.+) into first name on home screen$")
    public  void EnterFirstName(String FirstName){
        homePage.enterFirstName(FirstName);
    }
    @When ("^I entered (.+) into Last name on home paga$")
    public void EnterLastName (String LastName){
        homePage.enterLastName(LastName);
    }
    @When("^I enter (.+) into Email text Field$")
    public void enterEmailAddress(String email){
        homePage.enterEmail(email);
    }
    @When("^I click on password text filed$")
    public void clickOnPasswordTextField(){
        homePage.clickOnPasswordTextField(); //we have to add xpath in home poge object-- method is created
    }
    @When("^I click on red error$")
    public void clickOnRedError(){
        homePage.clickOnRedEror(); // also we need to find xpath
    }
    @Then("^I verify invalid signup error me$")
    public void verifyErrorMessage(){

    }


}
