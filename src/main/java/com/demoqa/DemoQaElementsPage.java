package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaElementsPage extends DemoQaMainPage {
    protected WebElement mainHeadElements;
    public DemoQaElementsPage(WebDriver chromeDriver) {
        super(chromeDriver);
        this.mainHeadElements = chromeDriver.findElement(By.xpath("//div[@class='main-header']"));
    }

    public void checkMainHeader() {
        String mainPageHeader = mainHeadElements.getText();
    }


}
