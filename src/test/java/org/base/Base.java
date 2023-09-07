package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static	WebDriver driver;
	public static  Actions a ;
	public static Robot r ;
	public static Alert al;
	public static Select s;
	public static void chromeBrowser() {
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
	}
	public static void firefox() {
WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();
	}
	public static void edgeDriver() {
WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();
	}
    public static void maxWin() {
driver.manage().window().maximize();
}
    public static void launchTheUrl(String url) {
driver.get(url);
	}
	public static void getTheTitle() {
String title = driver.getTitle();
System.out.println("page title:"+title);
	}
	public static String getTheCurrentUrl() {
String currentUrl = driver.getCurrentUrl();
return currentUrl;
	}
	public static void getTheText(WebElement element) {
		String text = element.getText();
		System.out.println("get the text:"+text);
	}
	
	public static void sendTheKeys(WebElement element, String keys ) {
	element.sendKeys(keys);
	}
    public static void getTheattribute(WebElement element, String value) {
	String attribute = element.getAttribute(value);
	System.out.println("attribute :"+attribute);
    }	
	public static void clickTheElement(WebElement element) {
element.click();
	}

	public static void dragNDrop(WebElement sourceElement, WebElement targetElement ) {
a.dragAndDrop(sourceElement, targetElement).perform();
	}

	public static void moveTheMouse(WebElement element) {
	a=new Actions(driver);	
a.moveToElement(element).click().perform();
	}
	public static void upTheKey(CharSequence key){
	a=new Actions(driver);
a.keyUp(key).perform();
	}
	public static void downTheKey(CharSequence key) {
	a=new Actions(driver);
a.keyDown(key).perform();
	}
	public static void clickTwice(WebElement element) {
	a=new Actions(driver);
a.doubleClick(element).perform();
	}
	public static void rightClick(WebElement element) {
	a=new Actions(driver);
a.contextClick(element).perform();
	}
   public static void slctAll() throws AWTException {
   r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_A);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_A);
    }
  public static void copy() throws AWTException {
	 r = new Robot();
	 r.keyPress(KeyEvent.VK_CONTROL);
	 r.keyPress(KeyEvent.VK_C);
	 r.keyRelease(KeyEvent.VK_CONTROL);
	 r.keyRelease(KeyEvent.VK_C);
    }
  public static void cut() throws AWTException {
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_X);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_X);
	}
  public static void paste() throws AWTException {
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_V);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_V);
    }
  public static void keyUp() throws AWTException {
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_UP);
		 r.keyRelease(KeyEvent.VK_UP);	
	    }
  public static void keyDown() throws AWTException {
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);	
	    } 
  public static void tab() throws AWTException {
		 r = new Robot();
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);	
	    }  
	public static void alertAccept() {
al=driver.switchTo().alert();
 al.accept(); 
	}  
	public static void alertDismiss() {
al=driver.switchTo().alert();
 al.dismiss();
	}
	public static void alertPrompt(String keysToSend) {
al=driver.switchTo().alert();
String text = al.getText();
System.out.println("Alert text:"+text);
al.sendKeys(keysToSend);
al.accept();
	}
	public static void getScreenshot(String fileName) throws IOException {
TakesScreenshot tk =(TakesScreenshot)driver;
File src = tk.getScreenshotAs(OutputType.FILE);
File des = new File("C:\\Users\\User\\eclipse-workspace\\MavenNewProject\\screenshot\\"+fileName+".png");
FileUtils.copyDirectory(src, des);
	}
	
	public void javaClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].click()", element);	
	}
	public static void javaSendKeys(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
       	js.executeScript("arguments[0].setAttribute('value','"+value+"')", element);
	}
	public static void javaGetAttribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}
	public static void javaScroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntiView()", element);
	}
	public static String childWinId(int w) {
		Set<String> allId = driver.getWindowHandles();
		List <String>l=new ArrayList();
		l.addAll(allId);
		String p = l.get(w);
		return p;
    }
	public static void selectValue(WebElement element ,String value) {
		s=new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectIndex(WebElement element ,int index) {
		s=new Select(element);
		s.selectByIndex(index);
	}
	public static void selectVisibleText(WebElement element,String text) {
		s=new Select(element);
		s.selectByVisibleText(text);
	}
	public static void selectValue(WebElement element  ) {
		s=new Select(element);
		s.isMultiple();
	}
	private void getdatafromsheet(String file,String sheet,int row,int cell) throws FileNotFoundException {
	File f = new File(file);
    FileInputStream fin = new FileInputStream (f);
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
