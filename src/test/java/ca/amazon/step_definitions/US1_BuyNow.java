package ca.amazon.step_definitions;

import ca.amazon.pages.BasePage;
import ca.amazon.pages.SignInPage;
import ca.amazon.utilities.BrowserUtils;
import ca.amazon.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US1_BuyNow {

    BasePage basePage = new BasePage();
    SignInPage signInPage = new SignInPage();


    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {

        String expectedTitle = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
        String actualTitle = Driver.getDriver().getTitle();

        // verify user is on the homepage
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @Given("user clicks on hamburger menu")
    public void user_clicks_on_hamburger_menu(){
        basePage.hamburgerMenu.click();
        BrowserUtils.waitFor(2);

    }


    @And("user selects {string} under Digital Content and Devices")
    public void userSelectsUnderDigitalContentAndDevices(String category) {
      BrowserUtils.selectCategoryFromHamburgerMenu(category);
        BrowserUtils.waitFor(2);
    }

    @Given("user clicks {string} under Kindle E-Reader")
    public void user_clicks_under_kindle_e_reader(String category) {
        BrowserUtils.selectCategoryFromHamburgerMenu(category);
        BrowserUtils.waitFor(2);

    }
    @Then("user clicks Buy Now")
    public void user_clicks_buy_now() {
        basePage.buyNowButton.click();

    }
    @Then("user is asked for email or mobile number")
    public void user_is_asked_for_email_or_mobile_number() {

            String expectedLabel = "E-mail address or mobile phone number";
            Assert.assertEquals(expectedLabel,signInPage.emailOrPhoneLabel.getText());

    }



}
