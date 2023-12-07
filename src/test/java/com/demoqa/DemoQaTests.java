package com.demoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DemoQaTests extends BaseTest {

    @Test
    public void firstTestTitle() {
        chromeDriver.get("https://demoqa.com/");
        String title = chromeDriver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.contains("DEMOQA"), "Тайтл" + title + "на сайте не содержит  DEMOQA");
    }

    @Test
    public void secondTestClickElements() {
        chromeDriver.get("https://demoqa.com");
        WebElement elementsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Elements']"));
        int deltaY = elementsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        elementsBlock.click();
        WebElement textBoxMenu = chromeDriver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxMenu.click();
        WebElement userNameField = chromeDriver.findElement(By.id("userName"));
        userNameField.sendKeys("Evangelion!");
        WebElement userEmail = chromeDriver.findElement(By.id("userEmail"));
        userEmail.sendKeys("jora@mail.com");
        WebElement currentAddress = chromeDriver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Groove street");
        WebElement permanentAddress = chromeDriver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Groove street 69 state");

    }

    @Test
    public void mainPageTestWithPO() {
    chromeDriver.get("https://demoqa.com");
    DemoQaMainPage demoQaMainPage = new DemoQaMainPage(chromeDriver);
    demoQaMainPage.clickOnElements();
    }

}
