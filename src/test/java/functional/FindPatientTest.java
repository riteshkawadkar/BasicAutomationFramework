package functional;

import base.BaseTest;
import data.Constants;
import data.TestHelpers;
import exceptions.PatientNotFoundException;
import managers.ApplicationLogManager;
import objects.pages.FindPatientPage;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class FindPatientTest  extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    FindPatientPage findPatientPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        findPatientPage = new FindPatientPage();
    }


    @Test
    public void test_search_patient_with_identifier() throws PatientNotFoundException {

        //act
        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        String pID = loginPage
                        .login(Constants.USERNAME, Constants.PASSWORD)
                        .register_patient()
                        .register(map)
                        .getPatientId();

        String patientID = loginPage
                            .login(Constants.USERNAME, Constants.PASSWORD)
                            .findPatient()
                            .findByIdentifier(pID)
                            .selectPatient(pID)
                            .getPatientId();

        ApplicationLogManager.info("PatientID - " + patientID);
        //assert
        Assert.assertEquals(patientID, pID,
                "Patient Not Found");
    }

    @Test(expectedExceptions = PatientNotFoundException.class)
    public void test_search_patient_with_incorrect_identifier() throws PatientNotFoundException {

        //act
        loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .findPatient()
                .findByIdentifier(Constants.InCorrectPatientIdentifier);


    }
}
