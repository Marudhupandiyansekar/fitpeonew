package org.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class fitpeo {
	
	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		
	       try {
	            
	            driver.get("https://www.fitpeo.com");
	            
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	            
	          
	            WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
	            revenueCalculatorLink.click();
	            
	            WebElement slider = driver.findElement(By.id("slider-id"));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(slider).perform();
	            
	          
	            int targetValue = 820;
	            WebElement sliderHandle = driver.findElement(By.className("ui-slider-handle"));
	            actions.dragAndDropBy(sliderHandle, calculateOffset(slider, targetValue), 0).perform();

	            
	            WebElement textField = driver.findElement(By.id("slider-text-field-id"));
	            textField.clear();
	            textField.sendKeys("560");

	            
	            String sliderValue = textField.getAttribute("value");
	            if (!sliderValue.equals("560")) {
	                System.out.println("Slider value update failed.");
	            }

	          
	            String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
	            for (String cptCode : cptCodes) {
	                WebElement checkbox = driver.findElement(By.id(cptCode));
	                if (!checkbox.isSelected()) {
	                    checkbox.click();
	                }
	            }

	          
	            WebElement totalReimbursement = driver.findElement(By.id("total-reimbursement-id"));
	            String reimbursementText = totalReimbursement.getText();
	            if (!reimbursementText.equals("$110700")) {
	                System.out.println("Total Recurring Reimbursement validation failed.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           
	            driver.quit();
	        }
	    }

	    
	    public static int calculateOffset(WebElement slider, int targetValue) {
	        int min = 0; 
	        int max = 1000; 
	        int sliderWidth = slider.getSize().width;
	        return (int) ((targetValue - min) / (double) (max - min) * sliderWidth);
	    }
	}

				
				
		
	