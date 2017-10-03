import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by liko0915 on 03.10.2017.
 */
public class Elements {

    public static WebElement waitElement(WebDriver driver, By locator, long timeOutInSeconds) {
        return (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPageLoading(WebDriver driver, long timeOutInSeconds) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
