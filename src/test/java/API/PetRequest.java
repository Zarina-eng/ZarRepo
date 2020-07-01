package API;

import API.POJO.PetPojo;
import API.POJO.ReqresPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class PetRequest {


    @Test
    public void getPet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/12");

        HttpGet get = new HttpGet(uri.build());
        get.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(get);


        ObjectMapper mapper=new ObjectMapper();
      PetPojo deserializeObject= mapper.readValue(response.getEntity().getContent(), PetPojo.class);

        System.out.println(deserializeObject.getId());
        System.out.println(deserializeObject.getName());


    }
    @Test
    public void getReqres() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/12");

        HttpGet get = new HttpGet(uri.build());
        get.setHeader("Accept", "application/json");
        HttpResponse response = client.execute(get);


        ObjectMapper mapper=new ObjectMapper();
        ReqresPojo deserializeObject= mapper.readValue(response.getEntity().getContent(), ReqresPojo.class);

        System.out.println(deserializeObject.getId());


    }
}
