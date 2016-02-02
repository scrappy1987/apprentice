package models.services.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;

/**
 * Created by a614407 on 26/01/2016.
 */
public class LoginService extends Service{

    private CreateLoginServiceOperation loginServiceOperation;

    private JSONHelper jsonHelper;

    @Inject
    public LoginService(UnavailableServiceOperation unavailableServiceOperation,
                          CreateLoginServiceOperation loginServiceOperation,
                        JSONHelper jsonHelper)
    {
    super(unavailableServiceOperation);

        this.loginServiceOperation = loginServiceOperation;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode create(JsonNode jsonNode)
    {
        System.out.println(jsonNode);
        return loginServiceOperation.doExecute(jsonNode);
    }

    @Override
    public JsonNode list()
    {
        return loginServiceOperation.doExecute(jsonHelper.toJson(""));
    }
   }
