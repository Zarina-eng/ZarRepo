package StepDefinitions;

import Utils.PayLoadUtil;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class ApiPet {
    String name = "ReX";
    String status = "Do not touch!";
    int id = 232;

    @When("user creates a pet with id , name, status")
    public void user_creates_a_pet_with_id_name_status() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uri = new URIBuilder();
        uri.setScheme("http");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet");

        HttpPut put = new HttpPut(uri.build());
        put.addHeader("Content-Type", "application/json");
        put.addHeader("Accept", "application/json");

        HttpEntity entity = new StringEntity(PayLoadUtil.getPetPayLoad2(id, name, status));
        put.setEntity(entity);
        System.out.println("Start post");


    }

    @Then("the status code is  OK")
    public void the_status_code_is_OK() {

    }

    @Then("pet with id, name, status is created")
    public void pet_with_id_name_status_is_created() {

    }

}
