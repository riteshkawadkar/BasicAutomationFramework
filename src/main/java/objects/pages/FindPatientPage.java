package objects.pages;

import base.BasePage;
import exceptions.PatientNotFoundException;
import managers.ApplicationLogManager;
import org.openqa.selenium.By;

public class FindPatientPage extends BasePage {

    private final By LABEL_PAGE_NAME = By.xpath("//div[@id='content']/h2");
    private final By TEXT_SEARCH = By.id("patient-search");
    private final By TABLE_ROW = By.xpath("//tr[@class='odd'][1]/td[1]");
    private final By LABEL_INFO = By.className("dataTables_info");

    public FindPatientPage findByIdentifier(String value) throws PatientNotFoundException {
        waitSendKeys(TEXT_SEARCH, value);
        try{
            waitForTextChangeProperty(LABEL_INFO, "Showing 1 to 1 of 1 entries");
        }
        catch (Exception e){
            throw new PatientNotFoundException(value);
        }
        return this;
    }

    public PatientPage selectPatient(String value) throws PatientNotFoundException {

        if(waitGetText(LABEL_INFO).equalsIgnoreCase("Showing 1 to 1 of 1 entries")) {

            String identifier = getWebElement(TABLE_ROW).getText();
            ApplicationLogManager.info("First Row - " + identifier + "Looking for value = " + value);

            if (identifier.contains(value))
                waitClick(TABLE_ROW);
            else
                throw new PatientNotFoundException(identifier);
        }
        else
            throw new PatientNotFoundException(value);

        return new PatientPage();
    }


}
