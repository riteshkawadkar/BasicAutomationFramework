package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class PatientPage extends BasePage {
    private By label_givenName = By.className("PersonName-givenName");
    private By label_familyName = By.className("PersonName-familyName");
    private By link_attachment = By.id("attachments.attachments.overallActions.default");
    private By link_deletePatient = By.id("org.openmrs.module.coreapps.deletePatient");
    private By text_deleteReason = By.id("delete-reason");
    private By button_confirmDelete = By.className("confirm right");
    private By label_patientID = By.xpath("//div[contains(@class, 'identifiers')]//span");

    public String get_patient_id(){
        return get_webelement(label_patientID).getText();
    }

    public AddAttachmentPage addAttachment(){
        wait_click(link_attachment);
        return new AddAttachmentPage();
    }

    public PatientPage delete(){
        wait_click(link_deletePatient);
        wait_sendkeys(text_deleteReason, "reason");
        wait_click(button_confirmDelete);
        return this;
    }
}
