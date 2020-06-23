package StepDefinitions.com.duckduckgo;

import Pages.DuckDuckGoPages.SearchPage;
import Pages.DuckDuckGoPages.WebOrderPages.HomePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchBoxSteps {
    WebDriver driver = Driver.getDriver();
    SearchPage page;
    HomePage homePage;



    @When("the user send the key Selenium keyword")
    public void the_user_send_the_key_Selenium_keyword() throws InterruptedException {
        page.searchBox.clear();
        page.searchBox.sendKeys("selenium");
        Thread.sleep(2000);
    }

    @Then("the user click search button")
    public void the_user_click_search_button() throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(page.searchButton).click().perform();
        Thread.sleep(1000);

    }

    @Then("the user validate title contains the selenium keyword")
    public void the_user_validate_title_contains_the_selenium_keyword() {
        String actualTitle = driver.getTitle();
//Assert is coming from JUnit
        Assert.assertTrue(actualTitle.contains(ConfigReader.getProperty("searchValue")));
    }

    @Then("the user validate url  contains the selenium keyword")
    public void the_user_validate_url_contains_the_selenium_keyword() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("searchValue")));
    }

    @Then("the user validate all results contain the selenium keyword")
    public void the_user_validate_all_results_contain_the_selenium_keyword() {
        for (WebElement element : page.searchResult) {

            String actualResult = element.getText();
            Assert.assertTrue((actualResult.contains(ConfigReader.getProperty("result"))));
        }
    }

    @Given("the user goes to the duckduckgo")
    public void the_user_goes_to_the_duckduckgo() {
        page = new SearchPage(driver);
        homePage = new HomePage(driver);
        driver.get(ConfigReader.getProperty("url"));

    }


    @When("the user search with {string}")
    public void the_user_search_with(String testng) throws InterruptedException {
        page.searchBox.sendKeys(testng);


    }

    @When("the user validate title contains {string}")
    public void the_user_validate_title_contains(String expected) throws InterruptedException {
        String actual = driver.getTitle();
        Assert.assertTrue(expected.contains(actual));
    }

    @When("the user validate all result contains {string}")
    public void the_user_validate_all_result_contains(String text) {
        for (WebElement result:page.searchResult){
            Assert.assertTrue(result.getText().contains(text));

        }


    }

    @When("the user validate number of result is {int}")
    public void the_user_validate_number_of_result_is(int expectedNum) {
        Assert.assertEquals(expectedNum,page.searchResult.size());

        }

    }




