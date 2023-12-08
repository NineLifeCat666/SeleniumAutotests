package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaTextBoxPage {
    protected WebElement fullName;
    protected WebElement email;
    protected WebElement currentAddress;
    protected WebElement permanentAddress;
    protected WebElement submitButton;
    protected WebElement outputInfo;
    protected WebDriver chromeDriver;


    public DemoQaTextBoxPage(WebDriver chromeDriver) {
    this.chromeDriver = chromeDriver;
    this.fullName =chromeDriver.findElement(By.id("userName"));
    this.email = chromeDriver.findElement(By.id("userEmail"));
    this.currentAddress = chromeDriver.findElement(By.id("currentAddress"));
    this.permanentAddress = chromeDriver.findElement(By.id("permanentAddress"));
    this.submitButton = chromeDriver.findElement(By.id("submit"));
    this.outputInfo = chromeDriver.findElement(By.id("output"));

    }

    public void fillTextBoxForm(String name, String userEmail, String curAddress, String permAddress) {
        fullName.click();
        fullName.sendKeys(name);
        email.click();
        email.sendKeys(userEmail);
        currentAddress.click();
        currentAddress.sendKeys(curAddress);
        permanentAddress.click();
        permanentAddress.sendKeys(permAddress);
        submitButton.click();
    }
//Дописать метод который вовзращает строки по outpoot
    public void checkOutputInfo () {
        outputInfo.getText();
        System.out.println(outputInfo);
    }
}
