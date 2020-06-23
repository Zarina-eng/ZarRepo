package API.GetRequestPractice;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Get1 {
    /*
    1. Open a client (POASTMAN, terminal)
	2. 2.Specify the HTTP method(GET,POST)
	3. 3.Specify URL/URI endpoint
	4. Add query parameter(if needed)
	5. Add header parameters(content-type, accept)
	6. Add body parameter (for POST)
	7. Execute (click on Send button)

	https://www.google.com 	-> base URL
    /search 				-> path parameter
    ?newwindow=1 			-> query paramter
     */

    @Test
    public void Get1() throws URISyntaxException, IOException {
  //     HttpClient client = HttpClientBuilder().create().build();
        URIBuilder uri=new URIBuilder();
        uri.setScheme("https");
        uri.setHost("www.youtube.com");
        uri.setPath("/watch?v=QQVa4xCf8JY");
        HttpGet get= new HttpGet((uri.build()));
        get.setHeader("Acctep", "application/json");
      //  HttpResponse response= client.execute(get);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());

    }
}
