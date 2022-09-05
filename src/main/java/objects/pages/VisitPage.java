package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;

public class VisitPage extends BasePage {

    private final By LINK_ADD_ATTACHMENT= By.id("attachments.attachments.visitActions.default");

    public AddAttachmentPage goToAddAttachmentPage(){
        waitClick(LINK_ADD_ATTACHMENT);
        return new AddAttachmentPage();
    }
}
