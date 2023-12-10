package com.demoqa;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
//    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;


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
    @FindBy(how = How.XPATH, xpath = "//div[@class='main-header' and text()='Check Box']")
    WebElement mainHeaderCheckBox;
    @FindBy(how = How.XPATH, xpath = "//span[@class='rct-checkbox' and //span[text()='Home']]")
    WebElement homeCheckBox;

    @FindBy(how = How.ID, id = "result")
    WebElement resultCheckBox;
    @FindBy(how = How.XPATH, xpath = "//button[@title='Expand all']")
    WebElement expandAllCheckBox;

    @FindBy(how = How.XPATH, xpath = "//button[@title='Collapse all']")
    WebElement collapseAllCheckBox;

    @FindBy(how = How.ID, id = "tree-node")
    WebElement treeNode;

    @FindBy(how = How.XPATH, xpath = "//button[@title='Toggle']")
    WebElement toggleButton;

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
//        Actions actions = new Actions(chromeDriver);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
        //hahahah
        submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.sendKeys(Keys.ARROW_DOWN);
        submitButton.sendKeys(Keys.ARROW_DOWN);
        String outputResultText = outputResult.getText();
        System.out.println(outputResultText);
        return outputResultText;
    }

    public void expandAllCheckBox() {
        expandAllCheckBox.click();
    }

    public void collapseAllCheckBox() {
        collapseAllCheckBox.click();
    }


}
