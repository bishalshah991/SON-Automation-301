package testCase;

import BaseClass.TestBase;
import Pages.LoginPage;
import Pages.PolicySearch;
import Utility.ReadJsonData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EndToEndSetupTest extends TestBase {
    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"son.json";

    @Test
    public void EndToEndTest() throws IOException, ParseException {
        ReadJsonData readJsonData=new ReadJsonData();
        String u_username=System.getProperty("userName");
        String P_password=System.getProperty("passWord");

        LoginPage loginPage=new LoginPage();
        loginPage.Login(u_username,P_password);

        PolicySearch policySearch=new PolicySearch();
        policySearch.PolicySearchTab();
        policySearch.EnterPolicySearch();
        policySearch.BeginClaim();

    }
}
