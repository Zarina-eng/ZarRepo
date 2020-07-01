package API.GetRequestPractice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class DESERIALIZATION {
    @Test
    public void deserialization1() throws URISyntaxException, IOException {
        HttpClient clientBuilder = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/1");
        //https://reqres.in/api/users?page=2
        HttpGet get = new HttpGet(uri.build());
        get.addHeader("Accept", "application/json");

        HttpResponse response = clientBuilder.execute(get);
        if (response.getStatusLine().getStatusCode() != 200) {
            Assert.fail();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> desiriResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        Map<String, Object> category = (Map<String, Object>) desiriResponse.get("category");
        System.out.println("category name is :" + category.get("name"));

    }

    @Test
    public void deserialization2() throws URISyntaxException, IOException {
        HttpClient clientBuilder = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("reqres.in");
        uri.setPath("api/users?page=2");
        HttpGet get = new HttpGet(uri.build());
        get.addHeader("Accept", "application/json");

        HttpResponse response = clientBuilder.execute(get);
        if (response.getStatusLine().getStatusCode() != 200) {
            Assert.fail();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> desiriResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        Map<String, Object> category = (Map<String, Object>) desiriResponse.get("ad");
        System.out.println("category name is :" + category.get("company"));

    }


}
