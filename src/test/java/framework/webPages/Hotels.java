package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Hotels extends BasePage {


    //Elements
    //Scenario preRequisite
    private By destinationInput = By.xpath("//*[@id='qf-0q-destination']");
    private By checkIn =By.xpath("//*[@id='qf-0q-localised-check-in']");
    private By checkOut = By.xpath("//*[@id='qf-0q-localised-check-out']");
    private By clenderCloseButton = By.xpath("//button[contains(text(), 'close')]");
    private By wholeCalender = By.xpath("/html/body/div[6]/div[2]");
    private By roomsDropDown = By.xpath("//*[@id='qf-0q-compact-occupancy']");
    private By roomSelectionOneToNine =By.xpath("//*[@id='qf-0q-rooms']");
    private By adultDropDown = By.xpath("//*[@id='qf-0q-room-0-adults']");

    //Rooms text xpath for verification(isDilsplayed)
    private By roomOne = By.xpath("//span[contains(text(),'Room 1')]");
    private By roomTwo = By.xpath("//span[contains(text(),'Room 2')]");
    private By roomThree = By.xpath("//span[contains(text(),'Room 3')]");
    private By roomFour = By.xpath("//span[contains(text(),'Room 4')]");
    private By roomFive = By.xpath("//span[contains(text(),'Room 5')]");
    private By roomSix = By.xpath("//span[contains(text(),'Room 6')]");
    private By roomSeven = By.xpath("//span[contains(text(),'Room 7')]");
    private By roomEight = By.xpath("//span[contains(text(),'Room 8')]");





    //scenario 2
    private By selectAllFiveStar = By.xpath("//span[contains(text(),'5-star')]");

    //Methods


    public void selectingTodayDate(){
        webAction(destinationInput).sendKeys("New York,New York");
        webAction(checkIn).click();
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Date data = new Date();
        String currentTime = data.toString();
        System.out.println(currentTime);

        List<WebElement> days = SharedSD.getDriver().findElements(wholeCalender);
        for(WebElement day : days){
            day.getText().equals(currentTime);
            day.click();
            break;
        }

    }





    public void selectMoreOption() {
        selectFromDropdownIndex(roomsDropDown,2);

    }
    public void selectOneRooms(String roomNumber){ // you can put parameter
        selectFromDropdownText(roomSelectionOneToNine,"roomNumber");
        boolean room = isElementDisplayed(roomOne);
        Assert.assertTrue(room);
    }
    public void selectTwoRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,2);
    }
    public void selectThreeRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,2);
    }
    public void selectFourRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,3);
    }
    public void selectFiveRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,4);
    }
    public void selectSixRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,5);
    }
    public void selectSevenRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,6);
    }
    public void selectEightRooms(){
        selectFromDropdownIndex(roomSelectionOneToNine,7);
    }
    public void selectNineRooms(){

    }





}
