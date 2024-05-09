package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Iterator;

public class select_phone extends Main{

    @Test(priority = 1)
    @Parameters({"url",})

    public void navigateUrl(String url){
        driver.get(url);
    }

    @Test(priority = 2)
    @Parameters({"url",})
    public void verifyUrl(String url){
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(priority = 3)
    public void dropDownSelection(){
        // Find the category dropdown menu and select "Cell Phones & Accessories"
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText("Cell Phones & Accessories");

        // Verify the correct category selected
        WebElement selectedCategory = select.getFirstSelectedOption();
        String selectedCategoryText = selectedCategory.getText();
        Assert.assertEquals("Cell Phones & Accessories", selectedCategoryText);
        System.out.println("verified url successfully");
    }

    @Test(priority = 4)
    public void searchMobilePhone(){
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys( "Mobile phone");
        driver.findElement(By.id("gh-btn")).click();
    }

    @Test(priority = 5)
    public void selectFirstPhone() throws InterruptedException {
        WebElement firstPhone = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/div/span"));
        firstPhone.click();
        Thread.sleep(5000L);
        Iterator element = driver.getWindowHandles().iterator();

        while(element.hasNext()) {
            String windowHandle = (String)element.next();
            driver.switchTo().window(windowHandle);
        }

    }


}
