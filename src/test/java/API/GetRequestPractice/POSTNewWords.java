package API.GetRequestPractice;

import Utils.PayLoadUtil;
import Utils.RandomName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class POSTNewWords {
    Faker faker;

    @Test
    public void creatNewPets() throws URISyntaxException, IOException {
        faker = new Faker();
        for (int i = 0; i <= 25; i++) {

            HttpClient client = HttpClientBuilder.create().build();

            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("petstore.swagger.io");
            uriBuilder.setPath("v2/pet");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept", "application/json");

            HttpEntity entityBuilder = new StringEntity(PayLoadUtil.getPetPayLoad());
            httpPost.setEntity(entityBuilder);
            HttpResponse responseFor = client.execute(httpPost);
            System.out.println(RandomName.getRandomName());

            Assert.assertEquals(HttpStatus.SC_OK, responseFor.getStatusLine().getStatusCode());


        }

    }

    @Test
    public void update() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uri = new URIBuilder();
        uri.setScheme("http");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet");

        HttpPost post = new HttpPost(uri.build());
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Accept", "application/json");
        String name = "REX";
        String status = "waiting";
        int id = 2323;
        HttpEntity entity = new StringEntity(PayLoadUtil.getPetPayLoad2(id, name, status));
        post.setEntity(entity);
        System.out.println("Started post execution");
        HttpResponse response = client.execute(post);
        System.out.println("Finished post execution");

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        System.out.println("Mapping response body with java Object");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parseRessponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });


        int actualId = (int) parseRessponse.get("id");
        String actualName = parseRessponse.get("name").toString();
        String actualStatus = parseRessponse.get("status").toString();

        Assert.assertEquals(id, actualId);
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(status, actualStatus);

        //Execute the Get Request and do verification
//--------------------------------------------------------------------

        uri.setPath("v2/pet/" + id);
        HttpGet get = new HttpGet(uri.build());
        get.setHeader("Accept","application/json");
        System.out.println("Starter executing Get Request");
        HttpResponse getResponse = client.execute(get);
        System.out.println("Finished executing Get Request");

        Assert.assertEquals(HttpStatus.SC_OK, getResponse.getStatusLine().getStatusCode());
        System.out.println("Deserialize response ");
        Map<String, Object> parseGetResponse = objectMapper.readValue(getResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Assert.assertEquals(id, parseGetResponse.get("id"));

        Assert.assertEquals(name, parseGetResponse.get("name"));
        Assert.assertEquals(status, parseGetResponse.get("status"));


    }
}
