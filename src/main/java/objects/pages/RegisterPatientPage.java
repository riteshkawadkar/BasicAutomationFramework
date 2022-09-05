package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class RegisterPatientPage extends BasePage {

    private By text_givenName = By.name("givenName");
    private By text_familyName = By.name("familyName");
    private By button_next = By.id("next-button");
    private By dropdown_gender = By.id("gender-field");
    private By text_birthdateDay = By.id("birthdateDay-field");
    private By dropdown_genderbirthdateMonth = By.id("birthdateMonth-field");
    private By text_birthdateYear = By.id("birthdateYear-field");
    private By text_address1 = By.id("address1");
    private By text_address2 = By.id("address2");
    private By text_cityVillage = By.id("cityVillage");
    private By text_stateProvince = By.id("stateProvince");
    private By text_country = By.id("country");
    private By text_postalCode = By.id("postalCode");
    private By text_phoneNumber = By.name("phoneNumber");
    private By dropdown_gender_relationship_type = By.id("relationship_type");
    private By text_relationship_name = By.xpath("//input[@ng-model='relationship.name']");
    private By button_confirm = By.id("submit");
    private By button_cancelSubmission = By.id("cancelSubmission");

    public PatientPage register(){
        addName();
        next();
        addGender();
        next();
        addBirthDate();
        next();
        addAddress();
        next();
        addPhone();
        next();
        addRelatives();
        next();
        confirm();
        return new PatientPage();
    }

    public RegisterPatientPage next(){
        wait_click(button_next);
        return this;
    }

    public RegisterPatientPage addName(){
        wait_sendkeys(text_givenName, "givenName");
        wait_sendkeys(text_familyName, "family");
        return this;
    }

    public RegisterPatientPage addGender(){
        select(dropdown_gender, 0);
        return this;
    }

    public RegisterPatientPage addBirthDate(){
        wait_sendkeys(text_birthdateDay, "10");
        select(dropdown_genderbirthdateMonth, 0);
        wait_sendkeys(text_birthdateYear, "1988");
        return this;
    }

    public RegisterPatientPage addAddress(){
        wait_sendkeys(text_address1, "10");
        wait_sendkeys(text_address2, "10");
        wait_sendkeys(text_cityVillage, "10");
        wait_sendkeys(text_stateProvince, "10");
        wait_sendkeys(text_country, "10");
        wait_sendkeys(text_postalCode, "10");
        return this;
    }

    public RegisterPatientPage addPhone(){
        wait_sendkeys(text_phoneNumber, "8390555057");
        return this;
    }

    public RegisterPatientPage addRelatives(){
        select(dropdown_gender_relationship_type, 0);
        wait_sendkeys(text_relationship_name, "asdasd");
        return this;
    }

    public PatientPage confirm(){
        wait_click(button_confirm);
        return new PatientPage();
    }

    public RegisterPatientPage cancel(){
        wait_click(button_cancelSubmission);
        return this;
    }
}
