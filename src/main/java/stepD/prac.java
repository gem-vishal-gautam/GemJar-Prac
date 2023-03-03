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


}


