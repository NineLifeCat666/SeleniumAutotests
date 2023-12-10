package com.demoqa;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

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
    Assertions.assertTrue(demoQaMainPage.showElements().contains("Elements"), "Блок Элементы не содержит текст - Elements");
    Assertions.assertTrue(demoQaMainPage.showForms().contains("Forms"), "Блок Форма не содержит текст - Forms");
    Assertions.assertTrue(demoQaMainPage.showAlertsAndWindows().contains("Alerts, Frame & Windows"), "Блок Алерты не содержит текст - Alerts, Frame & Windows");
    Assertions.assertTrue(demoQaMainPage.showWidgets().contains("Widgets"), "Блок Виджеты не содержит текст - Widgets");
    Assertions.assertTrue(demoQaMainPage.showInteractions().contains("Interactions"), "Блок Интеракшн не содержит текст - Interactions");
    Assertions.assertTrue(demoQaMainPage.showBookApp().contains("Book Store Application"), "Блок Букс не содержит текст - Book Store Application");

    }

    @Test
    public void textBoxPageTest() {
        chromeDriver.get("https://demoqa.com/text-box");
        DemoQaTextBoxPage demoQaTextBoxPage = new DemoQaTextBoxPage(chromeDriver);
        demoQaTextBoxPage.fillTextBoxForm("Eugene", "mahanada@yandex.ru",
                "Groove street", "Sheesh street");
    }

    //Пример параметризированного теста с заполнением данных в коде
    @Feature("Текстовая форма")
    @DisplayName("Тест на заполнение TextBox1")
    @ParameterizedTest
    @CsvSource({"pua,pua,lu@mail.com,lu@mail.com, heo,heo, dwwq,dwwq"})
    public void textBoxTest(String name, String resultName, String email, String resultEmail, String curAddress,
                            String resultCurAddress, String perAddress, String resultPermAddress) {
    chromeDriver.get("https://demoqa.com/text-box");
    DemoQaPageFactory demoQaPageFactory = PageFactory.initElements(chromeDriver, DemoQaPageFactory.class);
    demoQaPageFactory.fillTextBox(name,email,curAddress,perAddress);
    demoQaPageFactory.showOutputResult();
    Assertions.assertTrue(demoQaPageFactory.showOutputResult().contains("Name:" + resultName +"\n" +
            "Email:" + resultEmail +"\n" +
            "Current Address :" + resultCurAddress + "\n" +
            "Permananet Address :" + resultPermAddress), "Сообщение не " +
            "содержит вышеперечисленные заполненные тестовые данные");

    }

    //Пример параметризированного теста с заполнением данных из файла
    // (похоже что комьюнити версия идеи не поддерживает работу с .CSV файлами)
    // попробовать другой плагин для работы с CSV
    @Feature("Текстовая форма")
    @DisplayName("Тест на заполнение TextBox2")
    @ParameterizedTest
    @CsvFileSource(resources = "src/test/java/com/demoqa/dataTextBox1.csv", numLinesToSkip = 0)
    public void textBoxTestWithFile(String name, String resultName, String email, String resultEmail, String curAddress,
                            String resultCurAddress, String perAddress, String resultPermAddress) {
        chromeDriver.get("https://demoqa.com/text-box");
        DemoQaPageFactory demoQaPageFactory = PageFactory.initElements(chromeDriver, DemoQaPageFactory.class);
        demoQaPageFactory.fillTextBox(name,email,curAddress,perAddress);
        demoQaPageFactory.showOutputResult();
        Assertions.assertTrue(demoQaPageFactory.showOutputResult().contains("Name:" + resultName +"\n" +
                "Email:" + resultEmail +"\n" +
                "Current Address :" + resultCurAddress + "\n" +
                "Permananet Address :" + resultPermAddress), "Сообщение не " +
                "содержит вышеперечисленные заполненные тестовые данные");

    }

    @Test
    @Feature("Чек бокс")
    @DisplayName("Проверка работы чек бокса - выбор всех элементов")
    public void checkBoxAllElementsTest() {
        chromeDriver.get("https://demoqa.com/checkbox");
        DemoQaPageFactory demoQaPageFactory = PageFactory.initElements(chromeDriver, DemoQaPageFactory.class);
        Assertions.assertTrue(demoQaPageFactory.mainHeaderCheckBox.getText().contains("Check Box"), "Главный хидер страницы не содержит слова - Check Box");
        demoQaPageFactory.homeCheckBox.click();
        demoQaPageFactory.resultCheckBox.getText().contains("You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
    }


}