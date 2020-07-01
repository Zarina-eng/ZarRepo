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
import java.util.List;
import java.util.Map;

public class Reqrest {
    @Test
    public void deserialization1() throws URISyntaxException, IOException {
        HttpClient clientBuilder = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("reqres.in");
        uri.setPath("api/users");
        uri.setCustomQuery("per_page=12");
        //https://reqres.in/api/users/

        HttpGet get = new HttpGet(uri.build());
        HttpResponse response = clientBuilder.execute(get);
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> parseResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        List<Map<String, Object>> text = (List<Map<String, Object>>) parseResponse.get("data");
        int sum = 0;
        for (int i = 0; i < text.size(); i++) {
            // sum+=(int)text.get("id");


        }
        System.out.println(sum);
        System.out.println(parseResponse.get("id"));
        Assert.assertEquals(parseResponse.get("per_page"), text.size());


        System.out.println("------------------------------------");
        System.out.println(parseResponse.get("page"));
        System.out.println(parseResponse.get("total"));
        System.out.println(parseResponse.get("total_pages"));


        List<Map<String, Object>> id = (List<Map<String, Object>>) parseResponse.get("data");

        System.out.println(id);

        for (Map<String, Object> map : id) {
            System.out.println(map.get("first_name"));

        }


    }


    @Test
    public void allMessage() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("slack.com");
        uri.setPath("api/conversations.history");
        uri.setCustomQuery("?channel=C0164SXRETU");
        HttpGet get = new HttpGet(uri.build());
        HttpResponse response = client.execute(get);
        get.addHeader("Accept", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parseResponse = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        List<Map<String, Object>> text = (List<Map<String, Object>>) parseResponse.get("messages");


        for (int i = 0; i < text.size(); i++) {
            System.out.println(text.get(i).get("text"));
            System.out.println("" +
                    "");
        }

    }

    //https://itunes.apple.com/search?term=linkinpark
    @Test
    public void getLPark() throws URISyntaxException, IOException {
        int limitVAlue = 0;
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("itunes.apple.com");
        uri.setPath("search");
        uri.setCustomQuery("?term=linkinpark&limit" + limitVAlue);
        HttpGet get = new HttpGet(uri.build());
        HttpResponse response = client.execute(get);
        get.addHeader("Accept", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parseResponse = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        List<Map<String, Object>> text = (List<Map<String, Object>>) parseResponse.get("results");
        int count = 0;
        for (Map<String, Object> n : text) {
            String temp = "" + n.get("artistName");
            count++;

            System.out.println(count);
            Assert.assertTrue(temp.contains("LINKIN PARK"));

        }
        System.out.println(limitVAlue);
        Assert.assertEquals(limitVAlue, text.size());
     //   Assert.assertEquals(limitVAlue, mapper.get("resultCount"));


    }
}



