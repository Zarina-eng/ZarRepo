package API.GetRequestPractice;

import Utils.PayLoadUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PostCat {
    @Test
    public void update() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uri = new URIBuilder();
        uri.setScheme("http");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet");

        HttpPut put = new HttpPut(uri.build());
        put.addHeader("Content-Type", "application/json");
        put.addHeader("Accept", "application/json");

        HttpEntity entity = new StringEntity(PayLoadUtil.getPetPayLoad());
        put.setEntity(entity);
        HttpResponse response = client.execute(put);


    }
}