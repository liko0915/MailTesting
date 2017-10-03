/**
 * Created by Liko on 02.10.2017.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test extends Elements implements CredentialConstants {

    @Test
    public void mailTesting() throws Exception {
        //preconditions
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //login
        LoginPage loginPage = new LoginPage(driver);
        MessagesBlock block = loginPage.loginAs(USER, PASSWORD, DOMAIN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            waitElement(driver, block.createMessLocator, 10);
            //driver.findElement(block.createMessLocator);
        } catch (Exception e) {
            System.out.println("login fail" + e.getStackTrace());
        }

        //Create message
        MessageCreationPage messagePage = block.createNewMessage();
        block = messagePage.sendMessage(MESSCONTENT, SUBJECT, RESEIVER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //check
        try {
            waitElement(driver, block.sendedAllertLocator, 10);
            //driver.findElement(block.sendedAllertLocator);
        } catch (Exception e) {
            System.out.println("mess was not sanded" + e.getStackTrace().toString());
        }


        //check by searching in sanded message

//        //to sended messages
//        SandedMessagesPage sandedMessagesPage = block.toSended();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //check
//        sandedMessagesPage.checkMessage(messContent);

    }
}

