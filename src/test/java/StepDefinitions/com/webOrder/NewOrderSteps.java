package StepDefinitions.com.webOrder;

import Pages.DuckDuckGoPages.WebOrderPages.AllOrdersPage;
import Pages.DuckDuckGoPages.WebOrderPages.HomePage;
import Pages.DuckDuckGoPages.WebOrderPages.OrderPage;
import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NewOrderSteps {
    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage(driver);
    OrderPage orderPage = new OrderPage(driver);
    AllOrdersPage allOrdersPage = new AllOrdersPage(driver);

    @Then("the user enter product  info {string} and {string}")
    public void the_user_enter_product_info_and(String product, String quantity) throws InterruptedException {

        homePage.orderButton.click();
        Select select = new Select(orderPage.productName);
        select.selectByVisibleText(product);
        orderPage.quantity.clear();
        Thread.sleep(1000);
        orderPage.quantity.sendKeys(quantity);

    }

    @Then("the user enter address info {string}, {string}, {string}, {string}, {string}")
    public void the_user_enter_address_info(String name, String street, String state, String city, String zip) {

        orderPage.name.sendKeys(name);
        orderPage.street.sendKeys(street);
        orderPage.state.sendKeys(state);
        orderPage.city.sendKeys(city);
        orderPage.zipCode.sendKeys(zip);

    }

    @Then("the user enter payment info {string}, {string}, {string}")
    public void the_user_enter_payment_info(String card, String cardNumber, String expiration) {
        switch (card) {
            case "Visa":
                orderPage.visa.click();
                break;
            case "MasterCard":
                orderPage.mastedCard.click();
                break;
            case "American Express":
                orderPage.amex.click();
                break;

        }
        orderPage.cardNumber.sendKeys(cardNumber);
        orderPage.expireDate.sendKeys(expiration);
        orderPage.prossesButton.click();
    }

    @Then("the user validate  success message")
    public void the_user_validate_success_message() {
        Assert.assertTrue(orderPage.street.isDisplayed());

    }

    @Then("the user validate new order details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void the_user_validate_new_order_details(String productName, String quantity, String name, String address, String city, String state, String zipCode, String card, String cardNumber, String expDate) {

        homePage.viewAllOrder.click();
        List<WebElement> orderDetails = allOrdersPage.ListOfOrders;
        Assert.assertEquals(orderDetails.get(1).getText(), name);
        Assert.assertEquals(orderDetails.get(2).getText(), productName);
        Assert.assertEquals(orderDetails.get(3).getText(), quantity);
        Assert.assertEquals(orderDetails.get(5).getText(), address);
        String today = BrowserUtils.todaysDate("MM/dd/yyyy");
        Assert.assertEquals(orderDetails.get(4).getText(), today);


        Assert.assertEquals(orderDetails.get(6).getText(), city);
        Assert.assertEquals(orderDetails.get(7).getText(), state);
        Assert.assertEquals(orderDetails.get(8).getText(), zipCode);
        Assert.assertEquals(orderDetails.get(9).getText(), card);
        Assert.assertEquals(orderDetails.get(10).getText(), cardNumber);
        Assert.assertEquals(orderDetails.get(11).getText(), expDate);


    }

    @Then("the user goes to new order page")
    public void the_user_goes_to_new_order_page() {
        homePage.orderButton.click();

    }

    @Then("the user validate the product headers")
    public void the_user_validate_the_product_headers(List<String> productHeaders) {
        List<String> actualPDetails = new ArrayList<>();
        List<WebElement> headers = orderPage.productDetails;
        for (WebElement header : headers) {
            actualPDetails.add(header.getText());
        }

        Assert.assertEquals(actualPDetails, productHeaders);


    }

    @Then("the user validate the address headers")
    public void the_user_validate_the_address_headers(List<String> addressHeaders) {
        List<String> actualPDetails = new ArrayList<>();
        List<WebElement> headers = orderPage.AddressDetails;
        for (WebElement header : headers) {
            actualPDetails.add(header.getText());
        }

        Assert.assertEquals(actualPDetails, addressHeaders);

    }

    @Then("the user click  the all product button")
    public void the_user_click_the_all_product_button() {
        homePage.viewAllProducts.click();
    }

    @Then("the user validate the product  details")                //expected
    public void the_user_validate_the_product_details(DataTable  dataTable) {
   //list<String> dataTable=               //actual
List<WebElement>  ptable=homePage.productTable;
for(int i=0; i<dataTable.asList().size();i++){
    Assert.assertEquals("Validation of product table: ", dataTable.asList().get(i),ptable.get(i).getText());

}



    }

}
