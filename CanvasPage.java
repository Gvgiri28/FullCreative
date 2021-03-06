Package pages;

import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  

public class HtmlCanvasPage{

	WebDriver driver;
	Properties obj = new Properties();
	
	public HtmlCanvasPage(WebDriver driver){
		this.driver =driver;
}
	
	public void SelectCanvasTool(){
		WebElement LineTool = driver.findElement(By.Xpath(obj.getProperty("Line_Tool")));
        	LineTool.click();
        	  //Find canvas element 
	         WebElement canvasElement = driver.findElement(By.id(obj.getProperty("CanvasSpace")));

}
	public void HorizonLine(){
		
	          //Draw the horizontal line
        	 Actions builder = new Actions(driver);
         	builder.moveToElement(canvasElement, 236, 135).click().moveByOffset(238,268).release().perform();
}
 
	public void VerticalLine(){
		  //Draw Vertical line
          	  builder.moveToElement(canvasElement, 151,183).click().moveByOffset(332,-181).release().perform();
}

	public void Rectangle(){
          	 //use javascript executor
	  	WebElement Rect = driver.findElement(By.Xpath(obj.getProperty("RectangleTool")));
	  	Rect.click();
	  	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
          	jsExecutor.executorScript("context.strokeRect(86, 347, 278, 102)");
}

	public void EraseHorizonLine(){
            	//Erase horizontal line
          	WebElement eraseHorizon= driver.findElement(By.Xpath(obj.getProperty("EraseTool")));
          	eraseHorizon.click();	  
	  	builder.moveToElement(canvasElement, 236,135).clickAndHold().moveByOffset(238,268).release().perform();
}
}
