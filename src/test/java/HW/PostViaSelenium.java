package HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PostViaSelenium {
    @Test
    public void Amazon() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//a[@href]"));

        for (int i = 1; i < listOfLinks.size(); i++) {
            Response response = RestAssured.get(listOfLinks.get(i).getAttribute("href"));
            if (response.getStatusCode() == 200) {
                System.out.println(listOfLinks.get(i).getAttribute("href"));
            }
        }


    }
@Test
    public void slack(){


    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://app.slack.com/client/TTP3PS9QD/C0164SXRETU");

}


}
