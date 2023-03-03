package stepD;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import locators.xpaths;
import org.openqa.selenium.WebElement;

import java.util.List;
//import java.sql.DriverAction;

public class prac extends GemjarTestngBase {

    @Given("^user enter (.+) and (.+) and logs in.$")
    public void logIn(String Username, String Password) {
        DriverAction.maximizeBrowser();
        DriverAction.typeText(xpaths.userName, Username, "UserName");
        DriverAction.waitSec(2);
        DriverAction.typeText(xpaths.password, Password, "Password");
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.loginBtn);

    }

    @Then("^user verifies the url$")
    public void urlVerify() {
        String url = DriverAction.getCurrentURL();
        if (url.contains("www.saucedemo.com")) {
            System.out.println("Url is Verified");
            GemTestReporter.addTestStep("Verification of Url", "URL verified successfully", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verification of Url", "URL is mot verified", STATUS.FAIL);

        }
    }

    @Then("^user checks the product and adds to cart$")
    public void addtocart() {
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.product, "Product");
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.addtocart_Btn, "Add to Cart");
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.shoppingCart_Btn, "Shopping Cart");
        DriverAction.waitSec(2);
    }

    @And("^verifies the product in the cart$")
    public void verifiesProduct() {
        String cart_quantity = DriverAction.getElementText(xpaths.cart_quantity);
        if (!cart_quantity.isEmpty()) {
            GemTestReporter.addTestStep("Verification of Cart Quantity", "successfully verified the items", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verification of Cart Quantity", "Cart is Empty", STATUS.FAIL);
        }
    }

    @Then("^user goes back to continue shopping$")
    public void continueShopping() {
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.continue_shopping_Btn, "Continue Shopping");
        DriverAction.waitSec(2);
    }

    @Then("^user checks the product quantity$")
    public void productQuantity() {
        List<WebElement> listofproducts = DriverAction.getElements(xpaths.products);
        int no_of_products = listofproducts.size();
        System.out.println("Number of Products are : " + no_of_products);
        for (int i = 0; i < no_of_products; i++) {
            System.out.println("Products are : " + listofproducts.get(i).getText());
        }

        if (no_of_products > 0) {
            System.out.println("Products Verification is successful");
            GemTestReporter.addTestStep("Verification of Products Quantity", "successfully verified the products quantity", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verification of Products Quantity", "Products are not Available", STATUS.FAIL);

        }
    }


    @And("^user verifies the text of a product (.+), (.+)$")
    public void detail_of_product(String ProductTitle, String ProductDetails) {
        DriverAction.waitSec(2);
        DriverAction.click(xpaths.product2, "Sauce Labs Bike Light");
        DriverAction.waitSec(2);
        String productTitle = DriverAction.getElementText(xpaths.productTitle);
        System.out.println(productTitle);

        if (productTitle.equalsIgnoreCase(ProductTitle)) {
            GemTestReporter.addTestStep("Verification of Product Title", "Successfully Verified the Title", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verification of Product Title", "Not Verified", STATUS.FAIL);

        }

        String productDetails = DriverAction.getElementText(xpaths.productDetails);
        System.out.println("Product details are : " + productDetails);

        if (productDetails.contains(ProductDetails)) {
            GemTestReporter.addTestStep("Verification of Product Details", "Successfully Verified the Details", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Verification of Product Details", "Not Verified", STATUS.FAIL);

        }
    }

}



