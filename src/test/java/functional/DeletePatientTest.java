package functional;

import base.BaseTest;
import data.Constants;
import data.TestHelpers;
import exceptions.PatientNotFoundException;
import objects.pages.FindPatientPage;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import objects.pages.PatientPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DeletePatientTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    PatientPage patientPage;
    FindPatientPage findPatientPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        patientPage = new PatientPage();
        findPatientPage = new FindPatientPage();
    }

    @Test(expectedExceptions = PatientNotFoundException.class)
    public void test_delete_patient() throws PatientNotFoundException {

        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        //act
        String patientID = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .register_patient()
                .register(map)
                .getPatientId();

        patientPage
                .deletePatient(Constants.DELETE_REASON);


        //assert
        findPatientPage
                .findByIdentifier(patientID);


    }
}
