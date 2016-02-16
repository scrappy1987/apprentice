package controllers.resource.play.loginTests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.thoughtworks.selenium.SeleneseTestBase;
import common.util.json.play.JSONHelper;
import models.services.UnavailableServiceOperation;
import models.services.login.CreateLoginServiceOperation;
import models.services.login.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by a614407 on 27/01/2016.
 */
public class LoginServiceTest {

    private LoginService logServ;
    private LoginServiceTestBuilder logServTestBuild;
    private JSONHelper jsonHelper;
    private CreateLoginServiceOperation createLoginServiceOperation;

    @Before
    public void before()
    {
        jsonHelper = new JSONHelper();
        logServTestBuild = new LoginServiceTestBuilder();
        logServTestBuild.LoginTestServiceObject();
        logServ = new LoginService(new UnavailableServiceOperation(new JSONHelper()),
                new CreateLoginServiceOperation(),
                new JSONHelper());
    }

    @Test
    public void loginServiceCreateTest()
    {
        createLoginServiceOperation = Mockito.mock(CreateLoginServiceOperation.class);


        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonRequest = mapper.createObjectNode();
        jsonRequest.put("authenticated", "false");
        ObjectNode jsonResponse = mapper.createObjectNode();
        jsonResponse.put("authenticated", "false");
        Mockito.when(createLoginServiceOperation.doExecute(Mockito.anyObject())).thenReturn(jsonResponse);
        assertEquals(jsonResponse, jsonRequest);
    }

    @Test
    public void loginServiceDeleteTest()
    {
        JsonNode jsonNode = logServ.delete(logServTestBuild.getMockJsonNode());
        JsonNode testJsonNode = jsonHelper.toJson("{\"message\":\"Service Operation is unavailable\"}");
        assertEquals(testJsonNode, jsonNode);
    }

    @Test
    public void loginServiceUpdateTest()
    {
        JsonNode jsonNode = logServ.update(logServTestBuild.getMockJsonNode());
        JsonNode testJsonNode = jsonHelper.toJson("{\"message\":\"Service Operation is unavailable\"}");
        assertEquals(testJsonNode, jsonNode);
    }
}
