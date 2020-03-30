package Test.Listner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListners.class)

public class TestDemmo1
{   
	WebDriver driver;
	@Test(priority=1)
	public void verify_LaunchWebsite()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91975\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		Reporter.log("[Info] : Launch Website is Verified ");
	}
	@Test(priority=2)
	public void verify_Login()
	{
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		String we= driver.findElement(By.className("product_label")).getText();
		Assert.assertEquals(we, "Products");
		Reporter.log("[Info] : Login Successfully Verified");
	}
	@Test(priority=3)
	public void verify_getFailed()
	{
		System.out.println("This test case is going to fail");
		Assert.assertTrue(true);
		Reporter.log("[Info] : Test Case is Failed");
	}
	@Test(dependsOnMethods= {"verify_getFailed"})
	public void verify_getSkip()
	{
		System.out.println("This test is going to Skiped");
		Assert.assertTrue(true);
		Reporter.log("[Info] : Test Case is Skiped");

	}

}
