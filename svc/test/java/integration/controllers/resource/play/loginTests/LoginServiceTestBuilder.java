package controllers.resource.play.loginTests;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import models.services.login.CreateLoginServiceOperation;
import org.mockito.Mockito;

/**
 * Created by a614407 on 27/01/2016.
 */
public class LoginServiceTestBuilder {

    private JsonNode mockJsonNode;
    //private UnavailableServiceOperation mockUnavailableServiceOperation;
    private CreateLoginServiceOperation mockCreateLoginServiceOperation;

    public JSONHelper getJsonHelper() {
        return jsonHelper;
    }

    private JSONHelper jsonHelper;


    void LoginTestServiceObject()
    {
        mockJsonNode = Mockito.mock(JsonNode.class);
       // mockUnavailableServiceOperation = Mockito.mock(UnavailableServiceOperation.class);
        mockCreateLoginServiceOperation = Mockito.mock(CreateLoginServiceOperation.class);
        jsonHelper = Mockito.mock(JSONHelper.class);
        Mockito.when(jsonHelper.toJson(mockJsonNode)).thenReturn(mockJsonNode);
       // Mockito.when(mockUnavailableServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
        Mockito.when(mockCreateLoginServiceOperation.execute(mockJsonNode)).thenReturn(mockJsonNode);
    }

    public CreateLoginServiceOperation getMockCreateLoginServiceOperation()
    {
        return mockCreateLoginServiceOperation;
    }

    //public UnavailableServiceOperation getMockUnavailableServiceOperation()
    //{
       // return mockUnavailableServiceOperation;
    //}

    public JsonNode getMockJsonNode()
    {
        return mockJsonNode;
    }
}
