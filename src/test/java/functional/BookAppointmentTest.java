package functional;

import base.BaseTest;
import data.Constants;
import data.TestHelpers;
import exceptions.PatientNotFoundException;
import managers.ApplicationLogManager;
import objects.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class BookAppointmentTest  extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    PatientPage patientPage;
    BookAppointmentPage bookAppointmentPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        patientPage = new PatientPage();
        bookAppointmentPage= new BookAppointmentPage();
    }

    @Test
    public void test_appointment_booking() throws PatientNotFoundException {

        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        //act
        loginPage
                .login(Constants.USERNAME, Constants.PASSWORD)
                .register_patient()
                .register(map)
                .goToRequestAppointmentPage()
                .bookAppointment(Constants.APPOINTMENT_TYPE, Constants.NOTES);

        String requestName = patientPage
                            .getAppointmentRequest();

        ApplicationLogManager.info("Request Name - " + requestName);


        //assert

        Assert.assertTrue(requestName.contains(Constants.APPOINTMENT_TYPE),
                "Appoint Request Not Found");



    }
}
