package StepDefinitions.com.Etsy;

import EtsyPages.EtsyHomePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySteps {

    WebDriver driver= Driver.getDriver();
    EtsyHomePage etsyHomePage=new EtsyHomePage(driver);


    @Given("the user goes tio the Etsy")
    public void the_user_goes_tio_the_Etsy() {
      driver.navigate().to(ConfigReader.getProperty("etsyUrl"));
    }
    @When("the user search int etsy  with {string}")
    public void the_user_search_int_etsy_with(String searchValue) {
        etsyHomePage.searchBox.sendKeys(searchValue);
        etsyHomePage.searchButton.click();
    }

    @Then("the user validate title {string} and url {string}")
    public void the_user_validate_title_and_url(String getTitle, String searchValue) {
        Assert.assertEquals(driver.getTitle(), getTitle);
        Assert.assertEquals(driver.getCurrentUrl(), searchValue);
    }

}
