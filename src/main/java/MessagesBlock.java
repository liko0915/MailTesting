import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by liko0915 on 02.10.2017.
 */
public class MessagesBlock {
    By createMessLocator = By.linkText("Написать письмо");
    By sendedMessLocator = By.linkText("Отправленные");
    By sendedAllertLocator = By.linkText("Перейти во Входящие");

    private final WebDriver driver;

    public MessagesBlock(WebDriver driver) {
        this.driver = driver;
    }

    public MessageCreationPage createNewMessage() { //click new mess button
        Elements.waitElement(driver, createMessLocator, 10).click();
        //driver.findElement(createMessLocator).click();
        return new MessageCreationPage(driver);
    }

    public SandedMessagesPage toSended() {
        Elements.waitElement(driver, sendedMessLocator, 10).click();
        //driver.findElement(sendedMessLocator).click();
        return new SandedMessagesPage(driver);
    }


}
