package controllers.resource.play.loginTests;

import controllers.EndpointTest;
import controllers.EndpointTestCase;
import controllers.resource.play.LoginEndpoint;
import org.junit.Test;

import static play.test.Helpers.inMemoryDatabase;

/**
 * Created by a614407 on 27/01/2016.
 */
public class LoginEndpointTest extends EndpointTest {

    @Test
    public void testCreateServices()
    {
        EndpointTestCase testCase = new controllers.resource.play.CreateAssetTestCase();
        runEndpointTest(testCase, inMemoryDatabase());
    }
}
