package newproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use the correct duration

		try {
			// land on the website
			driver.get("https://www.expedia.com/");
			
			 String currentUrl = driver.getCurrentUrl();
	            String pageTitle = driver.getTitle();

	            System.out.println("Current URL: " + currentUrl);
	            System.out.println("Page Title: " + pageTitle);

			// verify the landing page

			String expectedTitle = "Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More";
			if (driver.getTitle().equals(expectedTitle)) {
				System.out.println("Landed on the correct page!");
			} else {
				System.out.println("Landing on the incorrect page!");
			}

			// go to flights tab
			WebElement flightsTab = driver.findElement(By.linkText("Flights"));
			flightsTab.click();
			Thread.sleep(2000);

			// go to one way tab
			WebElement OnewayTab = driver.findElement(
					By.xpath("//*[@id=\"search_form_product_selector_flights\"]/div/div[1]/div/ul/li[2]/a"));
			OnewayTab.click();
			Thread.sleep(5000);

			// Enter the source city (e.g., "Kolkata") in the input field
			WebElement leavingButton = driver.findElement(By.cssSelector("button[aria-label='Leaving from']"));
			leavingButton.click();

			Thread.sleep(2000);

			WebElement boardingInput = driver.findElement(By.cssSelector("input.uitk-field-input"));

			Thread.sleep(2000);

			boardingInput.sendKeys("Kolkata");
			boardingInput.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			WebElement buttonElementXPath = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
			buttonElementXPath.click();
			Thread.sleep(2000);

			// Input "Hyderabad" in the input field
////*[@id="FlightSearchForm_ONE_WAY"]/div/div[3]/div/div[2]/div/div/section/div[1]/div/div/button[2]/span

			WebElement destinationInput = driver.findElement(By.id("destination_select"));

			Thread.sleep(2000);

			destinationInput.sendKeys("Hyderabad");

			destinationInput.sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			// adjust date

			/*
			 * WebElement openCalendarButton = driver.findElement(By.cssSelector(
			 * "button[data-stid='uitk-date-selector-input1-default']"));
			 * openCalendarButton.click();
			 * 
			 * // Wait for the calendar to be visible (you can use WebDriverWait for better
			 * synchronization) Thread.sleep(2000); /*
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			 * ".uitk-day-button"))); // Assuming you want to click on a specific date, find
			 * and click that date button String specificDateLabel =
			 * "Saturday, February 17, 2024, Selected date";
			 * 
			 * // Find and click on the specific date WebElement specificDateButton =
			 * driver.findElement(By.xpath("//div[@aria-label='" + specificDateLabel +
			 * "']")); specificDateButton.click();
			 */

			// add passengers

			WebElement travelerButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-stid='open-room-picker']")));
			travelerButton.click();

			WebElement IncCounter = driver.findElement(By.xpath(
					"//*[@id=\"FlightSearchForm_ONE_WAY\"]/div/div[3]/div/div[2]/div/div/section/div[1]/div/div/button[2]/span"));

			Thread.sleep(2000);
			IncCounter.click();

			// click done
			WebElement DoneButton = driver.findElement(By.xpath("//*[@id=\"travelers_selector_done_button\"]"));
			DoneButton.click();

			Thread.sleep(2000);
			// click search

			WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"search_button\"]"));
			SearchButton.click();

			Thread.sleep(120000);

			// select the flight

			WebElement ClickFlight = driver.findElement(By.cssSelector(
					"button[data-stid='FLIGHTS_DETAILS_AND_FARES-index-1-leg-0-fsr-FlightsActionButton']"));
			ClickFlight.click();

			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// Close the browser window
			driver.quit();
		}

	}

}
