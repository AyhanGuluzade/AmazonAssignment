package ca.amazon.pages;

import ca.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "nav-hamburger-menu")
    public WebElement hamburgerMenu;


    @FindBy(xpath = "//ul[contains(@class,'hmenu hmenu-visible')]/li/a")
    public List<WebElement> hamburgerMenuCategories;


    @FindBy(id = "buy-now-button")
    public WebElement buyNowButton;

}
