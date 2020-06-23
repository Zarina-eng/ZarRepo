package Pages.DuckDuckGoPages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtName")
    public WebElement name;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox3")
    public WebElement city;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox4")
    public WebElement state;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox5")
    public WebElement zipCode;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement mastedCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement amex;


    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox6")
    public  WebElement cardNumber;

    @FindBy(name = "ctl00$MainContent$fmwOrder$TextBox1")
    public WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement prossesButton;

    @FindBy(tagName = "strong")
    public WebElement successMessage;


    @FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder']//ol[1]//label")
    public List<WebElement> productDetails;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder']//ol[2]//label")
    public List<WebElement> AddressDetails;
}
