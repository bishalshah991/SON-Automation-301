package testCase;

import BaseClass.PageDriver;
import BaseClass.TestBase;
import Pages.LoginPage;
import Utility.ReadJsonData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class LoginTest extends TestBase {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    @Test
    public void LoginToApplication() throws IOException, ParseException {
        ReadJsonData readJsonData=new ReadJsonData();
        String u_username=readJsonData.Read_the_value_from_json(path,"Username");
        String P_password=readJsonData.Read_the_value_from_json(path,"Password");
        LoginPage loginPage=new LoginPage();
        loginPage.Login(u_username,P_password);
        loginPage.LogoutFromApplication();
    }


}
