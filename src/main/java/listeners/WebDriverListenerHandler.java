package listeners;

import managers.ApplicationLogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WebDriverListenerHandler implements WebDriverListener {

    // TODO: Implement all the methods

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        ApplicationLogManager.info("Sending string -" + Arrays.stream(keysToSend).collect(Collectors.joining()) + " to WebElement -" + element.getAccessibleName() );
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        ApplicationLogManager.info("String on Element is " + Arrays.stream(keysToSend).collect(Collectors.joining()) );
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        if(result instanceof WebElement)
            ApplicationLogManager.info("Found element - " + result.getAccessibleName());
        else
            ApplicationLogManager.error("Element not found by locator - " + locator.toString());
    }

    @Override
    public void beforeClick(WebElement element) {
        ApplicationLogManager.info("Clicking On -" + element.getAccessibleName() );
    }

    @Override
    public void afterClick(WebElement element) {
        ApplicationLogManager.info("Clicked On -" + element.getAccessibleName() );

    }


}
