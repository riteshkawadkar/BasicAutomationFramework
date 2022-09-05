package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By edit_username = By.id("username");
    private By edit_password = By.id("password");
    private By select_location = By.id("Inpatient Ward");
    private By button_login = By.id("loginButton");


    public HomePage login(String username, String password, String location) {
        wait_sendkeys(edit_username, username);
        wait_sendkeys(edit_password, password);
        wait_sendkeys(select_location, location);
        wait_click(button_login);
        return new HomePage();
    }

}
