package controllers.resource.play;


import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.entities.Brand;
import models.services.functionalorg.FunctionalOrganisationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static play.mvc.Results.ok;

/**
 * Created by a613794 on 29/01/2016.
 */
public class FunctionalOrganisationEndpointTest {

    private JsonNode jsonResponse;
    private FunctionalOrganisationEndpoint functionalOrganisationEndpoint;

    @Before
    public void before()
    {
        FunctionalOrganisationEndpointTestBuilder builder = new FunctionalOrganisationEndpointTestBuilder();
        builder.createTestObjects();
        jsonResponse = builder.getJsonResponse();
        functionalOrganisationEndpoint = builder.getFunctionalOrganisationEndpoint();
    }

    @Test
    public void listTest()
    {
        Assert.assertEquals(ok(jsonResponse).toString(), functionalOrganisationEndpoint.list(1L).toString());
    }


}
