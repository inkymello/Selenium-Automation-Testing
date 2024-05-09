package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    protected static WebDriver driver;
    @BeforeTest
    public void setUp (){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

}