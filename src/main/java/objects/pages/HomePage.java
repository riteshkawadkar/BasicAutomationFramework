package objects.pages;

import base.BasePage;
import objects.fragments.Header;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By label_validationMessage = By.xpath("//h4");

    private By link_findP = By.xpath("//div[@id='content']/*[@class='row'][3]//a[1]");
    private By link_registerP = By.xpath("//div[@id='content']/*[@class='row'][3]//a[3]");
    private By link_appointment = By.xpath("//div[@id='content']/*[@class='row'][3]//a[5]");

    public String getValidationMessage(){
        return wait_getText(label_validationMessage);
    }

    public RegisterPatientPage register_patient(){
        wait_click(link_registerP);
        return new RegisterPatientPage();
    }

    public AppointmentPage book_appointment(){
        wait_click(link_appointment);
        return new AppointmentPage();
    }

    public FindPatientPage find_patient(){
        wait_click(link_findP);
        return new FindPatientPage();
    }

}
