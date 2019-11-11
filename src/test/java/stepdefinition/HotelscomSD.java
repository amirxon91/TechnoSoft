package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelPre;
import framework.webPages.Hotels;
import gherkin.lexer.Th;
import org.testng.Assert;

public class HotelscomSD {
    Hotels hotels = new Hotels();
    HotelPre hotelPre = new HotelPre();

    @Given("^I am on Hotels.com home page$")
    public void iAmOnHotelsCom(){
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.hotels.com/");
        //hotels.clickOnPupUp();
//you need to put a method, your method should be on  page opject and locator for  anything from homepage webpage
    }
    @Then("^I select room 1$")
    public void selectRoomOne() throws InterruptedException{
        hotels.selectRooms("1");
        Assert.assertTrue(hotels.roomOneVerification());
        Thread.sleep(1000);
    }
    @And("^I select room 2$")
    public void selectRoomTwo()throws InterruptedException{
        hotels.selectRooms("2");
        Assert.assertTrue(hotels.isRoomDisplayed("2"));
        Thread.sleep(1000);
    }
    @And("^I select room 3$")
    public void selectRoomThree() throws InterruptedException{
        hotels.selectRooms("3");
        Assert.assertTrue(hotels.isRoomDisplayed("3"));
        Thread.sleep(1000);
    }
    @And("^I select room 4$")
    public void selectRoomFour()throws InterruptedException{
        hotels.selectRooms("4");
        Assert.assertTrue(hotels.isRoomDisplayed("4"));
        Thread.sleep(1000);
    }
    @And("^I select room 5$")
    public void selectRoomFive()throws InterruptedException{
        hotels.selectRooms("5");
        Assert.assertTrue(hotels.isRoomDisplayed("5"));
        Thread.sleep(1000);
    }
    @And("^I select room 6$")
    public void selectRoomSix()throws InterruptedException{
        hotels.selectRooms("6");
        Assert.assertTrue(hotels.isRoomDisplayed("6"));
        Thread.sleep(1000);
    }
    @And("^I select room 7$")
    public void selectRoomSeven()throws InterruptedException{
        hotels.selectRooms("7");
        Assert.assertTrue(hotels.isRoomDisplayed("7"));
        Thread.sleep(1000);
    }
    @And("^I select room 8$")
    public void selectRoomEight()throws InterruptedException{
        hotels.selectRooms("8");
        Assert.assertTrue(hotels.isRoomDisplayed("8"));
        Thread.sleep(1000);
    }
    @And("^I select room 9$")
    public void selectRoomNine()throws InterruptedException{
        hotels.selectRooms("9+");
        Thread.sleep(1000);
        //Assert.assertFalse(hotels.isRoomDisplayedRoomNine("9"));
    }




    @Then("^I select(.+) from room DropDown$")
    public void selectTheRoom( String roomNumbers){
        hotels.clickOnPupUp();
        hotels.selectRoomDropDownMoreOption();
        switch (roomNumbers){
            case "1":
                hotels.selectRooms("1");
            case "2":
                hotels.selectRooms("2");
            case "3":
                hotels.selectRooms("3");
            case "4":
                hotels.selectRooms("4");
            case "5":
                hotels.selectRooms("5");
            case "6":
                hotels.selectRooms("6");
            case "7":
                hotels.selectRooms("7");
            case "8":
                hotels.selectRooms("8");
            case "9":
                hotels.selectRooms("9");
        }
    }
    @And("^I verify (.+) is displayed$")
    public void verifyRooms(int RoomDropDown){
        switch (RoomDropDown){
            case 1:
                Assert.assertTrue(hotels.isRoomDisplayed("1"));
            case 2:
                Assert.assertTrue(hotels.isRoomDisplayed("2"));
            case 3:
                Assert.assertTrue(hotels.isRoomDisplayed("3"));
            case 4:
                Assert.assertTrue(hotels.isRoomDisplayed("4"));
            case 5:
                Assert.assertTrue(hotels.isRoomDisplayed("5"));
            case 6:
               Assert.assertTrue(hotels.isRoomDisplayed("6"));
            case 7:
                Assert.assertTrue(hotels.isRoomDisplayed("7"));
            case 8:
                Assert.assertTrue(hotels.isRoomDisplayed("8"));
            case 0:
                Assert.assertFalse(hotels.isRoomDisplayed("9"));
        }

    }

@Given("^I am on default locations search star result screen$")
    public void searchingStar() throws InterruptedException{
        hotelPre.fillOutAutoSuggest("Manhattan, New York","New York, United States of America");
        hotelPre.preTestFunctions();
        hotelPre.clickOnSearchButton();

}
@When("^I select property class (.+)$")
public void getProperty(String hotelStars)throws InterruptedException{
        switch (hotelStars){
            case "5 stars":
                hotels.clickOnStarCheckBox("5");
                hotels.scrollDownWithLoop();
                hotels.collectingAllStartsAndTurnToString("5");
                break;
            case "4 stars":
                hotels.clickOnStarCheckBox("4");
                hotels.scrollDownWithLoop();
                hotels.collectingAllStartsAndTurnToString("4");
                break;
            case "3 stars":
                hotels.clickOnStarCheckBox("3");
                hotels.scrollDownWithLoop();
                hotels.collectingAllStartsAndTurnToString("3");
                break;
        }

}
@Then("^I verify system displays only (.+) hotels on search result$")
    public void selectStar(String hotelStar) throws InterruptedException{
        switch (hotelStar){
            case "5 stars":
                hotels.verifyStar("5");
                break;
            case "4 stars":
                hotels.verifyStar("4");
                break;
            case "3 stars":
                hotels.verifyStar("3");
                break;
        }



}
@Then("^I click (.+) select the(5-star|4star)$")
    public void starCollection(String starText) throws InterruptedException{
        switch (starText){
            case"5-star":
                hotels.clickOnStarCheckBox(starText);
                hotels.scrollDownWithLoop();
                hotels.collectingAllStartsAndTurnToString(starText);
                Thread.sleep(2000);
                break;
        }
}

    @Given("^I am on default locations search result screen$")
    public void searchingRadius() throws InterruptedException{
        hotelPre.fillOutAutoSuggest("JFK International", "John F. Kennedy International Airport (JFK)");
        hotelPre.preTestFunctions();
        hotelPre.clickOnSearchButton();
    }
@Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void tenMileRadius() throws InterruptedException{
        hotels.regularScrollDown(700);
        hotels.clickOnLandMarkSelectJFKAndTenMiles();
        hotels.SelectHotelAndRadius();
        Assert.assertTrue(hotels.isSelectedHotelsInRadiusOfTenMiles());
}
@Then("^I verify Hilton Hotel is within radius$")
    public void isHiltonInList(){
        hotels.seachHilton();
        Assert.assertTrue(hotels.isHotelHiltonInList());
}
@Given("^Verify today's deal price value$")
    public void upToBestDeal() throws InterruptedException{
    hotelPre.fillOutAutoSuggest("Manhattan", "New York, New York,");
    hotelPre.preTestFunctions();
    hotelPre.clickOnSearchButton();

}
@Then("^I verify today's deal is less than 200$")
        public void verifyUnder200(){
    Assert.assertTrue(hotels.isTodayBestDealUnder200());
}




}
