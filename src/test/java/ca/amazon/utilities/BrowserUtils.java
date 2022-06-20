package ca.amazon.utilities;

import ca.amazon.pages.BasePage;
import org.openqa.selenium.WebElement;

public class BrowserUtils {


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void selectCategoryFromHamburgerMenu(String category){
        BasePage basePage = new BasePage();
        for (WebElement eachCategory : basePage.hamburgerMenuCategories) {

            if (eachCategory.getText().equals(category)){
                eachCategory.click();
                return;
            }

        }

    }


}
