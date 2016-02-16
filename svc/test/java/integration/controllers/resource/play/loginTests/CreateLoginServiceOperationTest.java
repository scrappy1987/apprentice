package controllers.resource.play.loginTests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.services.login.CreateLoginServiceOperation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by a614407 on 27/01/2016.
 */
public class CreateLoginServiceOperationTest {

    CreateLoginServiceOperation loginOp = new CreateLoginServiceOperation();

    private ObjectNode jsonNode;
    private ObjectNode responseNode;

    @Before
    public void before()
    {
        ObjectMapper mapper = new ObjectMapper();
        jsonNode = mapper.createObjectNode();
        responseNode = mapper.createObjectNode();
    }

    @Test
    public void testReturnTrue()
    {
        responseNode.put("authenticated", "true");
        jsonNode.put("username","user1@atos.net");
        jsonNode.put("password","password1");
        assertEquals(responseNode,loginOp.doExecute(jsonNode));
    }

    @Test
    public void testReturnFalse()
    {
        responseNode.put("authenticated", "false");
        jsonNode.put("username", "invalidUserName@notValid.net");
        jsonNode.put("password","pass2");
        assertEquals(responseNode,loginOp.doExecute(jsonNode));
    }
}
