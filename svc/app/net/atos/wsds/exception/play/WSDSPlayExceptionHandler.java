package net.atos.wsds.exception.play;

import net.atos.wsds.exception.WSDSBusinessException;
import net.atos.wsds.exception.WSDSSystemException;
import play.Configuration;
import play.Environment;
import play.api.UsefulException;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;


/**
 * Created by a614407 on 02/02/2016.
 */
public class WSDSPlayExceptionHandler extends play.http.DefaultHttpErrorHandler {

    WSDSPlayExceptionHandler(Configuration configuration, Environment environment, play.api.OptionalSourceMapper sourceMapper, javax.inject.Provider<play.api.routing.Router> routes)
    {
        super(configuration, environment, sourceMapper, routes);
    }

    @Override
    protected F.Promise<Result> onDevServerError(Http.RequestHeader request, UsefulException exception)
    {
        return handleError(request, exception);
    }

    @Override
    protected F.Promise<Result> onProdServerError(Http.RequestHeader request, UsefulException exception)
    {
        return handleError(request, exception);
    }

    private F.Promise<Result> handleError(Http.RequestHeader request, UsefulException exception)
    {
        if(exception.getCause()instanceof WSDSBusinessException)
        {
            return handleError((WSDSBusinessException)exception.getCause());
        }
        else{
            return handleError((WSDSSystemException)exception.getCause());
        }
    }

    private F.Promise<Result> handleError(WSDSBusinessException exception)
    {
        return F.Promise.<Result>pure(Results.badRequest(exception.getMessage()));
    }

    private F.Promise<Result> handleError(WSDSSystemException exception)
    {
        return F.Promise.<Result>pure(Results.internalServerError(exception.getMessage()));
    }
}
