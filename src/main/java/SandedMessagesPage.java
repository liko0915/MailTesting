import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Liko on 02.10.2017.
 */
public class SandedMessagesPage extends Elements{
    By messTable = By.id("PJC6gP8W");

    private final WebDriver driver;

    public SandedMessagesPage(WebDriver driver) {
        this.driver = driver;
    }


    public String checkMessage(String content){ //find sanded content on page
        try{
            waitElement(driver,By.xpath(".//*[contains(text(),'"+content+"')]"),10);
            //driver.findElement(By.linkText(content));
            return "ok";
        }
        catch (Exception e){
            return e.getStackTrace().toString();
        }

    }
}
