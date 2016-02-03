package controllers.resource.play;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.util.json.play.JSONHelper;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.FunctionalOrganisationService;
import models.services.functionalorg.ListFunctionalOrganisationForUserServiceOperation;
import models.services.functionalorg.ListFunctionalOrganisationServiceOperation;
import org.mockito.Mockito;

/**
 * Created by a613794 on 01/02/2016.
 */
public class FunctionalOrganisationEndpointTestBuilder {

    private FunctionalOrganisationService functionalOrganisationService;
    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private ListFunctionalOrganisationServiceOperation listFunctionalOrganisationServiceOperation;
    private ObjectNode jsonResponse;
    private FunctionalOrganisationEndpoint functionalOrganisationEndpoint;

    public void createTestObjects()
    {
        createJsonResponse();
        createFunctionalOrganisationEndpoint();
    }

    private void createJsonResponse()
    {
        ObjectMapper mapper = new ObjectMapper();
        jsonResponse = mapper.createObjectNode();
        jsonResponse.put("test", "test");
    }

    private void createFunctionalOrganisationEndpoint()
    {
        listFunctionalOrganisationForUserServiceOperation = Mockito.mock(ListFunctionalOrganisationForUserServiceOperation.class);
        listFunctionalOrganisationServiceOperation = Mockito.mock(ListFunctionalOrganisationServiceOperation.class);
        functionalOrganisationService =  new FunctionalOrganisationService(listFunctionalOrganisationForUserServiceOperation, listFunctionalOrganisationServiceOperation, new UnavailableServiceOperation(new JSONHelper()), new JSONHelper());
        functionalOrganisationEndpoint = new FunctionalOrganisationEndpoint(functionalOrganisationService);
        Mockito.when(functionalOrganisationEndpoint.getService().listForUser(Mockito.anyObject())).thenReturn(jsonResponse);
    }

    public ObjectNode getJsonResponse() {
        return jsonResponse;
    }

    public FunctionalOrganisationEndpoint getFunctionalOrganisationEndpoint() {
        return functionalOrganisationEndpoint;
    }
}
