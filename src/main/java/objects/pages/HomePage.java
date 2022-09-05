package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By LABEL_VALIDATION_MESSAGE = By.xpath("//h4");

    private final By LINK_FIND_PATIENT = By.xpath("//div[@id='content']/*[@class='row'][3]//a[1]");
    private final By LINK_REGISTER_PATIENT = By.xpath("//div[@id='content']/*[@class='row'][3]//a[3]");
    private final By LINK_APPOINTMENT = By.xpath("//div[@id='content']/*[@class='row'][3]//a[5]");

    public String getValidationMessage(){
        return waitGetText(LABEL_VALIDATION_MESSAGE);
    }

    public RegisterPatientPage register_patient(){
        waitClick(LINK_REGISTER_PATIENT);
        return new RegisterPatientPage();
    }

    public BookAppointmentPage book_appointment(){
        waitClick(LINK_APPOINTMENT);
        return new BookAppointmentPage();
    }

    public FindPatientPage findPatient(){
        waitClick(LINK_FIND_PATIENT);
        return new FindPatientPage();
    }

    public HomePage gotToHome(){
        driver.get("https://demo.openmrs.org/openmrs/index.htm");
        return this;
    }

}
