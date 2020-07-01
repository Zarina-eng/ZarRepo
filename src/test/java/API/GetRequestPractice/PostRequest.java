package API.GetRequestPractice;

import Utils.PayLoadUtil;
import Utils.RandomName;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static Utils.PayLoadUtil.getPetPayLoad;

public class PostRequest {

    @Test
    public void postRequest() throws URISyntaxException, IOException {

        /*
        1. Open a client (POASTMAN, terminal)
	3. 2.Specify the HTTP method(GET,POST)
	2. 3.Specify URL/URI endpoint
	4. Add query parameter(if needed)
	5. Add header parameters(content-type, accept)
	6. Add body parameter (for POST)
	7. Execute (click on Send button)

	https://reqres.in/api/users?page=2
         */
        //open a client(postman,terminal)
          HttpClient httpClient= HttpClientBuilder.create().build();

        //buil URL,URI
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("reqres.in");
        uriBuilder.setPath("api/users");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        HttpEntity entityBuilder=new StringEntity("{\n" +
                "    \"name\": \"Zarina\",\n" +
                "    \"job\": \"SDET\"\n" +
                "}");
httpPost.setEntity(entityBuilder);
HttpResponse response=httpClient.execute(httpPost);
        Assert.assertEquals(201, response.getStatusLine().getStatusCode());
        Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
    }
    //https://petstore.swagger.io/v2/pet

    @Test
    public void pet() throws URISyntaxException, IOException {
        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        HttpEntity entityBuilder=new StringEntity(PayLoadUtil.getPetPayLoad());
        httpPost.setEntity(entityBuilder);
        HttpResponse responseFor=httpClient.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, responseFor.getStatusLine().getStatusCode());
    }
}
