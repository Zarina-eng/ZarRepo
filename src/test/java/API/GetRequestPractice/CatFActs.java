package API.GetRequestPractice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
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
import java.util.Set;

public class CatFActs {


    @Test
    public void countCat() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("http");
        uri.setHost("cat-fact.herokuapp.com");
        uri.setPath("facts");
        HttpGet get = new HttpGet(uri.build());

        HttpResponse response = httpClient.execute(get);


        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, List<Map<String, Object>>> parseResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, List<Map<String, Object>>>>() {
                });

//     //   if(parseResponse.containsValue("cat"))
//        for(int i=0; i<parseResponse.get("all").size();i++){
//        System.out.println(parseResponse.get("all").get(i).get("user"));
//            System.out.println("" +
//                    "");
//    }

        List<Map<String, Object>> category = parseResponse.get("all");

        for (Map<String, Object> map : category) {
            Map<String, Object> userInfo = (Map<String, Object>) map.get("user");

            Map<String, Object> fName = (Map<String, Object>) userInfo.get("name");
            System.out.println(fName.get("first"));
            System.out.println(fName.get("last"));


        }

    }

    /*
    https://api.got.show/api/map/charactershttps://api.got.show/api/map/characters
     */
    @Test
    public void api() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("api.got.show");
        uri.setPath("api/map/characters");
        HttpGet get = new HttpGet(uri.build());

        HttpResponse response = httpClient.execute(get);


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> titles = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });


        List<Map<String, Object> >text = (List<Map<String, Object>>) titles.get("data");

        Map<String, Object>  firstHouse=text.get(0);
        System.out.println(  firstHouse.get("house"));

        for (int i = 0; i < text.size(); i++) {
            System.out.println(text.get(i).get("house"));


        }
    }

}

