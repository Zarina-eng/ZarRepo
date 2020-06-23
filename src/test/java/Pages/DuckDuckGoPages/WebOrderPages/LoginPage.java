package Pages.DuckDuckGoPages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.navigate().refresh();
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;
    @FindBy(id = "ctl00_MainContent_status")
    public  WebElement titleText;



    /*
  PageFactory.initElements(drive,LoginPage.class);
  --> it will solve the issue stateElementException if the element is refreshed on the page
  --> this is inside the stepDefinition class

     */
}
