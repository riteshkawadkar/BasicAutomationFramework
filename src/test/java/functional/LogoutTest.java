package functional;

import base.BaseTest;
import data.Constants;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest  extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void validate_logout(){
        //act
        String url = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .getHeader()
                .logout()
                .getCurrentPageURL();


        //assert
        Assert.assertEquals(url, Constants.LOGINPAGE_URL_AFTER_LOGOUT, "Wrong URL Found");
    }
}
