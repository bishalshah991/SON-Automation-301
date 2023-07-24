package Utility;

import BaseClass.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    WebDriverWait webDriverWait;
    WebDriver driver;

    public WaitHelper(WebDriver driver, int timeout){
        driver= PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void waitForElement(By bylocator){
        webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) bylocator));
    }

    public void waitForEl(WebElement element){
        webDriverWait.until(waitForElement(element));
    }

  public static ExpectedCondition<Boolean> waitForElement(WebElement el){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                boolean flag = false;

                try {
                    if (el.isDisplayed()){
                        flag=true;
                    }
                }catch (Exception e){
                    System.out.println("Inside Catch Block " + e.getMessage());
                }
                    return  flag;
            }
        };
  }

    public void Go_to_Wait_for_Element(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        boolean status=element.isDisplayed();
        if (status){
            System.out.println("Element is Displayed:-"+element.getText());
        }
        else {
            System.out.println("Element is not displayed: "+element.getText());
        }

    }
}
