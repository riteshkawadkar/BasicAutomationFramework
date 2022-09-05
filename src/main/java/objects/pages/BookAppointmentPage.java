package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class BookAppointmentPage extends BasePage {

    private final By TEXT_APPOINTMENT_TYPE = By.id("appointment-type");
    private final By DROPDOWN_APPOINTMENT_TYPE = By.xpath("//ul[contains(@class, 'dropdown-menu')]/li[1]");
    private final By TEXT_NOTES = By.id("notes");
    private final By BUTTON_SAVE = By.id("save-button");

    public PatientPage bookAppointment(String appointmentType, String notes){
        waitSendKeys(TEXT_APPOINTMENT_TYPE, appointmentType);
        waitClick(DROPDOWN_APPOINTMENT_TYPE);
        waitSendKeys(TEXT_NOTES, notes);
        waitClick(BUTTON_SAVE);
        return new PatientPage();
    }


}
