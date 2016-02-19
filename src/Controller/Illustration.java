package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.Element;

@SuppressWarnings("unused")
public class Illustration {

	private WebDriver driver;
	private Element input;
	
	public Illustration(){
		
	}
		
	
	
	public void createIllustration(WebDriver driver, Element objMap) throws InterruptedException {
		this.driver = driver;
		this.input = objMap;
				
		//adding headers
		try{
			String pathFile = "C:\\lpa\\lpaResults.csv";
			PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(pathFile,true)));
						out.println("State,Illustration Type,Plan Type,Product,Age");
						out.close();
					} catch (IOException e1){
						e1.printStackTrace();  }
		
		System.out.println("Calling createIllustration");
	
			
		Thread.sleep(500);
		
		driver.findElement(By.xpath(".//*[@id='createClientIllustration_text']")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath(".//*[@id='radioNewClient']")).click();
		System.out.println(objMap.getOccurance1());
		
		
		//JavaScript
		WebElement jsDriver = driver.findElement(By.id("srcore_widget_ModalDialog_" +  objMap.getOccurance1() + "_button_ok"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		

		
		Thread.sleep(200);
		
		driver.findElement(By.xpath(".//*[@id='NewClientFirstName']")).sendKeys("Automation");
		
		Thread.sleep(100);

		driver.findElement(By.xpath(".//*[@id='NewClientLastName']")).sendKeys("01282016");
		
		System.out.println("Age is " + objMap.getAge());
		
		Thread.sleep(100);
	
		driver.findElement(By.xpath(".//*[@id='NewClientAge']")).sendKeys(objMap.getAge());
		
		Thread.sleep(400);

		//the code isn't seeing the id to send the keys to without clicking it. Added in a click action to compensate.
		driver.findElement(By.xpath(".//*[@id='NewClientGender']/tbody/tr/td[1]/div[1]/span")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='NewClientGender']/tbody/tr/td[1]/div[1]/span")).sendKeys("Male");

		Thread.sleep(200);

		
		//clicking next
		js.executeScript("arguments[0].click()", jsDriver);
		
		
		Thread.sleep(500);
		
		//clicking to open state 
		//for some reason the code is not seeing the first click on the state list. Adding a second click to compensate.
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[2]/div[1]")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[2]/div[1]")).click();
		
		Thread.sleep(100);
		
		String stateListResults = driver.findElement(By.id("issueState_menu")).getText().replace("\n", ",");
		String[] stateListArray = stateListResults.split(",");
		//closing state
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[2]/div[1]")).click();
		
		Thread.sleep(100);

		//state loop
		for(int b = 0; b<stateListArray.length; b++){
		
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[1]/div[1]/span")).sendKeys(String.valueOf(stateListArray[b]));
		
		Thread.sleep(100);

		//opening illustration type
		driver.findElement(By.xpath(".//*[@id='illustrationType']/tbody/tr/td[2]/div[1]")).click();
		String illustrationResults = driver.findElement(By.id("illustrationType_menu")).getText().replace("\n", ",");
		String[] illustrationArray = illustrationResults.split(",");
		//closing illustration type	
		driver.findElement(By.xpath(".//*[@id='illustrationType']/tbody/tr/td[2]/div[1]")).click();	
		
		//illustration loop
		for(int c = 0; c<illustrationArray.length; c++){
		
		Thread.sleep(100);
		
		driver.findElement(By.xpath(".//*[@id='illustrationType']/tbody/tr/td[1]/div[1]/span")).sendKeys(String.valueOf(illustrationArray[c]));
		Thread.sleep(100);

		//opening plan type menu
		driver.findElement(By.xpath(".//*[@id='planTypeIll']/tbody/tr/td[2]/div[1]")).click();
		String planTypeResults = driver.findElement(By.id("planTypeIll_menu")).getText().replace("\n",",");
		String[] planTypeArray = planTypeResults.split(",");
		//closing plan type menu
		driver.findElement(By.xpath(".//*[@id='planTypeIll']/tbody/tr/td[2]/div[1]")).click();
			
		//plan type loop
		for(int d = 0; d<planTypeArray.length; d++){
		
		Thread.sleep(100);

		//sending plan type value
		driver.findElement(By.xpath(".//*[@id='planTypeIll']/tbody/tr/td[1]/div[1]/span")).sendKeys(String.valueOf(planTypeArray[d]));
		
		Thread.sleep(100);

		//opening product menu
		driver.findElement(By.xpath(".//*[@id='product']/tbody/tr/td[2]/div[1]")).click();
		String productResults = driver.findElement(By.id("product_menu")).getText().replace("\n",",");
		String[] productArray = productResults.split(",");
		//closing product menu
		driver.findElement(By.xpath(".//*[@id='product']/tbody/tr/td[2]/div[1]")).click();
		
		Thread.sleep(100);
		
		//product loop
		for(int e = 0; e<productArray.length; e++){
			
		//order is Signed State, Illustration Type, Plan Type, Product, age's
		
		try{
			String pathFile = "C:\\lpa\\lpaResults.csv";
			PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(pathFile,true)));
						out.println(String.valueOf(stateListArray[b]) + "," + String.valueOf(illustrationArray[c]) + "," + String.valueOf(planTypeArray[d]) + "," + String.valueOf(productArray[e]) + "," + objMap.getAge());
						out.close();
					} catch (IOException e1){
						e1.printStackTrace();  }

		
		
		Thread.sleep(100);
	
		}//closing product loop
		Thread.sleep(100);
		
		} //closing plan type loop
		Thread.sleep(100);
		
		} //closing illustration loop
		Thread.sleep(100);
		System.out.println("Next State");
		
		} //closing state loop
		Thread.sleep(100);
		
		//clicking cancel to start next age
		driver.findElement(By.xpath(".//*[@id='srcore_widget_ModalDialog_" + objMap.getOccurance2() + "_button_cancel_label']")).click();

		Thread.sleep(5000);
		System.out.println("End of run");
	//	}  //closing for age loop
	}
}  //closing all code


/*
		//This block can take the results from the drop down window and make them into an array.
		String planTypeResults = driver.findElement(By.id("planTypeIll_menu")).getText().replace("\n",",");
		String[] planTypeArray = planTypeResults.split(",");
		System.out.println(planTypeArray[1]);
		*/
