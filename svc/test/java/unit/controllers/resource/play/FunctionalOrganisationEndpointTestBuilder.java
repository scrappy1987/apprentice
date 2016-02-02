package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.play.EntityManagerProvider;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.FunctionalOrganisationService;
import models.services.functionalorg.ListFunctionalOrganisationForUserServiceOperation;
import models.services.functionalorg.ListFunctionalOrganisationServiceOperation;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by a613794 on 01/02/2016.
 */
public class FunctionalOrganisationEndpointTestBuilder {

    private FunctionalOrganisationService functionalOrganisationService;
    private EntityManagerProvider emp;
    private EntityManager em;
    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private ListFunctionalOrganisationServiceOperation listFunctionalOrganisationServiceOperation;
    private ObjectNode jsonResponse;
    private JsonNode userId;
    private FunctionalOrganisationEndpoint functionalOrganisationEndpoint;

    public void createTestObjects()
    {
        createMockObjects();
        createJsonResponse();
        createUserIdJsonNode();
        createFunctionalOrganisationEndpoint();
    }

    private void createMockObjects()
    {
        em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
        listFunctionalOrganisationForUserServiceOperation = Mockito.mock(ListFunctionalOrganisationForUserServiceOperation.class);
    }

    private void createJsonResponse()
    {
        ObjectMapper mapper = new ObjectMapper();
        jsonResponse = mapper.createObjectNode();
        jsonResponse.put("test", "test");
    }

    private void createUserIdJsonNode()
    {
        JSONHelper jsonHelper = new JSONHelper();
        userId = jsonHelper.toJson(1L);
    }

    private void createFunctionalOrganisationEndpoint()
    {
        listFunctionalOrganisationServiceOperation = Mockito.mock(ListFunctionalOrganisationServiceOperation.class);
        functionalOrganisationService =  new FunctionalOrganisationService(listFunctionalOrganisationForUserServiceOperation, listFunctionalOrganisationServiceOperation, new UnavailableServiceOperation(new JSONHelper()), new JSONHelper());
        functionalOrganisationEndpoint = new FunctionalOrganisationEndpoint(functionalOrganisationService);
        Mockito.when(functionalOrganisationEndpoint.getService().listForUser(userId)).thenReturn(jsonResponse);
    }

    public ObjectNode getJsonResponse() {
        return jsonResponse;
    }

    public FunctionalOrganisationEndpoint getFunctionalOrganisationEndpoint() {
        return functionalOrganisationEndpoint;
    }
}
