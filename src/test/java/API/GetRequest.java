package API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetRequest {

    @Test
    public void GetRequest() throws URISyntaxException, IOException {


    /*
    	1. Open a client (POASTMAN, terminal)
	2. 2.Specify the HTTP method(GET,POST)
	3. 3.Specify URL/URI endpoint
	4. Add query parameter(if needed)
	5. Add header parameters(content-type, accept)
	6. Add body parameter (for POST)
	7. Execute (click on Send button)

     */
//Open a client
        HttpClient client = HttpClientBuilder.create().build();

        //	3. 3.Specify URL/URI endpoint
        //https://petstore.swagger.io/v2/pet/9778
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/9778");


        //Specify the HHTP method(GEt)
        HttpGet get = new HttpGet(uri.build());
        //Add header parameters(content-type, accept)
        get.setHeader("Acctep", "application/json");

        //Execute
       HttpResponse response= client.execute(get);
      Assert.assertEquals(200,response.getStatusLine().getStatusCode());

      Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());

    }
    @Test
    public void GetRequest2() throws URISyntaxException, IOException {
        //execute a Get request to:
        //https://petstore.swagger.io/v2/pet/findByStatus?status=sold
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uri = new URIBuilder();
        uri.setScheme("https");
        uri.setHost("petstore.swagger.io");
        uri.setPath("v2/pet/findByStatus");
        uri.setCustomQuery("status=sold");

        HttpGet get = new HttpGet(uri.build());
        get.setHeader("Acctep", "application/json");
        HttpResponse response= client.execute(get);
        Assert.assertEquals("application/json",response.getEntity().getContentType().getValue());


    }


}
