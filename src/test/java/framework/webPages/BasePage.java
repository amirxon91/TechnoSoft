package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.time.Duration;

/**
 * Created by Amir
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void clear(By locator){
		webAction(locator).clear();
	}

	public void selectFromDropdownText(By locator, String dropdownText) {
		WebElement month = webAction(locator);

		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdownIndex(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}
	public void scrollDown(int x, int y) { // x will move horizontally, y will move vertically--> when we call this in page object we have to send x and y numbers
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		js.executeScript("window.scrollBy("+x+","+y+")"); //
	}
	public String webElementToString(By locator){
		WebElement webElement =webAction( locator);
		return webElement.getText().toString();
	}
	public int webElementToInt(By locator, String replaceTarget, String replacement){
		WebElement webElement = webAction( locator);
		String string = webElement.getText().toString();
		string = string.replace(replaceTarget,replacement);
		int intValue = Integer.parseInt(string);
		return intValue;
	}
	public void scrollDownWithLoop(int scrollDownNumber){
		for(int second = 0; ;second ++){
			if(second >= 20){
			break;
			}
			scrollDown(0,scrollDownNumber);
		}
	}
//slides only right or left
	public void slider(By locator, int left, int right){
		WebElement slider = SharedSD.getDriver().findElement(locator);
		Actions move = new Actions(SharedSD.getDriver());
		Action action = (Action) move.dragAndDropBy(slider,left,right).build();
		((Actions)action).perform();
	}





}
