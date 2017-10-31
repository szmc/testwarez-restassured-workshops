package workshops.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SeleniumTest {

	private WebDriver driver;

	private String usernameLocator = ".//*[@id='user']";
	private String passwordLocator = ".//*[@id='password']";
	private String loginButtonLocator = ".//*[@id='login']";
	private String login = "html/body/div[1]/div[2]/a[1]";
	private String boardLocator = ".//*[@id='content']/div/div[2]/div/div/div[1]/ul/li[*]/a/span[2]/span[contains(.,'%s')]";
	private String cardLocator = ".//*[@id='board']/div[1]/div/div[2]/a[*]/div[*]/span[contains(.,'%s')]";
	private String username= "";
	private String password = "";
	private String cardName = "";
	private String boardName = "";


	@BeforeClass
	private void setup() {
		driver = new FirefoxDriver();
		//ToDo add restAssured setup here
	}

	@AfterClass
	private void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "dataProvider")
	public Object[][] dataProvider(){
		return new Object[][] {
				{boardName, cardName}

		};
	}

	@Test(dataProvider = "dataProvider")
	public void uiTestWithRestAssuredSetup(String boardName, String cardName)  {
		//Open login page
		driver.get("https://trello.com/login");
		//Populate username
		driver.findElement(new By.ByXPath(usernameLocator)).sendKeys(username);
		//Populate password
		driver.findElement(new By.ByXPath(passwordLocator)).sendKeys(password);
		//Click login button
		driver.findElement(new By.ByXPath(loginButtonLocator)).click();
		//Wait for page to be loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Verify if new board was added by rest assured setup.
		assert (driver.findElement(new By.ByXPath(String.format(boardLocator, boardName))).getText().equals(boardName));
		//Go to new board
		driver.findElement(new By.ByXPath(String.format(boardLocator, boardName))).click();
		//Check if card was added by rest assured setup.
		assert (driver.findElement(new By.ByXPath(String.format(cardLocator, cardName))).getText().equals(cardName));
	}
}
