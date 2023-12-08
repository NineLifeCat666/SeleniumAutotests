package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DemoQaMainPage {
  protected WebDriver chromeDriver;
  protected WebElement elementsBlock;
  protected WebElement formsBlock;

  protected WebElement alertsAndWindowsBlock;

  protected WebElement widgetsBlock;
  protected WebElement interactionsBlock;
  protected WebElement bookStoreApp;

    public DemoQaMainPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.elementsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Elements']"));
        this.formsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Forms']"));
        this.alertsAndWindowsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Alerts, Frame & Windows']"));
        this.widgetsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Widgets']"));
        this.interactionsBlock = chromeDriver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Interactions']"));
        this.bookStoreApp = chromeDriver.findElement(By.xpath("//div[@class='card-body' and contains(h5, 'Book Store Application')]"));
    }

    public String showElements() {
        int deltaY = elementsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String elementsBlockText = elementsBlock.getText();
        return elementsBlockText;
    }

    public String showForms() {
        int deltaY = formsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String formsBlockText = formsBlock.getText();
        return formsBlockText;
    }

    public String showAlertsAndWindows() {
        int deltaY = alertsAndWindowsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String alertsAndWindowsBlockText = alertsAndWindowsBlock.getText();
        return alertsAndWindowsBlockText;
    }

    public String showWidgets() {
        int deltaY = widgetsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String widgetsBlockText = widgetsBlock.getText();
        return widgetsBlockText;
    }

    public String showInteractions() {
        int deltaY = interactionsBlock.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String interactionsText = interactionsBlock.getText();
        return interactionsText;
    }

    public String showBookApp() {
        int deltaY = bookStoreApp.getRect().y;
        new Actions(chromeDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        String bookAppText = bookStoreApp.getText();
        return bookAppText;
    }
}
