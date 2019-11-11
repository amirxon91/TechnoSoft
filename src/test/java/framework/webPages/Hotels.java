package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Hotels extends BasePage {
    //Elements
    //Discount offer pup out
    public static By discountOffer = By.xpath("//*[@id=\"managed-overlay\"]/button");
    //for constructor
    private By inputForDestination = By.xpath("//*[@id='qf-0q-destination']");

    private By allCalender = By.xpath("//*[@class='widget-datepicker-bd']/descendant::a");
    //Rooms
    private By RoomsNumber = By.xpath("//span[contains(text(),'Room')]");
    public static By roomOne = By.xpath("//span[contains(text(),'Room 1')]");
    public static By roomTwo = By.xpath("//span[contains(text(),'Room 2')]");
    public static By roomThree = By.xpath("//span[contains(text(),'Room 3')]");
    public static By roomFour = By.xpath("//span[contains(text(),'Room 4')]");
    public static By roomFive = By.xpath("//span[contains(text(),'Room 5')]");
    public static By roomSix = By.xpath("//span[contains(text(),'Room 6')]");
    public static By roomSeven = By.xpath("//span[contains(text(),'Room 7')]");
    public static By roomEight = By.xpath("//span[contains(text(),'Room 8')]");
    private By adultsForVerification = By.xpath("//div[@id=\"hds-marquee\"]/descendant::label[contains(text(),'Adults')]");
    //Elements for 5 sta page
    private By fiveStarCheckBox = By.id("f-label-star-rating-5");
    private By fourStarCheckBox = By.id("f-label-star-rating-4");
    private By threeStarCheckBox = By.id("f-label-star-rating-3");
    private By all5StarHotelsInNYC = By.xpath("//span[contains(text(),'5-star')]");
    private By roomsDropDownBox = By.xpath("//*[@id = 'qf-0q-compact-occupancy']");
    private By roomsNumbersAfterMoreOption = By.id("qf-0q-rooms");
    private By adultDropDownBox = By.id("qf-0q-room-0-adults");

    //scenario 3
    private By lendMark = By.xpath("//h3[contains(text(),'Landmarks')]");
    private By JFK = By.id("f-label-lid-1662393");
    private By MilesDropDown = By.xpath("//select[@id='f-distance']");
    private By tenMilesRangeHotels = By.xpath("//li[contains(text(),'John F. Kennedy')]");
    private By tenMilsRangeNameOfHotels = By.xpath("//h3[@class = 'p-name']/descendant::a[text()]");
    //Scenario 4
    private By TodaysBestDealCustom =By.xpath("//div[@id='listings']/descendant::ins[1]");
    private By todaysBestDealHeader = By.xpath("//div[@id=\"listings\"]/descendant::h2");


    //constructor


    //Lists
    ArrayList<String> fiveStarCollection = new ArrayList<String>();
    ArrayList<String> listOfHotels = new ArrayList<String>();
    List<Double> radiusInt = new ArrayList<Double>();
    //Data
    boolean isRoomDisplayed = false;
    boolean isRadiusLessThanTenMile = false;
    boolean isHiltonOnList = false;
    boolean isBestDealIsUnder200 = false;
    boolean isStarSelected = false;
    int bestDealPrice;
    int price = 200;



    //Methods
    public void clickOnPupUp() {
        clickOn(discountOffer);
    }

    public void selectRoomDropDownMoreOption() {
        selectFromDropdownIndex(roomsDropDownBox, 2);
    }

    public void selectRooms(String roomNumber) {
        selectFromDropdownText(roomsNumbersAfterMoreOption, roomNumber);
    }
//Room 1
    public boolean roomOneVerification() {
        return isElementDisplayed(adultsForVerification);
    }
//Room 2-8
    public boolean isRoomDisplayed(String room){
        RoomsNumber = By.xpath("//span[contains(text(),'Room "+room+":')]");
        if(isElementDisplayed(RoomsNumber)){
            isRoomDisplayed = true;
        }else if(!isElementDisplayed(RoomsNumber)){
            isRoomDisplayed=false;
        }
        return isRoomDisplayed;
    }
//Room 9
    public boolean isRoomDisplayedRoomNine(String nine){
        RoomsNumber = By.xpath("//span[contains(text(),'Room "+nine+":')]");
        if(!isElementDisplayed(RoomsNumber)){
            isRoomDisplayed = false;
        }
        return isRoomDisplayed;
    }


    // Scenario 2
    public void clickOnStarCheckBox(String selectYourStar) throws InterruptedException {
By star = By.xpath("//span[contains(text(),'"+selectYourStar+"-star')]");
        scrollDown(0, 600);
        clickOn(star);
    }

    public void scrollDownWithLoop() throws InterruptedException {


        for (int second = 0; ; second++) {
            if (second >= 20) { //after sec if it cant scroll down it will break
                break;
            }
            scrollDown(0, 700);
            Thread.sleep(2500);
        }
    }

    public void regularScrollDown(int amount) {
        scrollDown(0, amount);
    }

    public void collectingAllStartsAndTurnToString(String star) {
        By allStar = By.xpath("//span[contains(text(),'"+star+"-star')]");
        List<WebElement> fiveStars = SharedSD.getDriver().findElements(allStar);
        for (WebElement fiveStar : fiveStars) {
            String fiveStarString = fiveStar.getText().toString();
            fiveStarCollection.add(fiveStarString);
        }
        System.out.println(fiveStarCollection);

        System.out.println(fiveStarCollection.size());
    }
    public boolean verifyStar(String star){
        By stars = By.xpath("//span[contains(text(),'"+star+"-star')]");
        if(isElementSelected(stars)){
            isStarSelected=true;
        }
        return isStarSelected;

    }
    // Scenario 3
    public void clickOnLandMarkSelectJFKAndTenMiles() throws InterruptedException {

        clickOn(lendMark);

        clickOn(JFK);

        selectFromDropdownText(MilesDropDown, "10 miles");
        for (int second = 0; ; second++) {
            if (second >= 25) { //after sec if it cant scroll down it will break
                break;
            }
            scrollDown(0, 700);
            Thread.sleep(2500);
        }

    }

    public void SelectHotelAndRadius() {

        List<WebElement> hotels = SharedSD.getDriver().findElements(tenMilesRangeHotels);
        for (WebElement hotel : hotels) {
            String stringHotel = hotel.getText();
            stringHotel = stringHotel.replaceAll("\\D+","");
            double convertDouble = Double.parseDouble(stringHotel);
            convertDouble /= 10;
           radiusInt.add(convertDouble);


        }
        System.out.print("Radius Int "+ radiusInt);

    }
    public boolean isSelectedHotelsInRadiusOfTenMiles(){
        if(!radiusInt.contains(10.0)){
            isRadiusLessThanTenMile=true;

        }
        return isRadiusLessThanTenMile;
    }

public void seachHilton(){
        List<WebElement> listOfhotels = SharedSD.getDriver().findElements(tenMilsRangeNameOfHotels);
         for(WebElement hilton:listOfhotels){
             String strHilton = hilton.getText();
             listOfHotels.add(strHilton);

         }
    System.out.print("test for hilton"+listOfHotels);
}

    public boolean isHotelHiltonInList() {
        for(String hotel :listOfHotels) {
            if (hotel.contains("Hilton")) {
                isHiltonOnList = true;
            }

        }
        return isHiltonOnList;
    }
    // Scenario 4
    public boolean isTodayBestDealUnder200 () {

        try{
            bestDealPrice = webElementToInt(TodaysBestDealCustom,"$","");
            if(bestDealPrice <= price){
                isBestDealIsUnder200 = true;
            }else{
                isBestDealIsUnder200 = false;
            }

        }catch(NoSuchElementException e){
            e.printStackTrace();

        }
        return isBestDealIsUnder200;


    }


}



















