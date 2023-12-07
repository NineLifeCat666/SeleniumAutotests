package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DemoQaMainPage {
  protected WebDriver chromeDriver;
  protected WebElement elementsBlock;

    public DemoQaMainPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.elementsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Elements']"));
    }

    public void clickOnElements() {
        int deltaY = elementsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        elementsBlock.click();
    }
}
