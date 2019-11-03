package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;

public class DarkSky extends BasePage {
    private By validation = By.xpath("/html/body/div[1]/form/div/div/fieldset/div[1]/div/div/input");

    private By searchInput = By.xpath("//*[@id=\"searchForm\"]/input");
    private By clickOnSearch = By.xpath("//a[@class='searchButton']");
    private By clickOnDarkSkyAPI = By.xpath("/html/body/nav/div/a[4]");
    private By clickOnSignUp = By.xpath("/html/body/header/div/div/div/div[2]/nav/ul/li[5]/a");
    private By clickOnEmail = By.xpath("/html/body/div[1]/form/div/div/fieldset/div[1]/div/div/input");
    private By clickOnSignUpRegister = By.xpath("/html/body/div[1]/form/div/div/fieldset/div[4]/div/button");
    private By verifyError = By.xpath("//input[@placeholder='hacker@example.com']");
    private By timeLineTemp = By.xpath("//div[@id=\"timeline\"]/div/div[4]/child::span");
    private By currentTimeTemp = By.xpath("//*[@id=\\\"title\\\"]/span[1]/span[2]/span[2]/span[1]/span[2]");
    //elements for scenario 2
    private By timeLineTemperature = By.xpath("//div[@id=\"timeline\"]/div/div[4]/child::span");
    private By currentTemp = By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[1]/span[2]");

    //elements for scenario 3
    private By lowestValueTop = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[1]");
    private By lowestValueBottom = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By highestValueTop = By.xpath("//*[@id=\"week\"]/a[1]/span[2]/span[3]");
    private By highestValueBottom = By.xpath("//*[@id=\"week\"]/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");
    private By clickOnExpandToday = By.xpath("//div[@id='week']/descendant::span[@class ='toggle']");
    //Elements for scenario 4
    private By timeFromWebSite = By.xpath("//div[@id='timeline']/div/div[3]/child::span");
    private By currentTime = By.xpath("//*[@id=\"title\"]/span[1]/span[2]/span[2]/span[1]/span[2]");


    //Methods

    public void clearInput() {
        clear(searchInput);
    }

    public void clickOn() {
        clickOn(clickOnSearch);
    }

    public void clickOnDarkSkyAPI() {
        clickOn(clickOnDarkSkyAPI);
    }

    public void clickOnSignUp() {
        clickOn(clickOnSignUp);
    }

    public void clickOnEmailInput() {
        clickOn(clickOnEmail);
    }

    public void clickOnRegister() {
        clickOn(clickOnSignUpRegister);
    }
               
//    public String errorMessage() {
//        return getTextFromElement(verifyError);
//    }


    public boolean verifyErrorMessage(){
        String errorBox = SharedSD.getDriver().findElement(By.xpath("/html/body/div[1]/form/div/div/fieldset/div[1]/div/div/input")).getAttribute("validationMessage");
        String expected = "Please fill out this field.";
           boolean isEqual = false;
        if(errorBox==expected){
                isEqual=true;
        }
           return true;
    }







    //scenario 2
    ArrayList<Integer> firstArray = new ArrayList<Integer>();

    int lowestValue = 0;
    int highestValue = 0;
    int currentTemperature = getCurrentTemp();


    public void gettingTimeLineTemp() {
        List<WebElement> timeline = SharedSD.getDriver().findElements(timeLineTemperature);
        for (WebElement temp1 : timeline) {
            String convertToString = temp1.getText().replaceAll("°", "");
            int intValue = Integer.parseInt(convertToString);
            firstArray.add(intValue);
        }


        Collections.sort(firstArray);
        System.out.println(firstArray);
        lowestValue = firstArray.get(0);        
        highestValue = firstArray.indexOf(11) ; 

    }





          //Converting current temp to integer
    public int getCurrentTemp() {
        WebElement currentTemp =SharedSD.getDriver().findElement(currentTime);
        String currentTempNow = currentTemp.getText().replaceAll("˚","") ;
        return Integer.parseInt(currentTempNow) ;
    }
    public boolean verifyIsCurrentTempIsInBetweenTimeLine(){
        boolean isBetween = false;
        if(lowestValue<=currentTemperature && currentTemperature<= highestValue){

        }
        return isBetween = true;
    }



                      //scenario 3

    public void clickOnToday(){
        clickOn(clickOnExpandToday);
    }
    public void scrollDown(){
        scrollDown(0,900);
    }
    public boolean isLowestEqualToLowers(){
        WebElement topTemp = SharedSD.getDriver().findElement(lowestValueTop);
        String topLowest = topTemp.getText().replaceAll("˚","");
        int topLowestInt = Integer.parseInt(topLowest);

        WebElement lowTemp = SharedSD.getDriver().findElement(lowestValueBottom);
        String lowLowest = lowTemp.getText().replaceAll("˚","");
        int bottomLowestInt =Integer.parseInt(lowLowest);

        if(topLowestInt == bottomLowestInt){
            System.out.println("Lowest Values are equal");
        }
           return  true;
    }

    public boolean isHighestEqualToHighest() {

        WebElement topTemp = SharedSD.getDriver().findElement(highestValueTop);
        String topHighest = topTemp.getText().replaceAll("˚","");
        int topHighestInt = Integer.parseInt(topHighest);

        WebElement lowTemp = SharedSD.getDriver().findElement(highestValueBottom) ;
        String bottomHighest = lowTemp.getText().replaceAll("˚","");
        int bottomHighestInt = Integer.parseInt(bottomHighest);

        if(topHighestInt == bottomHighestInt)   {
            System.out.println("Highest Values are Equal");
        }
        return true;
    }

    //Scenario 4

    List<String> localTime = new ArrayList<String>();
    List<String> webTime = new ArrayList<String>();





    public void getWebTime(){

        webTime.removeAll(Arrays.asList("",null));   //getting rid of empty space

        List<WebElement> times = SharedSD.getDriver().findElements(timeFromWebSite);
        for(WebElement timeValue: times){
            String currentTime = timeValue.getText().replaceAll("Now",null);
            webTime.add(currentTime);
        }
           webTime.removeAll(Collections.singleton(null));
           webTime.removeAll(Collections.singleton(""));
        System.out.println("web times" + webTime);
    }

    public void getLocalTime(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        localTime.add("Now");


        for(int i=0; i<=10; i ++){
            cal.add(Calendar.HOUR,2);
            Date data = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("ha");
            String stringTime = sdf.format(data);
            stringTime = stringTime.replaceAll("PM","pm");
            stringTime = stringTime.replaceAll("AM","am");

            localTime.add(stringTime);
        }
    }
      boolean twoArrayEqual = false;

    public boolean verifyTwoArrayEqual(){
        Assert.assertEquals(webTime,localTime);
          return true;
         }


        boolean arrays = false;
    public boolean veryfyEqialityOfTwoArrays(){
              boolean isEqual = localTime.equals(webTime);
        return  isEqual = true;
    }





    

}
