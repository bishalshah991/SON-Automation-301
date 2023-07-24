package Pages;

import BaseClass.PageDriver;
import Utility.ReadJsonData;
import Utility.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class PolicySearch {
    WebDriver driver;
    WaitHelper waitHelper;
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    public PolicySearch(){
        driver=PageDriver.getCurrentDriver();
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(PageDriver.getCurrentDriver(),10);
    }

    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement PolicySearchTab;

    @FindBy(xpath = "//input[@placeholder='Type keywords and Press Enter....']")
    WebElement TypeKeyEnter;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement PolicySearchTextBox;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    public WebElement Active;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[12]/div/button/span[1]/mat-icon")
    public WebElement ThreeDots;


    @FindBy(xpath = "//span[contains(text(),'Begin Claim')]")
    public WebElement BeginClaim;

    @FindBy(xpath = "//div[contains(text(),'Start Claim')]")
    WebElement StartClaim;


    public void PolicySearchTab(){
        PolicySearchTab.click();
        waitHelper.waitForEl(TypeKeyEnter);
    }
    public void EnterPolicySearch() throws IOException, ParseException {
        String policyNumber=new ReadJsonData().Read_the_value_from_json(path,"Policy_number");
        String policyNo=System.getProperty("policy","policyNumber");
        PolicySearchTextBox.sendKeys(policyNo);
        waitHelper.waitForEl(Active);
    }
    public void BeginClaim(){
        ThreeDots.click();
        waitHelper.waitForEl(BeginClaim);
        BeginClaim.click();
        waitHelper.waitForEl(StartClaim);
    }


}
