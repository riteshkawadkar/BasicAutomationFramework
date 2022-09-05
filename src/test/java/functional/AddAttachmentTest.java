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

import java.awt.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AddAttachmentTest  extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    PatientPage patientPage;
    FindPatientPage findPatientPage;
    VisitPage visitPage;

    @BeforeMethod
    public void initialize_pages(){
        //assign
        loginPage = new LoginPage();
        homePage = new HomePage();
        patientPage = new PatientPage();
        findPatientPage = new FindPatientPage();
        visitPage = new VisitPage();
    }

    @Test
    public void test_adding_attachment() throws AWTException {

        //register patient
        Map<String, String> map = TestHelpers.registerAPatient();

        //act
        int count = loginPage
                        .login(Constants.USERNAME, Constants.PASSWORD)
                        .register_patient()
                        .register(map)
                        .goToStartVisitPage()
                        .goToAddAttachmentPage()
                        .addAttachment(Constants.ATTACHMENT_PATH, Constants.NOTES)
                        .getAttachmentCount();



        //assert
        Assert.assertEquals(count,1,
                "File not uploaded");


    }
}
