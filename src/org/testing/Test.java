package org.testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Test {
	
    public static void main(String[] args) {

       
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Madhu\\eclipse-workspace\\sample\\edgedriver\\msedgedriver.exe");

        
        WebDriver driver = new EdgeDriver();

        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15)) 
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(Exception.class); 

       
        driver.get("https://fitpeo.com");

        try {
            
            WebElement revenueCalculatorLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
            revenueCalculatorLink.click();

            
            System.out.println("Clicked on Revenue Calculator link.");

           
            WebElement sliderSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slider-section")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sliderSection);

            
            System.out.println("Scrolled to slider section.");

            
            WebElement slider = driver.findElement(By.cssSelector(".slider"));
            slider.sendKeys("823"); 

          
            System.out.println("Slider value set to 823.");

           
            WebElement textField = driver.findElement(By.id(":r0:")); 
            textField.clear();
            textField.sendKeys("560");

           
            System.out.println("Text field set to 560.");

           
            WebElement sliderValue = driver.findElement(By.id("slider-value-id"));
            assert sliderValue.getText().equals("560");

            
            System.out.println("Slider value validated as 560.");

           
            driver.findElement(By.id("CPT-99091")).click();
            driver.findElement(By.id("CPT-99453")).click();
            driver.findElement(By.id("CPT-99454")).click();
            driver.findElement(By.id("CPT-99474")).click();

           
            System.out.println("Selected CPT codes.");

           
            WebElement totalReimbursement = driver.findElement(By.id("total-reimbursement-id")); 
            assert totalReimbursement.getText().equals("$110700");

            
            System.out.println("Total reimbursement validated as $110700.");

        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
           
           // driver.quit();
        }
    }
}
