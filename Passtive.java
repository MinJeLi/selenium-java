import org.openqa.selenium.*;


public class Passtive {
	
	public String PasstiveSetting(WebDriver driver, String IP) throws Exception{
		
		driver.get("http://"+IP+":5000");

		Thread.sleep(2000);
		
		Login L = new Login();
		if (L.LoginDSM(driver)) {
			DHCPtoStaticIP t = new DHCPtoStaticIP();
			t.DtoCsetting(driver);
			return "passtive set complete!";
			
		}else {
			return "Login Fail!";
		}
	}

}
