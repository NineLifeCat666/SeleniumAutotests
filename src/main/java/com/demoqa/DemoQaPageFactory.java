package com.demoqa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class DemoQaPageFactory {


    protected ChromeDriver chromeDriver;

    public DemoQaPageFactory(ChromeDriver chromeDriver) {
        this.chromeDriver = chromeDriver;

    }

    public DemoQaPageFactory() {
    }

    //Почему он всегда null?
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;


    @FindBy(how = How.ID, id = "userName")
    WebElement fullName;

    @FindBy(how = How.ID, id = "userEmail")
    WebElement userEmail;

    @FindBy(how = How.ID, id = "currentAddress")
    WebElement currentAddress;
    @FindBy(how = How.ID, id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(how= How.ID, id = "submit")
    WebElement submitButton;
    @FindBy(how = How.ID, id = "output")
    WebElement outputResult;

    public void fillTextBox(String name, String email, String curAddress, String perAddress) {
        fullName.click();
        fullName.sendKeys(name);
        userEmail.click();
        userEmail.sendKeys(email);
        currentAddress.click();
        currentAddress.sendKeys(curAddress);
        permanentAddress.click();
        permanentAddress.sendKeys(perAddress);
        submitButton.click();

    }


    public String showOutputResult() {
//        int deltaY = outputResult.getRect().y;
//        new Actions(chromeDriver)
//                .scrollByAmount(0, deltaY)
//                .perform();
//        js.executeScript("arguments[0].scrollIntoView();", outputResult);
        Actions actions = new Actions(chromeDriver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        String outputResultText = outputResult.getText();
        System.out.println(outputResultText);
        return outputResultText;
    }



}
