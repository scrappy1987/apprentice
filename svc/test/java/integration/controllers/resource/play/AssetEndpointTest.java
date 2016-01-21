package controllers.resource.play;

import controllers.EndpointTest;
import controllers.EndpointTestCase;
import org.junit.Test;

import static play.test.Helpers.inMemoryDatabase;

public class AssetEndpointTest extends EndpointTest
{
    @Test public void testCreateProjects()
    {
        EndpointTestCase testCase = new controllers.resource.play.CreateAssetTestCase();

        runEndpointTest(testCase, inMemoryDatabase());
    }
}
