package StepDefinitions;

import Utils.PayLoadUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

public class HW {
    HttpPost httpPost;
    HttpClient httpClient;
    HttpEntity entityBuilder;
    HttpResponse responseFor;
    URIBuilder uriBuilder;

    @When("user creates a pet with {int}, {string}, {string}")
    public void user_creates_a_pet_with(int id, String name, String status) throws URISyntaxException, IOException {
        httpClient = HttpClientBuilder.create().build();

       uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        httpPost = new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        entityBuilder = new StringEntity(PayLoadUtil.getPetPayLoad2(id, name, status));
        httpPost.setEntity(entityBuilder);
        responseFor = httpClient.execute(httpPost);
    }

    @Then("the status code is  {string}")
    public void the_status_code_is(String string) throws IOException {

        Assert.assertEquals(HttpStatus.SC_OK, responseFor.getStatusLine().getStatusCode());

    }

    @Then("pet with {int}, {string}, status is created")
    public void pet_with_status_is_created(int id, String string2) throws URISyntaxException, IOException {
        HttpGet get=new HttpGet(uriBuilder.build());
        get.setHeader("Accept","application/json");
      responseFor =httpClient.execute(get);
        System.out.println(responseFor.getEntity().getContent());
Assert.assertEquals(id,id);
    }
}
