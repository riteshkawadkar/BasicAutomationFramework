package objects.fragments;

import base.BasePage;
import objects.pages.LoginPage;
import org.openqa.selenium.By;

public class Header extends BasePage {

    private By img_logo = By.xpath("//*[@class='logo']//img");
    private By button_toggler = By.xpath("//button[contains(@class, 'logout')]");
    private By button_logout = By.xpath("//li[contains(@class, 'logout')]");

    public LoginPage logout(){
        if(exists(button_toggler))
            wait_click(button_toggler);

        wait_click(button_logout);
        return new LoginPage();
    }
}
