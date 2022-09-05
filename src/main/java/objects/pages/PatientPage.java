package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class PatientPage extends BasePage {

    private final By LABEL_GIVEN_NAME = By.className("PersonName-givenName");
    private final By LABEL_FAMILY_NAME = By.className("PersonName-familyName");
    private final By BREADCRUMBS_FULLNAME= By.xpath("//ul[@id='breadcrumbs']//li[2]");
    private final By LABEL_GENDER= By.xpath("//div[contains(@class, 'gender-age')]//span");

    private final By LINK_ATTACHMENT = By.id("attachments.attachments.overallActions.default");
    private final By LINK_DELETE_PATIENT = By.id("org.openmrs.module.coreapps.deletePatient");
    private final By TEXT_DELETE_REASON = By.id("delete-reason");
    private final By LINK_REQUEST_APPOINTMENT = By.id("appointmentschedulingui.requestAppointmentDashboardLink");
    private final By LINK_START_VISIT = By.id("org.openmrs.module.coreapps.createVisit");
    private final By BUTTON_CONFIRM_DELETE = By.xpath("//div[@id='delete-patient-creation-dialog']//button[contains(@class, 'confirm')]");
    private final By BUTTON_CONFIRM_VISIT = By.xpath("//div[@id='quick-visit-creation-dialog']//button[contains(@class, 'confirm')]");
    private final By LABEL_PATIENT_ID = By.xpath("//div[contains(@class, 'identifiers')]//span");
    private final By LIST_APPOINTMENT_REQUESTS = By.xpath("//ul[@id='miniPatientAppointmentRequests']//li[last()]");

    public PatientPage(){
        exists(LABEL_GIVEN_NAME);
    }

    public String getPatientId(){
        return waitGetText(LABEL_PATIENT_ID);
    }

    public AddAttachmentPage goToAddAttachmentPage(){
        waitClick(LINK_ATTACHMENT);
        return new AddAttachmentPage();
    }

    public VisitPage goToStartVisitPage(){
        waitClick(LINK_START_VISIT);
        waitClick(BUTTON_CONFIRM_VISIT);
        return new VisitPage();
    }

    public BookAppointmentPage goToRequestAppointmentPage(){
        waitClick(LINK_REQUEST_APPOINTMENT);
        return new BookAppointmentPage();
    }

    public String getAppointmentRequest(){
        return waitGetText(LIST_APPOINTMENT_REQUESTS);
    }

    public FindPatientPage deletePatient(String reason){
        waitClick(LINK_DELETE_PATIENT);
        waitSendKeys(TEXT_DELETE_REASON, reason);
        waitClick(BUTTON_CONFIRM_DELETE);
        return new FindPatientPage();
    }

    public Map getPatientDetails(){
        Map<String, String> details = new HashMap<>();
        details.put("GIVEN", waitGetText(LABEL_GIVEN_NAME).trim());
        details.put("FAMILYNAME", waitGetText(LABEL_FAMILY_NAME).trim());
        details.put("FULLNAME", waitGetText(BREADCRUMBS_FULLNAME).trim());
        details.put("GENDER", waitGetText(LABEL_GENDER).trim());
        details.put("ID", waitGetText(LABEL_PATIENT_ID).trim());
        return details;
    }
}
