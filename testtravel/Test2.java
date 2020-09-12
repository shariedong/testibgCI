package CaseStudy1;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("eeee");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hui\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//open web
		driver.get("http://newtours.demoaut.com/");
		
		//wait for load completely
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// wait until the web link register is displayed
		WebDriverWait registerwait = new WebDriverWait(driver,30);
		registerwait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
		
		//click on the register menu button
		driver.findElement(By.linkText("REGISTER")).click();
		
		//enter all the details
		driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("sharie");
		driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("Dong");
		driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("04444444");
		driver.findElement(By.id("userName")).sendKeys("222@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name,'address1')]")).sendKeys("15 union st");
		driver.findElement(By.xpath("//input[contains(@name,'city')]")).sendKeys("Auckland");
		driver.findElement(By.xpath("//input[contains(@name,'state')]")).sendKeys("Null");
		driver.findElement(By.xpath("//input[contains(@name,'postalCode')]")).sendKeys("1010");
		Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@name,'country')]")));
		dropdown.selectByVisibleText("NEW ZEALAND");
		String username = "shariedong@gmail.com";
		driver.findElement(By.cssSelector("input#email")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[contains(@name,'confirmPassword')]")).sendKeys("12345678");
		
		//click on submit button
		driver.findElement(By.xpath("//input[contains(@name,'register')]")).click();
		
		//wait until a message and verify the registered user
		WebDriverWait usernamewait = new WebDriverWait(driver,30);
		usernamewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Note: Your')]"))).isDisplayed();
		String verifyusername = driver.findElement(By.xpath("//*[contains(text(),'Note: Your')]")).getText();
		if (verifyusername.equals("Note: Your user name is "+username+".")) {
			System.out.println("username has been verified");
		}
		
		//wait until click flight link
		WebDriverWait flightwait = new WebDriverWait(driver,30);
		flightwait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Flights"))).isSelected();
		driver.findElement(By.linkText("Flights")).click();
		
		//choose flight type as round trip
		driver.findElement(By.xpath("//input[contains(@value,'roundtrip')]")).click();

		//enter all flight details
		//choose passenger number
		Select passengerNo = new Select(driver.findElement(By.xpath("//select[contains(@name,'passCount')]")));
		passengerNo.selectByVisibleText("1");
		
		//choose departplace
		Select departPlace = new Select(driver.findElement(By.xpath("//select[contains(@name,'fromPort')]")));
		departPlace.selectByVisibleText("London");
		
		//choose date and day
		Select dateMonth = new Select(driver.findElement(By.xpath("//select[contains(@name,'fromMonth')]")));
		dateMonth.selectByVisibleText("June");
		Select dateDay = new Select(driver.findElement(By.xpath("//select[contains(@name,'fromDay')]")));
		dateDay.selectByVisibleText("19");
		
		//choose arrive place
		Select arrivePlace = new Select(driver.findElement(By.xpath("//select[contains(@name,'toPort')]")));
		arrivePlace.selectByVisibleText("Paris");
		
		//choose return date and Day
		Select returDate = new Select(driver.findElement(By.xpath("//select[contains(@name,'toMonth')]")));
		returDate.selectByVisibleText("July");
		Select returDay = new Select(driver.findElement(By.xpath("//select[contains(@name,'toDay')]")));
		returDay.selectByVisibleText("15");
		//choose class
		driver.findElement(By.xpath("//input[contains(@value,'Coach')]")).click();
		
		//choose airlines
		Select airlines = new Select(driver.findElement(By.xpath("//select[contains(@name,'airline')]")));
		airlines.selectByVisibleText("Unified Airlines");
		
		//click on continue
		driver.findElement(By.xpath("//input[contains(@name,'findFlights')]")).click();
		
		//wait until select image is visible
		WebDriverWait selectimage = new WebDriverWait(driver,30);
		selectimage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//tr//tr//tr[1]//td[1]//img[1]")));
		
		//use list to select fourth option
		List<WebElement> departlist = driver.findElements(By.xpath("//input[contains(@name,'outFlight')]"));
		departlist.get(3).click();
		List<WebElement> returnlist = driver.findElements(By.xpath("//input[contains(@name,'inFlight')]"));
		returnlist.get(3).click();
		//click on continue
		driver.findElement(By.xpath("//input[contains(@name,'reserveFlight')]")).click();
		//wait until secure purchuse visible 
		WebDriverWait secureButton = new WebDriverWait(driver,30);
		secureButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'buyFlights')]")));
		
		//enter all passenger details
		driver.findElement(By.xpath("//input[contains(@name,'passFirst0')]")).sendKeys("sharie");
		driver.findElement(By.xpath("//input[contains(@name,'passLast0')]")).sendKeys("Dong");
		Select meal = new Select(driver.findElement(By.xpath("//select[contains(@name,'pass')]")));
		meal.selectByVisibleText("Hindu");
		Select creditcard = new Select(driver.findElement(By.xpath("//select[contains(@name,'credit')]")));
		creditcard.selectByVisibleText("Visa");
		driver.findElement(By.xpath("//input[contains(@name,'creditnumber')]")).sendKeys("1234567890");
		Select expirMon = new Select(driver.findElement(By.xpath("//select[contains(@name,'cc')][1]")));
		expirMon.selectByVisibleText("09");
		Select expirYear = new Select(driver.findElement(By.xpath("//select[contains(@name,'cc')][2]")));
		expirYear.selectByVisibleText("2000");
		//click on secure purchase
		driver.findElement(By.xpath("//input[contains(@name,'buyFlights')]")).click();
		driver.close();

	}

}
