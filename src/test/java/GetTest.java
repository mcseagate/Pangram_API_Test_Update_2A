import TestBaseAPI.TestBase;
import TestClient.GetClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetTest extends TestBase{
    TestBase test;
    GetClient GC;


    public GetTest(){
        super();
    }



    @BeforeMethod
    public void setUp(){
      test = new TestBase();
    }


    @Test
    public void GetResponse() throws IOException {
        GC = new GetClient();
        GC.get(prop.getProperty("url"));
    }
}
