package functional;

import base.BaseTest;
import data.Constants;
import data.TestHelpers;
import managers.ApplicationLogManager;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import objects.pages.RegisterPatientPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        //act
        String patientID = loginPage
                                .login(Constants.USERNAME, Constants.PASSWORD)
                                .register_patient()
                                .register(map)
                                .getPatientId();

        ApplicationLogManager.info("PatientID - " + patientID);

        //assert
        Assert.assertTrue(patientID.length()==6
                ,"Patient is not registered");
    }
}
