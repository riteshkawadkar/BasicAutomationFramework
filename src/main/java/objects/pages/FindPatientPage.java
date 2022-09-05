package objects.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindPatientPage extends BasePage {

    private By label_pageName = By.xpath("//div[@id='content']/h2");
    private By text_search = By.id("patient-search");
    private By table_row = By.xpath("//tr[@class='odd'][1]/td[1]");

    private FindPatientPage find_by_name_identifier(){
        wait_sendkeys(text_search, "Venkat");
        return this;
    }

    private FindPatientPage select_patient(){
        wait_click(table_row);
        return this;
    }


}
