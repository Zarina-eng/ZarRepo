package HW;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.kohsuke.rngom.util.Uri;

import java.io.IOException;
import java.net.URISyntaxException;

public class akchaBarCAll {
@Test
        public void akcha() throws IOException, URISyntaxException {
    HttpClient client = HttpClientBuilder.create().build();
    URIBuilder uriBuilder = new URIBuilder();
    uriBuilder.setScheme("http").setHost("rates.akchabar.kg").setPath("get.json");

    HttpGet get = new HttpGet(uriBuilder.build());
    get.setHeader("Accept","application/json");
    HttpResponse response= client.execute(get);


    ObjectMapper mapper = new ObjectMapper();
     AkchaBarPojo der=mapper.readValue(response.getEntity().getContent(),AkchaBarPojo.class);
    System.out.println(der.getRates().getEuro());


}
}
