import org.openqa.selenium.*;

public class DHCPtoStaticIP {
	
	public void DtoCsetting(WebDriver driver) throws Exception{
		
		WebElement OpenMenu = driver.findElement(By.cssSelector("td.x-btn-mc button.x-btn-text[aria-label='Main Menu']"));
		OpenMenu.click();
		
		Thread.sleep(500);
		
		WebElement OpenControlPanel = driver.findElement(By.cssSelector("div.sds-appview-app-item img[src*='ControlPanel']"));
		OpenControlPanel.click();
		
		Thread.sleep(1000);
		
		WebElement OpenNetwork = driver.findElement(By.cssSelector(".advanced-homescreen-view div[class*='item-wrap'][fn*='Network']")); 
		if (OpenNetwork.isDisplayed()) {
			OpenNetwork.click();
		}
		
		Thread.sleep(1000);
		
		WebElement ToInterfaceTab = driver.findElement(By.cssSelector("[id*='InterfaceTab']"));
		if (ToInterfaceTab.isDisplayed()) {
			ToInterfaceTab.click();
		}
		
		Thread.sleep(1000);
		
		WebElement SelectInterface = driver.findElement(By.cssSelector(".contentwrapper div[class*='net-lan-connected']"));
		if (SelectInterface.isDisplayed()) {
			SelectInterface.click();
		}
		WebElement EditInterface = driver.findElement(By.cssSelector("[aria-label*='編輯']"));
		if (EditInterface.isDisplayed()) {
			EditInterface.click();
		}
		
		Thread.sleep(500);
		
		
	}
}
