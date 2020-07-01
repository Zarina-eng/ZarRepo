package StepDefinitions.Api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class SlackD {
    String message;
    WebDriver driver;


    //-----------------------------------
    @When("Send message to slack via POST request")
    public void send_message_to_slack_via_POST_request() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/chat.postMessage");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-bAXxCFoJlNU7qhWlTL9yQAF7");
        message = "HIHIHI";
        HttpEntity httpEntity = new StringEntity("{\n" +
                "  \"channel\": \"C0164SXRETU\",\n" +
                "  \"text\": \"" + message + "\"\n" +
                "}");
        httpPost.setEntity(httpEntity);
        httpClient.execute(httpPost);
    }

    @Then("Verify the message via GET request")
    public void verify_the_message_via_GET_request() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/conversations.history");
        uriBuilder.setCustomQuery("channel=C0164SXRETU");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-bAXxCFoJlNU7qhWlTL9yQAF7");
        httpClient.execute(httpGet);
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapper = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> mapper2 = (List<Map<String, Object>>) mapper.get("messages");
        System.out.println(mapper2);
        //System.out.println();
        Assert.assertEquals(message, mapper2.get(0).get("text"));

    }

    @Then("Verify the message with Selenium Webdriver in UI")
    public void verify_the_message_with_Selenium_Webdriver_in_UI() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.slack.com/client/TTP3PS9QD/C0164SXRETU");
        WebElement batch4 = driver.findElement(By.xpath("//input[@name='domain']"));
        batch4.sendKeys("techtorialbatch4");
        WebElement continue1 = driver.findElement(By.xpath("//span[@class='ladda-label align_middle']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("zarizarylbek@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("8422.Gregory");
        String actualmessage = driver.findElement(By.xpath("//div[contains(text(),'" + message + "')]")).getText();
        Assert.assertEquals(message, actualmessage);


    }

    @When("Send message to slack with Selenium Webdriver in UI")
    public void send_message_to_slack_with_Selenium_Webdriver_in_UI() {

        driver.navigate().to("https://app.slack.com/client/TTP3PS9QD/C0164SXRETU");
        WebElement batch4 = driver.findElement(By.xpath("//input[@name='domain']"));
        batch4.sendKeys("techtorialbatch4");
        WebElement continue1 = driver.findElement(By.xpath("//span[@class='ladda-label align_middle']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("zarizarylbek@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("8422.Gregory");
        WebElement textArea = driver.findElement(By.xpath("//div[@data-team-id='TTP3PS9QD']"));
        textArea.sendKeys(message);
        WebElement sendButton = driver.findElement(By.xpath("//i[@type='paperplane-filled']"));


    }

    @Then("Vefify the message with Selenium Webdriver in UI")
    public void vefify_the_message_with_Selenium_Webdriver_in_UI() {


        String actualmessage2 = driver.findElement(By.xpath("//div[contains(text(),'" + message + "')]")).getText();
        Assert.assertEquals(message,actualmessage2);
        System.out.println("Not Implemented");

    }

    @When("Delete message from slack via POST request")
    public void delete_message_from_slack_via_POST_request() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder;
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("slack.com");
        uriBuilder.setPath("api/chat.delete");
        uriBuilder.setCustomQuery("channel=C0164SXRETU&ts=");
    }

    @Then("Verify the message is gone via GET request")
    public void verify_the_message_is_gone_via_GET_request() {

        System.out.println("Not Implemented");

    }

    @Then("Verify the message is gone via Selenium Webdriver in UI")
    public void verify_the_message_is_gone_via_Selenium_Webdriver_in_UI() {
        System.out.println("Not Implemented");
    }

}
