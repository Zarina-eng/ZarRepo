package HW;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class HW {


    @Test
    public void test1() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("slack.com");
        uri.setPath("api/conversations.history");
        uri.setCustomQuery("channel=C0164SXRETU");

//https://slack.com/api/conversations.history?channel=C0164SXRETU
        HttpGet get = new HttpGet(uri.build());

        get.setHeader("Authorization", "Bearer xoxb-941125893829-1209222336674-bAXxCFoJlNU7qhWlTL9yQAF7");
        get.setHeader("Accept", "application/json");
        client.execute(get);
        HttpResponse response = client.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> parseResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        List<Map<String, Object>> text = (List<Map<String, Object>>) parseResponse.get("messages");

        System.out.println(text.get(0).get("text"));

    }
}