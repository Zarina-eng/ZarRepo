package API.POJO;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class RequestCall {
    @Test
    public void getUser() throws URISyntaxException, IOException {
        HttpClient clientBuilder = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("reqres.in");
        uri.setPath("api/users/7");

        //https://reqres.in/api/users/

        HttpGet get = new HttpGet(uri.build());
        HttpResponse response = clientBuilder.execute(get);
        ObjectMapper mapper = new ObjectMapper();
       UserPojo deserializeObject= mapper.readValue(response.getEntity().getContent(), UserPojo.class);

        System.out.println(deserializeObject.getData().getFirst_name());
        System.out.println(deserializeObject.getData().getLast_name());
        System.out.println(deserializeObject.getAd().getCompany());


    }
}
