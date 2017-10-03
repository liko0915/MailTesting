import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by liko0915 on 02.10.2017.
 */
public class LoginPage {
    By userLocator = By.id("mailbox__login");
    By passLocator = By.id("mailbox__password");
    By domainListLocator = By.id("mailbox__login__domain");
    By loginButtonLocator = By.id("mailbox__auth__button");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage setUserName(String userName) {
        Elements.waitElement(driver, userLocator, 10).sendKeys(userName);
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(userLocator));
//                .sendKeys(userName);
        return this;
    }

    public LoginPage setPass(String password) {
        Elements.waitElement(driver, passLocator, 10).sendKeys(password);
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(passLocator)).sendKeys(password);
        return this;
    }

    public LoginPage setDomain(String domain) {

        Elements.waitElement(driver, domainListLocator, 10).click();
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(domainListLocator)).click();
        Elements.waitElement(driver, By.xpath(".//option[@value='" + domain + "']"), 10).click();
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//option[@value='"+domain+"']"))).click();
        //driver.findElement(By.xpath(".//option[@value='"+domain+"']")).click();
        return this;
    }

    public MessagesBlock loginAs(String username, String password, String domain) {
        setUserName(username);
        setPass(password);
        setDomain(domain);
        return login();
    }

    public MessagesBlock login() { //click login button

        Elements.waitElement(driver, loginButtonLocator, 10).click();
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator)).click();
        return new MessagesBlock(driver);
    }

    public LoginPage loginFailure() { //for wrong credentials check
        try {
            Elements.waitElement(driver, By.id("mailbox:authfail"), 10).click();
//          (new WebDriverWait(driver, 10))
//                    .until(ExpectedConditions.presenceOfElementLocated(By.id("mailbox:authfail")));
        } catch (Exception e) {
        }
        return this;
    }
}
