package ca.amazon.step_definitions;


/* In this class we will be able to pass pre & post conditions to each scenario and each step
 */


import ca.amazon.utilities.ConfigurationReader;
import ca.amazon.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    @Before
    public void setUpScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    

    @After
    public void tearDownScenario(Scenario scenario){

        /**
         * 1-> scenario.isFailed() :
         *     - if scenario fails this will return TRUE.
         * 2- byte [] screenshot = We are creating an array of bytes to be able to store our screenshot
         * 3- ((TakesScreenshot)Driver.getDriver()) ---> we are downcasting our driver type to TakesScreenshot
         * 4- .getScreenshotAs(OutputType.BYTES); ---> we are returning the screenshot as byte so we can use
         * 5- scenario.attach() --> this method is able to attach the screenshot into our report
         *     - it accepts 3 arguments:
         *     arg1 : array of bytes --> byte [] screenshot :
         *     arg2 : String image type -->  "image/png"
         *     arg3 : String scenario name --> scenario.getName()
         *
         * How do you take screenshot in framework?
         *     - I use Scenario class to get certain information from current scenario such as name, and condition
         *     - I downcast my driver type to TakesScreenshot interface and use method getScreenshotAs to store my screenshot as array of bytes
         *     - And attach my screenshot into report using scenario class object and attach method.
         */
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }


        Driver.closeDriver();


    }


   


}
