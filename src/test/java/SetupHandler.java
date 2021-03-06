import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;

////////////////////////////////////// This is a support class for aiding login with easy methods ///////////////////////
// This class handles creating the webdriver, the wait and executes a script to hide the identity of the browser to defeat bot flaggers
public class SetupHandler{
	private WebDriver driver;	
	private WebDriverWait wait;
	private XPT xp;
	private PageNavigator navi;
	
	public SetupHandler(){
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		this.xp = new XPT(this.driver, this.wait); 
		this.navi = new PageNavigator(this.driver, this.wait, this.xp);		
	}

	public WebDriver getDriver(){
		return this.driver;
	}

	public WebDriverWait getWait(){
		return this.wait;
	}

	public XPT getNewNavigationToolbox(){
		return this.xp;
	}

	public PageNavigator getPageNavigator(){
		return this.navi;			
	}

	public void executeHideIdentity(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"); // Avoid being detected
	}

} 
	







