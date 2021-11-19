package stepdefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GoogleSearchStepdef {
	WebDriver driver;

	@Given("I launch google page")
	public void i_launch_google_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@When("I search Java Tutorial")
	public void i_search_java_tutorial() {
		driver.findElement(By.name("q")).sendKeys("Java Tutorial");
		driver.findElement(By.name("q")).submit();
	}

	@Then("should display Java result page")
	public void should_display_java_result_page() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals("Java Tutorial - Google Search", pageTitle);
	}

	@When("I search Selenium Tutorial")
	public void i_search_selenium_tutorial() {
		driver.findElement(By.name("q")).sendKeys("Selenium Tutorial");
		driver.findElement(By.name("q")).submit();
	}

	@Then("should display Selenium result page")
	public void should_display_selenium_result_page() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals("Selenium Tutorial - Google Search", pageTitle);
	}
	
	
	@When("I search Cypress Tutorial")
	public void i_search_cypress_tutorial() {
		driver.findElement(By.name("q")).sendKeys("Cypress Tutorial");
		driver.findElement(By.name("q")).submit();
	}
	
	
	@Then("should display Cypress result page")
	public void should_display_cypress_result_page() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals("Cypress Tutorial - Google Search", pageTitle);
	}
	
	@Then("I close the browser")
	public void i_close_the_browser() {
		driver.close();
	}
	
	@After
	public void teardown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot screen =(TakesScreenshot)driver;
			File screenshot = screen.getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(screenshot);
			scenario.attach(filecontent, "image/png", "image1");
		}
	}

}
