package Utilities;

//clean backup before changing age to be used from the input file
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
	private int z = 0;
	

	
	
	
	
	int[] ageList = new int[] {0,5,15,16,18,40,45,46,50,51,61,66,71,76,81,86,91};
	
	public Illustration(){
		
	}
		
	
	
	public void createIllustration(WebDriver driver, Element objMap) throws InterruptedException {
		this.driver = driver;
		this.input = objMap;
				
		//adding headers
		try{
			String pathFile = "C:\\lpa\\lpaResults.csv";
			PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(pathFile,true)));
						out.println("State,Illustration Type,Plan Type,Product");
						out.close();
					} catch (IOException e1){
						e1.printStackTrace();  }
		
		System.out.println("Calling createIllustration");
	
		for (int a = 0; a<ageList.length; a++){
			
		driver.findElement(By.id("createClientIllustration_text")).click(); 
		//this object identification is not working not find the object or if find it, is not clicking on it
		// I would suggest use Javascript as an option better, or xpath
		
		Thread.sleep(500);
		
		
			//trying JavaScript
		WebElement jsDriver = driver.findElement(By.id("srcore_widget_ModalDialog_" + z + "_button_ok"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.findElement(By.id("radioNewClient")).click();

		Thread.sleep(200);
		
		driver.findElement(By.id("NewClientFirstName")).sendKeys("Automation");
		
		Thread.sleep(100);

		driver.findElement(By.id("NewClientLastName")).sendKeys("011220161600");
		
		Thread.sleep(100);
		//driver.findElement(By.id("NewClientAge")).click();
		driver.findElement(By.id("NewClientAge")).sendKeys(String.valueOf(ageList[a]));
		
		Thread.sleep(300);

		System.out.println("sending male");
		//driver.findElement(By.id("NewClientGender")).sendKeys("Male");
		driver.findElement(By.xpath(".//*[@id='NewClientGender']/tbody/tr/td[1]/div[1]/span")).sendKeys("Male");
		
		Thread.sleep(100);

		
		//clicking next
		js.executeScript("arguments[0].click()", jsDriver);
//		driver.findElement(By.xpath(".//*[@id='srcore_widget_ModalDialog_" + z + "']/div[2]/div[2]/span[1]/span")).click();
//		driver.findElement(By.xpath(".//*[@id='srcore_widget_ModalDialog_0']/div[2]/div[2]/span[1]/span")).click();

		z++;
		System.out.println("Z = : " + z);
		
		Thread.sleep(500);
		
		//clicking to open state 
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[2]/div[1]")).click();
		String stateListResults = driver.findElement(By.id("issueState_menu")).getText().replace("\n", ",");
		String[] stateListArray = stateListResults.split(",");
		//closing state
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[2]/div[1]")).click();
		
		Thread.sleep(100);
//changing loop here for TESTING 
		
		
		
		
		
		
		
//setting B to equal 50 instead of 0		
		
		//state loop
		for(int b = 50; b<stateListArray.length; b++){
		
			
						
			
			
//Ending Change			
		driver.findElement(By.xpath(".//*[@id='issueState']/tbody/tr/td[1]/div[1]/span")).sendKeys(String.valueOf(stateListArray[b]));
		
		Thread.sleep(100);

		//opening illustration type
		driver.findElement(By.xpath(".//*[@id='illustrationType']/tbody/tr/td[2]/div[1]")).click();
		String illustrationResults = driver.findElement(By.id("illustrationType_menu")).getText().replace("\n", ",");
		String[] illustrationArray = illustrationResults.split(",");
		//closing illustration type	
		driver.findElement(By.xpath(".//*[@id='illustrationType']/tbody/tr/td[2]/div[1]")).click();	
		
		//Thread.sleep(500);

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
			
		//Thread.sleep(500);

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
		//System.out.println(String.valueOf(stateListArray[b]) + "," + String.valueOf(illustrationArray[c]) + "," + String.valueOf(planTypeArray[d]) + "," + String.valueOf(productArray[e]) + "," + String.valueOf(ageList[a]));
		
		try{
			String pathFile = "C:\\lpa\\lpaResults.csv";
			PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter(pathFile,true)));
						out.println(String.valueOf(stateListArray[b]) + "," + String.valueOf(illustrationArray[c]) + "," + String.valueOf(planTypeArray[d]) + "," + String.valueOf(productArray[e]) + "," + String.valueOf(ageList[a]));
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
		driver.findElement(By.xpath(".//*[@id='srcore_widget_ModalDialog_" + z + "_button_cancel_label']")).click();
		//		driver.findElement(By.xpath(".//*[@id='srcore_widget_ModalDialog_1_button_cancel_label']")).click();
		z++;
		System.out.println("Z = : " + z);

		Thread.sleep(500);
		}  //closing for age loop
	}
}  //closing all code


/*
		//This block can take the results from the drop down window and make them into an array.
		String planTypeResults = driver.findElement(By.id("planTypeIll_menu")).getText().replace("\n",",");
		String[] planTypeArray = planTypeResults.split(",");
		System.out.println(planTypeArray[1]);
		*/
