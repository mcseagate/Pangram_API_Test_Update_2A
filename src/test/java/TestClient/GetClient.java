package TestClient;


import TestBaseAPI.TestBase;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import sun.text.normalizer.UTF16;

import java.io.IOException;
import java.util.HashMap;

public class GetClient extends TestBase {


    public void get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse closeablehttpresponse = httpclient.execute(httpget);
        int statuscode = closeablehttpresponse.getStatusLine().getStatusCode();
        System.out.println("Status Response Code is: " + statuscode);
        String responsestring = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
        JSONObject jsonresponse = new JSONObject(responsestring);
        System.out.println("Response JSON from API:" + jsonresponse);
        Header[] headersArray = closeablehttpresponse.getAllHeaders();
        HashMap<String, String> allheaders = new HashMap<String, String>();

        for (Header header : headersArray){
            allheaders.put(header.getName(), header.getValue());
        }

        System.out.println("Headers Array:" + allheaders);

    }
}
