import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by liko0915 on 02.10.2017.
 */
public class MessageCreationPage {

    By messBodyLocator = By.xpath(".//html/body");
    By receiverLocator = By.xpath(".//textarea[@data-original-name='To']");
    By subjectLocator = By.xpath(".//input[@name='Subject']");
    By sendButton = By.xpath(".//div[contains(@data-name,'send')]");

    private final WebDriver driver;

    public MessageCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MessageCreationPage setBody(String body) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(3));
        //driver.switchTo().frame(3);
        Elements.waitElement(driver, messBodyLocator, 10).sendKeys(body);
        //driver.findElement(messBodyLocator).sendKeys(body);
        driver.switchTo().defaultContent();
        return this;
    }

    public MessageCreationPage setSubject(String subject) {
        Elements.waitElement(driver, subjectLocator, 10).sendKeys(subject);
        //driver.findElement(subjectLocator).sendKeys(subject);
        return this;
    }

    public MessageCreationPage setReseiver(String reseiver) {
        Elements.waitElement(driver, receiverLocator, 10).sendKeys(reseiver);
        //driver.findElement(receiverLocator).sendKeys(reseiver);
        return this;
    }

    public MessagesBlock clickSend() {
        Elements.waitElement(driver, sendButton, 10).click();
        //driver.findElement(sendButton).click();
        return new MessagesBlock(driver);
    }

    public MessagesBlock sendMessage(String body, String subject, String reseiver) {
        setBody(body);
        setSubject(subject);
        setReseiver(reseiver);
        return clickSend();
    }


}
