package TestClient;

import DataAPI.Users;
import TestBaseAPI.TestBase;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PostTest extends TestBase {
    TestBase test;
    GetClient GC;


    @BeforeMethod
    public void setUp() {
        test = new TestBase();
    }


    @Test
    public void pangrampost() throws IOException {
        GC = new GetClient();
        GC.get(prop.getProperty("url"));
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("pangram");
        mapper.writeValue(new File("/Users/mcseagate/IdeaProjects/Pangram_API_Test/src/pangram.json"), users);

    }




}
