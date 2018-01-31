import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Scanner;
import java.net.URL;

public class BindHA {

	public static void main(String[] args) throws Exception {
		
		WebDriver FirefoxDriver = new RemoteWebDriver(new URL("http://10.11.48.62:4444/wd/hub"),DesiredCapabilities.firefox());
		WebDriver FirefoxDriverPasstive = new RemoteWebDriver(new URL("http://10.11.48.62:4445/wd/hub"),DesiredCapabilities.firefox());

		
		String ActiveIP = "1", PasstiveIP = "", HAIP = "",DSMVersion = "6.1";
		CheckStringISIP CheckIP = new CheckStringISIP();
		while (true) {
			System.out.println("Active IP:");
//			Scanner scanner = new Scanner(System.in);
//			ActiveIP = scanner.next();
			ActiveIP = "10.11.50.137";
			
			if (CheckIP.ValidIP(ActiveIP) && CheckIP.ping(ActiveIP)) {
				break;
			}else {
				System.out.println("The Active IP can not reachable try again~");
			}
			
		}
		
		while (true) {
			System.out.println("Passtive IP:");
//			Scanner scanner = new Scanner(System.in);
//			PasstiveIP = scanner.next();
			PasstiveIP = "10.11.78.163";
			
			if (CheckIP.ValidIP(PasstiveIP) && CheckIP.ping(PasstiveIP) && !PasstiveIP.equals(ActiveIP)) {
				break;
			}else{
				System.out.println("The Passtive IP can not reachable or ActiveIP = PasstiveIP try again~");
			}
			
		}
		
		while (true) {
			System.out.println("HA IP:");
//			Scanner scanner = new Scanner(System.in);
//			HAIP = scanner.next();
			HAIP = "10.11.48.148";
			
			if (CheckIP.ValidIP(HAIP) && !CheckIP.ping(HAIP) && !HAIP.equals(ActiveIP) && !HAIP.equals(PasstiveIP)) {
//				scanner.close();
				break;
			}else{
				System.out.println("The HA IP is exist or HA IP equals ActiveIP or PasstiveIP try again~");
			}
			
		}
		
		switch (DSMVersion) {
			case "6":
			case "6.1":
			case "6.0":
				Passtive p =new Passtive();
				String PasstiveResult;
				PasstiveResult = p.PasstiveSetting(FirefoxDriverPasstive, PasstiveIP);
				System.out.println(PasstiveResult);
				break;
		}
		
		FirefoxDriver.get("http://10.11.50.137:5000");
		
        FirefoxDriver.quit();
        FirefoxDriverPasstive.quit();
	}

}
