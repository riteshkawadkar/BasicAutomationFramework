package functional;

import base.BaseTest;
import data.Constants;
import data.TestHelpers;
import exceptions.PatientNotFoundException;
import managers.ApplicationLogManager;
import objects.pages.FindPatientPage;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import objects.pages.PatientPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GenericFunctions;

import java.util.HashMap;
import java.util.Map;

public class ViewPatientTest  extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    PatientPage patientPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        patientPage = new PatientPage();
    }


    @Test
    public void test_register_and_view_patient_details() throws PatientNotFoundException {

        //act
        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        //act
        String patientID = loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .register_patient()
                .register(map)
                .getPatientId();

        ApplicationLogManager.info("PatientID - " + patientID);

        //View Patient
//        Map<String, String> actualPatientDetails = homePage
//                .gotToHome()
//                .findPatient()
//                .findByIdentifier(patientID)
//                .selectPatient(patientID)
//                .getPatientDetails();

        Map<String, String> actualPatientDetails = patientPage
                                                    .getPatientDetails();


        ApplicationLogManager.info("Actual Patient Details - " + actualPatientDetails.toString());


        //Expected Details - MAP
        Map<String, String> expectedPatientDetails = new HashMap<>();
        expectedPatientDetails.put("GIVEN", map.get("GIVEN"));
        expectedPatientDetails.put("FAMILYNAME", map.get("FAMILYNAME"));
        expectedPatientDetails.put("GENDER", map.get("GENDER"));
        expectedPatientDetails.put("ID", patientID);
        expectedPatientDetails.put("FULLNAME", map.get("GIVEN") + " " + map.get("FAMILYNAME"));

        ApplicationLogManager.info("Expected Patient Details - " + expectedPatientDetails.toString());

        //assert

        Assert.assertTrue(GenericFunctions
                        .compareMap(actualPatientDetails, expectedPatientDetails),
                "Patient Details does not match");



    }



}
