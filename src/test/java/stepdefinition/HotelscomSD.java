package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.Hotels;
import org.testng.Assert;

public class HotelscomSD {
    Hotels hotels = new Hotels();

    @Given("^I am on Hotels.com home page$")
    public void iAmOnHotelsCom(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Hotels");

    }
    @Then("^I click on(.+) (Room 1|Room 2|Room 3|Room 4|Room 5|Room 6|Room 7|Room 8|Room 9) selecting$")
    public void selectTheRoom(int number , String textField){
        switch (textField){
            case "Room 1":
             //   hotels.selectOneRooms();
            case "Room 2":
                hotels.selectTwoRooms();
            case "Room 3":
                hotels.selectThreeRooms();
            case "Room 4":
                hotels.selectFourRooms();
            case   "Room 5":
                hotels.selectFiveRooms();
            case "Room 6":
                hotels.selectSixRooms();
            case "Room 7":
                hotels.selectSevenRooms();
            case "Room 8":
                hotels.selectEightRooms();
            case "Room, 9":
                hotels.selectNineRooms();
        }
    }

    @Then("^I select<selcet room> from romm dropdown$")
    public void selectOne(){



    }
    @And("^I verify <number_of_room_dropdown> is selected$")
    public void dropDownSelected(){

    }


}
