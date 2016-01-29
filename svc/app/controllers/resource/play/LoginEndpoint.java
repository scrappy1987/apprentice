package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.services.Service;
import models.services.login.LoginService;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Result;

/**
 * Created by a614407 on 27/01/2016.
 */
public class LoginEndpoint extends ResourceEndpoint<LoginService>{

    private static final Logger.ALogger logger = Logger.of(LoginEndpoint.class);

    @Inject
    public LoginEndpoint(LoginService loginService)
    {
        super(loginService);
    }


    public Result login()
    {
        JsonNode jsonResponse = getService().create(request().body().asJson());
        return ok(jsonResponse);
    }
}
