package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.Map;

public class RegisterPatientPage extends BasePage {

    private final By TEXT_GIVEN_NAME = By.name("givenName");
    private final By TEXT_FAMILY_NAME = By.name("familyName");
    private final By BUTTON_NEXT = By.id("next-button");
    private final By DROPDOWN_GENDER = By.id("gender-field");
    private final By TEXT_BIRTHDATE = By.id("birthdateDay-field");
    private final By DROPDOWN_BIRTH_MONTH = By.id("birthdateMonth-field");
    private final By TEXT_BIRTH_YEAR = By.id("birthdateYear-field");
    private final By TEXT_ADDRESS1 = By.id("address1");
    private final By TEXT_ADDRESS2 = By.id("address2");
    private final By TEXT_CITY = By.id("cityVillage");
    private final By TEXT_STATE = By.id("stateProvince");
    private final By TEXT_COUNTRY = By.id("country");
    private final By TEXT_POSTAL_CODE = By.id("postalCode");
    private final By TEXT_PHONE_NUMBER = By.name("phoneNumber");
    private final By DROPDOWN_RELATIONSHIP_TYPE = By.id("relationship_type");
    private final By TEXT_RELATIONSHIP_PERSON = By.xpath("//input[@ng-model='relationship.name']");
    private final By BUTTON_CONFIRM = By.id("submit");

    public PatientPage register(Map<String, String> map){

        waitSendKeys(TEXT_GIVEN_NAME, map.get("GIVEN"));
        waitSendKeys(TEXT_FAMILY_NAME, map.get("FAMILYNAME"));

            next();
        select(DROPDOWN_GENDER, map.get("GENDER"));
            next();
        waitSendKeys(TEXT_BIRTHDATE, map.get("BIRTHDATE"));
        select(DROPDOWN_BIRTH_MONTH, Integer.parseInt(map.get("BIRTHMONTH")));
        waitSendKeys(TEXT_BIRTH_YEAR, map.get("BIRTHYEAR"));
            next();
        waitSendKeys(TEXT_ADDRESS1, map.get("ADDRESS1"));
        waitSendKeys(TEXT_ADDRESS2, map.get("ADDRESS2"));
        waitSendKeys(TEXT_CITY, map.get("CITY"));
        waitSendKeys(TEXT_STATE, map.get("STATE"));
        waitSendKeys(TEXT_COUNTRY, map.get("COUNTRY"));
        waitSendKeys(TEXT_POSTAL_CODE, map.get("POSTALCODE"));
            next();
        waitSendKeys(TEXT_PHONE_NUMBER, map.get("PHONE"));
            next();
        select(DROPDOWN_RELATIONSHIP_TYPE, map.get("RELATIONSHIPTYPE"));
        waitSendKeys(TEXT_RELATIONSHIP_PERSON, map.get("RELATIONSHIPPERSON"));
            next();
        waitClick(BUTTON_CONFIRM);

        return new PatientPage();
    }

    public RegisterPatientPage next(){
        waitClick(BUTTON_NEXT);
        return this;
    }


}
