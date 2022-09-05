package base;

import factories.DriverFactory;
import managers.ApplicationLogManager;
import objects.fragments.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver = DriverFactory.getTlDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public String getCurrentPageURL()
    {
        return driver.getCurrentUrl();
    }

    public Header getheader(){
        ApplicationLogManager.info("Accessing Header");
        return new Header();
    }

    protected WebElement get_webelement(By identifier){
        ApplicationLogManager.info("Trying to find element using identifier - " + identifier);

        return wait
                .until(ExpectedConditions.elementToBeClickable(identifier));
    }

    protected boolean exists(By identifier){
        ApplicationLogManager.info("Trying to check if element exists on page using identifier - " + identifier);

        return driver.findElements(identifier).size()>0?true:false;
    }

    protected String wait_getText(By identifier){
        ApplicationLogManager.info("Trying to get text from web element using identifier - " + identifier);

        return get_webelement(identifier)
                .getText();
    }
    protected void wait_sendkeys(By identifier, String value){
        ApplicationLogManager.info("Trying to send text to web element using identifier - " + identifier);

        get_webelement(identifier)
                .sendKeys(value);
    }

    protected void wait_click(By identifier){
        ApplicationLogManager.info("Trying to click on web element using identifier - " + identifier);

        get_webelement(identifier)
                .click();
    }

    protected void select(By identifier, int index){
        ApplicationLogManager.info("Trying to select web element using identifier - " + identifier);

        Select dropdown  = new Select(get_webelement(identifier));
        dropdown.getOptions().get(index).click();

    }
}
