package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HotelPre extends BasePage {



    //Elements
    private By checkIn = By.xpath("//input[@id='qf-0q-localised-check-in']");
    private By checkOut = By.xpath("//input[@id='qf-0q-localised-check-out']");
    private By destinationInput = By.xpath("//*[@id=\"qf-0q-destination\"]");
    private By autoSuggestList = By.xpath("//tbody[@class = 'autosuggest-city']");
    private By search = By.xpath("//button[@class='cta cta-strong']");



    public void preTestFunctions() throws InterruptedException {
        clickOn(checkIn);

        SimpleDateFormat sdf = new SimpleDateFormat("d");

        Date date = new Date();
        String today = sdf.format(date);
        List<WebElement> dates = SharedSD.getDriver().findElements(By.xpath("//*[@class='widget-datepicker-bd']/descendant::a"));
        for(WebElement days : dates) {
            if (days.getText().equals(today)){
                days.click();
                break;
            }
        }
        //inout to Check Out

        clickOn(checkOut);
        Calendar calendar = new GregorianCalendar();
        String todaysDay = sdf.format(calendar.getTime()); //we are saving today's date  in String

        System.out.println(todaysDay);

        calendar.add(calendar.DAY_OF_MONTH,7); //adding date to our current date
        String seven = sdf.format(calendar.getTime());  // we are saving that added date in String

        for(WebElement plusSeven : dates){
            if (plusSeven.getText().equals(seven)){
                plusSeven.click();
                System.out.println("test");
                Thread.sleep(2000);
                break;
            }
        }
        System.out.println(seven);
    }



    public void fillOutAutoSuggest(String yourSendingText,String suggestedText) throws InterruptedException{
        setValue(destinationInput,yourSendingText);
        Thread.sleep(2000);
        List<WebElement> suggestions = SharedSD.getDriver().findElements(autoSuggestList);
        for(WebElement suggest : suggestions) {
            if (suggest.getText().contains(suggestedText)) {
                Thread.sleep(2000);
                suggest.click();

            }
        }
    }


    public void clickOnSearchButton(){
        clickOn(search);
    }
}
