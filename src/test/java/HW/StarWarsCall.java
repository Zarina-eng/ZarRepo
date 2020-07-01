package HW;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;



public class StarWarsCall {
    @Test
    public void starWars() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https").setHost("swapi.dev").setPath("api/starships");
        HttpGet get = new HttpGet(uri.build());
        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        StarWarsPojo deser = mapper.readValue(response.getEntity().getContent(), StarWarsPojo.class);

        for(int i=0; i<deser.getResults().size(); i++){
            System.out.println(deser.getResults().get(i).getName());
        }

    }

}
