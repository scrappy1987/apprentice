package net.atos.wsds.exception.play;

import net.atos.wsds.config.PropertiesManager;
import net.atos.wsds.exception.WSDSBusinessException;
import net.atos.wsds.exception.WSDSException;
import net.atos.wsds.exception.WSDSSystemException;
import play.Configuration;
import play.Environment;
import play.Logger;
import play.api.UsefulException;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;


/**
 * Created by a614407 on 02/02/2016.
 */
public class WSDSPlayExceptionHandler extends play.http.DefaultHttpErrorHandler {

    private static final Logger.ALogger LOG = Logger.of( WSDSPlayExceptionHandler.class);

    private PropertiesManager propertiesManager;

    @Inject
    WSDSPlayExceptionHandler(Configuration configuration, Environment environment, play.api.OptionalSourceMapper sourceMapper, javax.inject.Provider<play.api.routing.Router> routes, PropertiesManager propertiesManager)
    {
        super(configuration, environment, sourceMapper, routes);

        this.propertiesManager = propertiesManager;
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
        return F.Promise.<Result>pure(Results.badRequest(getExceptionMessage(exception)));
    }

    private F.Promise<Result> handleError(WSDSSystemException exception)
    {
        return F.Promise.<Result>pure(Results.internalServerError(getExceptionMessage(exception)));
    }

    private String getExceptionMessage(WSDSException wsdsException) {
        //Get the filename
        String propFileName = wsdsException.getErrorCodesFileName();
        //Look up the properties manager with the filename and error code
        String errorCodeStr = Integer.toBinaryString(wsdsException.getErrorCode().getErrorCode());

        String errorMessage = propertiesManager.getProperty(propFileName, errorCodeStr);

        LOG.info("Error message being returned is " + errorMessage);

        return errorMessage;
    }
}
