package functional;

import base.BaseTest;
import data.Constants;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
    }


    @Test
    public void test_login_with_valid_credentials(){

        //act
        String url = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .getCurrentPageURL();

        //assert
        Assert.assertEquals(url, Constants.HOMEPAGE_URL, "Wrong URL Found");
    }

    @Test
    public void test_valid_login_message(){

        //act
        String validationMessage = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .getValidationMessage();


        //assert
        Assert.assertEquals(validationMessage, Constants.VALIDATION_MESSAGE, "Wrong Validation");
    }

    @Test
    public void test_login_with_invalid_credentials(){
        //act
        String url = loginPage
                .login(Constants.USERNAME_INVALID, Constants.PASSWORD_INVALID)
                .getCurrentPageURL();

        //assert
        Assert.assertEquals(url, Constants.LOGINPAGE_URL, "Wrong URL Found");
    }

}
