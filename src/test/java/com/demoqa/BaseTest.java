package com.demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver chromeDriver;


    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }
}
