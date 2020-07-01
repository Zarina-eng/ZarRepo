package API.SerializationIntro;

import Utils.PayLoadUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialization {
    @Test
    public void serializ1() throws IOException {
        Pet pet = new Pet("Hatiko", 2, "waiting");

        pet.setId(2);
        pet.setPhotoUrl("https://s3.petpict.amazon.com");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("target/pet.json"), pet);
    }

    @Test
    public void serializeCar() throws IOException {

        Cars car = new Cars("Lexus", 2020, "New");
        car.setColor("White");
        car.setId(777777);


        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("target/car.json"), car);
    }

    @Test
    public void createPet() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https").setHost("petstore.io").setPath("v2/pet");

        HttpPost post = new HttpPost(uri.build());
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");

        String petPAyLoad = PayLoadUtil.generateStringFromResourse("target/pet.json");
        HttpEntity entity = new StringEntity(petPAyLoad);

        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

    }
}
