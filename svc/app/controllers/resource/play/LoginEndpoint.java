package controllers.resource.play;

import com.google.inject.Inject;
import models.services.login.LoginService;
import play.Logger;

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
}
