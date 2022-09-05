package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AddAttachmentPage extends BasePage {

    private final By FILE_DROP_ZONE = By.id("visit-documents-dropzone");
    private final By FILE_CONTAINER = By.xpath("//div[@class='att_thumbnails-container']//att-thumbnail");
    private final By TEXT_CAPTION = By.xpath("//textarea[@ng-model='typedText.fileCaption']");
    private final By BUTTON_UPLOAD = By.xpath("//div[contains(@class,'att_upload-element')]//button[contains(@class,'confirm')]");
    private final By FILE_PREVIEW = By.xpath("//div[contains(@class,'dz-file-preview')]");


    public AddAttachmentPage addAttachment(String fileName, String caption) throws AWTException {
        waitClick(FILE_DROP_ZONE);

        StringSelection ss = new StringSelection(fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


        waitSendKeys(TEXT_CAPTION, caption);
        waitUntilVisible(FILE_PREVIEW);
        waitClick(BUTTON_UPLOAD);

        return this;
    }

    public int getAttachmentCount(){
        waitUntilVisible(FILE_CONTAINER);
        return driver.findElements(FILE_CONTAINER).size();
    }

}
