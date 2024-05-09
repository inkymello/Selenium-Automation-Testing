package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class checkout extends Main {
    private String itemTitleText;

    @Test(priority = 6)
    public void getName() {
        try {
            // Locate the title of the element by class name
            WebElement firstphoneName = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle > span.ux-textspans--BOLD"));

            // Get the text of the title element
            String name = firstphoneName.getText();

            // Print the name of the first phone to the console
            System.out.println("Name of the first phone is : " + name);
        } catch (Exception e) {
            System.out.println("Failed to get name: " + e.getMessage());
        }
    }

    @Test(priority = 7)
    public void getPrice() {
        try {
            // Locate the title element by class name
            WebElement firstphonePrice = driver.findElement(By.cssSelector("div.x-price-primary > span.ux-textspans"));

            // Get the text of the title element
            String price = firstphonePrice.getText();

            // Print the title to the console
            System.out.println("Price of the first phone is : " + price);
        } catch (Exception e) {
            System.out.println("Failed to get price: " + e.getMessage());
        }
    }


    @Test( priority = 9)
    public void setPlug() {
        try {
            WebElement selectPlug = driver.findElement(By.id("x-msku__select-box-1000"));
            Select selectBoxLable = new Select(selectPlug);
            selectBoxLable.selectByIndex(1);
        } catch (Exception var3) {
            System.out.println("plug option is not available");
        }

    }

    @Test(
            priority = 10
    )
    public void setColor() {
        try {
            WebElement selectColor = driver.findElement(By.id("x-msku__select-box-1001"));
            Select selectBoxLable = new Select(selectColor);
            selectBoxLable.selectByIndex(1);
        } catch (Exception f) {
            System.out.println("Color delection is not available");
        }

    }


    @Test(priority = 11)
    public void addCart() {
        // Locate the "Add to cart" button element using data-testid attribute
        WebElement addToCartButton = driver.findElement(By.cssSelector("div[data-testid='x-atc-action'] a[data-testid='ux-call-to-action']"));

        // Click on the "Add to cart" button
        addToCartButton.click();
    }
    @Test(priority = 12)
    public void itemAssertiveness() {
        try {
            // Retrieve the item details from the shopping cart
            WebElement itemNameElement = driver.findElement(By.xpath("//div[@class='cart-item']/div[@class='item-name']"));
            String cartItemName = itemNameElement.getText();

            WebElement itemPriceElement = driver.findElement(By.xpath("//div[@class='cart-item']/div[@class='item-price']"));
            String cartItemPrice = itemPriceElement.getText();

            WebElement itemQuantityElement = driver.findElement(By.xpath("//div[@class='cart-item']/div[@class='item-quantity']"));
            String cartItemQuantity = itemQuantityElement.getText();

            // Assert that the cart's item details match those previously retrieved
            String previouslyRetrievedItemName = null;
            Assert.assertEquals(cartItemName, previouslyRetrievedItemName);
            String previouslyRetrievedItemPrice = null;
            Assert.assertEquals(cartItemPrice, previouslyRetrievedItemPrice);
            String previouslyRetrievedItemQuantity = null;
            Assert.assertEquals(cartItemQuantity, previouslyRetrievedItemQuantity);

            // Print success message
            System.out.println("Cart item details match the previously retrieved details.");
        } catch (Exception e) {
            System.out.println("Failed to verify cart details: " + e.getMessage());
        }
    }
    @Test(priority = 13)
    public void getCheckTitle() {
        try {
            // Locate the title element by class name
            WebElement titleElement = driver.findElement(By.cssSelector("h3.item-title a"));

            // Get the text of the title element
            String title = titleElement.getText();

            // Print the title to the console
            System.out.println("CheckOut Title: " + title);
        } catch (Exception e) {
            System.out.println("Failed to get title: " + e.getMessage());
        }
    }

    @Test(priority = 14)
    public void getCheckPrice() {
        try {
            // Locate the title element by class name
            WebElement priceElement = driver.findElement(By.cssSelector("div.item-price"));

            // Get the text of the title element
            String price = priceElement.getText();

            // Print the title to the console
            System.out.println("CheckOut Price: " + price);
        } catch (Exception e) {
            System.out.println("Failed to get price: " + e.getMessage());
        }
    }
    @Test(priority = 15)
    public void Checkout() {
        // Locate the "Go to checkout" button element using data-test-id attribute
        WebElement checkoutButton = driver.findElement(By.cssSelector("button[data-test-id='cta-top']"));

        // Click on the "Go to checkout" button
        checkoutButton.click();
    }


    @Test(priority = 16)
    public void AsGuest() {
        // Wait for the "Continue as guest" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueAsGuestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='gxo-btn']")));

// Click on the "Continue as guest" button
        continueAsGuestButton.click();
    }

    @AfterTest
    public void quite() {
        driver.quit();
    }
}
