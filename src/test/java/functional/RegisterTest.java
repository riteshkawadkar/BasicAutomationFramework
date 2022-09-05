package functional;

import base.BaseTest;
import data.Constants;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import objects.pages.RegisterPatientPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest  extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    RegisterPatientPage registerPatientPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPatientPage = new RegisterPatientPage();
    }


    @Test
    public void test_successful_patient_registration(){

        //act
        String url = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD, Constants.LOCATION)
                        .register_patient()
                                .register()
                                .getCurrentPageURL();

        //assert
        Assert.assertTrue(url.contains(Constants.PATIENTPAGE_URL)
                ,"Wrong URL Found");
    }
}
