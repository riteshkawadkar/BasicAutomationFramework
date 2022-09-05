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

    protected WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public String getCurrentPageURL()
    {
        return driver.getCurrentUrl();
    }

    public Header getHeader(){
        ApplicationLogManager.info("Accessing Header");
        return new Header();
    }

    protected WebElement getWebElement(By identifier){
        ApplicationLogManager.info("Trying to find element using identifier - " + identifier);

        return wait
                .until(ExpectedConditions.elementToBeClickable(identifier));
    }

    protected WebElement waitUntilVisible(By identifier){

        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(identifier));
    }

    protected boolean waitForTextChangeProperty(By identifier, String value){

        return wait
                .until(ExpectedConditions.textToBePresentInElementLocated(identifier, value));
    }

    protected boolean exists(By identifier){
        return driver.findElements(identifier).size()>0?true:false;
    }

    protected String waitGetText(By identifier){
        return getWebElement(identifier)
                .getText();
    }
    protected void waitSendKeys(By identifier, String value){
        getWebElement(identifier)
                .sendKeys(value);
    }

    protected void waitClick(By identifier){
        getWebElement(identifier)
                .click();
    }

    protected void select(By identifier, int index){
        Select dropdown  = new Select(getWebElement(identifier));
        dropdown.getOptions().get(index).click();

    }

    protected void select(By identifier, String value){
        ApplicationLogManager.info("Trying to select web element using identifier - " + identifier);

        Select dropdown  = new Select(getWebElement(identifier));
        dropdown.selectByVisibleText(value);

    }
}
