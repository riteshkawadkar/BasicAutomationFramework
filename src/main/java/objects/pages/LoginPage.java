package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By TEXT_USERNAME = By.id("username");
    private final By TEXT_PASSWORD = By.id("password");
    private final By LIST_INPATIENT_WARD = By.id("Inpatient Ward");
    private final By BUTTON_LOGIN = By.id("loginButton");


    public HomePage login(String username, String password) {
        waitSendKeys(TEXT_USERNAME, username);
        waitSendKeys(TEXT_PASSWORD, password);
        waitClick(LIST_INPATIENT_WARD);
        waitClick(BUTTON_LOGIN);
        return new HomePage();
    }

}
