package models.services.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import models.services.ServiceOperation;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

/**
 * Created by a614407 on 26/01/2016.
 * Credit to Bob
 */

public class CreateLoginServiceOperation extends ServiceOperation{

    private HashMap<String, String> wsdsUsers = new HashMap<>();
    private static final Logger logger = Logger.getLogger(CreateLoginServiceOperation.class.getName());
    private String username;

    @Inject
    public CreateLoginServiceOperation() {
        wsdsUsers.put("user1@atos.net", "password1");
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonResponse = mapper.createObjectNode();
        boolean authenticated = isAuthenticated(jsonRequest);
        if (authenticated) {
            jsonResponse.put("authenticated", "true");
            logger.info("PASSWORD ACCEPTED");
        }
        else {
            jsonResponse.put("authenticated", "false");
            logger.info("INCORRECT PASSWORD");
        }
        return jsonResponse;
    }


    private boolean isAuthenticated(JsonNode jsonRequest)
    {
        Object[] keySet = wsdsUsers.keySet().toArray();
        if (usernameFound(jsonRequest, keySet) && passwordMatches(jsonRequest))
            return true;
        return false;
    }

    private boolean usernameFound(JsonNode jsonRequest, Object[] keySet)
    {
        for (int key = 0; key < wsdsUsers.size(); key++)
        {
            username = (String ) keySet[key];
            if(jsonRequest.get("username").asText().equals(username))
                return true;
        }
        return false;
    }

    private boolean passwordMatches(JsonNode jsonRequest)
    {
        String password = jsonRequest.findValue("password").textValue();
        if (password.equals(wsdsUsers.get(username)))
            return true;
        return false;
    }
}