package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.util.json.play.JSONHelper;
import models.services.UnavailableServiceOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * Created by a613794 on 01/02/2016.
 */
public class FunctionalOrganisationServiceTest {

    private FunctionalOrganisationService functionalOrganisationService;
    private JsonNode userId;
    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private ObjectNode jsonResponse;

    @Test
    public void listForUserTest()
    {
        createTestObjects();
        Assert.assertEquals(jsonResponse, functionalOrganisationService.listForUser(userId));
    }

    private void createTestObjects()
    {
        createJsonResponse();
        userId = new JSONHelper().toJson(1L);
        listFunctionalOrganisationForUserServiceOperation = Mockito.mock(ListFunctionalOrganisationForUserServiceOperation.class);
        functionalOrganisationService = new FunctionalOrganisationService(listFunctionalOrganisationForUserServiceOperation, new UnavailableServiceOperation(new JSONHelper()));
        Mockito.when(listFunctionalOrganisationForUserServiceOperation.doExecute(userId)).thenReturn(jsonResponse);
    }

    private void createJsonResponse()
    {
        ObjectMapper mapper = new ObjectMapper();
        jsonResponse = mapper.createObjectNode();
        jsonResponse.put("test", "test");
    }
}
