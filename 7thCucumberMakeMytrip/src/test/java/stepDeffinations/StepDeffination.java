package stepDeffinations;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDeffination {

	WebDriver driver;

	@Given("User launch Chrome Browser and enter URL {string}")
	public void user_launch_chrome_browser_and_enter_url(String string) throws InterruptedException {
		String URL = "https://www.makemytrip.com/";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/section[1]/span[1]")).click();

	}

	@Given("User clicks on Flights module and Select RoundTrip option")
	public void user_clicks_on_flights_module_and_select_round_trip_option() throws InterruptedException {
		WebElement Flight = driver
				.findElement(By.xpath("//*[@class='chNavIcon appendBottom2 chSprite chFlights active']"));
		Flight.click();
		Thread.sleep(5000);
		WebElement RoundTrip = driver
				.findElement(By.xpath("//li[@data-cy='roundTrip']//span[@class='tabsCircle appendRight5']"));
		RoundTrip.click();
	}

	@When("User Enter From location with {string} and {string}")
	public void user_enter_from_location_with_and(String string, String string2) throws InterruptedException {

		String From_loc = "HYD";
		String To_loc = "MAA";
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(2000);
		WebElement FromField = driver.findElement(By.xpath("//input[@placeholder=\"From\"]"));
		FromField.sendKeys(From_loc);
		Thread.sleep(2000);
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();

		driver.findElement(By.id("toCity")).click();
		Thread.sleep(2000);
		WebElement ToField = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
		ToField.sendKeys(To_loc);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();

	}

	@When("Select DEPARTURE Date and RETRUN Date")
	public void select_departure_date_and_retrun_date() throws InterruptedException {
		WebElement DepatureDate = driver.findElement(By.xpath("//div[@aria-label='Mon Oct 02 2023']"));
		Thread.sleep(2000);

		DepatureDate.click();

		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		WebElement ReturnDate = driver.findElement(By.xpath("//div[@aria-label='Mon Nov 06 2023']"));
		Thread.sleep(2000);

		ReturnDate.click();

	}

	@When("Click on Search Button")
	public void click_on_search_button() throws InterruptedException {

		driver.findElement(By.xpath("//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		Thread.sleep(15000);

	}

	@Then("Verify the Search page is displayed as expected")
	public void verify_the_search_page_is_displayed_as_expected() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement popup = driver.findElement(By.xpath("//*[@class='bgProperties icon20 overlayCrossIcon']"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='bgProperties icon20 overlayCrossIcon']")));
		popup.click();

		String ExpectedHeading = "Flights from Hyderabad to Chennai, and back";
		WebElement ActualHeading = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div[2]/p/span"));
		String Actual = ActualHeading.getText();
		Assert.assertEquals(ExpectedHeading, Actual);
		driver.close();

	}
}