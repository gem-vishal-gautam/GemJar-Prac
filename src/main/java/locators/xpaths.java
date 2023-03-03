package locators;

import org.openqa.selenium.By;

public class xpaths {

    public static By userName = By.xpath("//input[@id='user-name']");
    public static By password = By.xpath("//input[@id='password']");
    public static By loginBtn = By.xpath("//input[@id='login-button']");
    public static By product = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public static By addtocart_Btn = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static By shoppingCart_Btn = By.xpath("//a[@class='shopping_cart_link']");
    public static By cart_quantity = By.xpath("//div[@class='cart_quantity']");
    public static By continue_shopping_Btn = By.xpath("//button[@id='continue-shopping']");
    public static By products = By.xpath("//div[@class='inventory_item_name']");
    public static By product2 = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");
    public static By productTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    public static By productDetails = By.xpath("//div[@class='inventory_details_desc large_size']");

}
