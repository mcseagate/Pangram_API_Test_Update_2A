package TestClient;


import TestBaseAPI.TestBase;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import sun.text.normalizer.UTF16;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class GetClient extends TestBase {
    CloseableHttpClient httpclient;


    public void get(String url) throws IOException {
        httpclient = HttpClients.createDefault();
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

    public CloseableHttpResponse post(String url, String entity, HashMap<String, String> headermap) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        httpPost.setEntity(new StringEntity(entity));


        for (Map.Entry<String, String> entry: headermap.entrySet()){
            httpPost.addHeader(entry.getKey(), (String) entry.getValue());
        }

        CloseableHttpResponse closeablehttpresponse = httpclient.execute(httpPost);
        return closeablehttpresponse;

    }

}
