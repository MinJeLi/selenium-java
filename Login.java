import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class Login {
	
	public boolean LoginDSM (WebDriver driver) throws Exception{
		
		String UserName="admin";
		String PassWord="123456";
		
		WebElement ElementUserName = driver.findElement(By.name("username"));
		ElementUserName.sendKeys(UserName);
		WebElement ElementPasswd = driver.findElement(By.name("passwd"));
		ElementPasswd.sendKeys(PassWord);
		WebElement LoginButton = driver.findElement(By.id("login-btn"));
		LoginButton.click();
		
		Thread.sleep(3000);
		
		if(!driver.findElements(By.id("sds-taskbar")).isEmpty()) {
			return true;
		}else {
			return false;
		}
				
	}

}
