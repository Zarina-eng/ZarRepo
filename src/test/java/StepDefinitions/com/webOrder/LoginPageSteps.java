package StepDefinitions.com.webOrder;

import Pages.DuckDuckGoPages.WebOrderPages.HomePage;
import Pages.DuckDuckGoPages.WebOrderPages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = Driver.getDriver();//implement
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

@Before
public void message(){
    System.out.println("Login Page Step Class");
}
    @BeforeStep
            public void beforeStep(){
        System.out.println("Before Step");

}
@AfterStep
public void afterStep(){
    System.out.println("After Step");
}
    @Then("the demoUser validate the home page")
    public void the_demoUser_validate_the_home_page() {
        Assert.assertEquals(driver.getTitle(), "Web Orders");
        Assert.assertTrue(homePage.logOutButton.isDisplayed());
        Assert.assertTrue(homePage.welcomeText.getText().contains("Welcome, Tester!"));

    }

    @Given("the demoUser enters  username {string}")
    public void the_demoUser_enters_username(String username) {
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
        loginPage.username.sendKeys(username);
    }

    @When("the demoUser enters password {string}")
    public void the_demoUser_enters_password(String password) {
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();

    }

    @Then("the demoUser validate {string}")
    public void the_demoUser_validate(String expectedTitle) {
        Assert.assertEquals("Error message is Validation ",expectedTitle, loginPage.titleText.getText());
    }






}
