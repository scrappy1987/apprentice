package net.atos.wsds.exception;

import net.atos.wsds.config.PropertiesManager;
import play.Logger;

/**
 * Created by a614407 on 02/02/2016.
 */
public abstract class WSDSException extends RuntimeException {
    private static final Logger.ALogger LOG = Logger.of( WSDSException.class);

    private WSDSErrorCodes errorCode;

    public WSDSException(WSDSErrorCodes errorCode){
        this.errorCode = errorCode;
    }

    public WSDSException(WSDSErrorCodes errorCode, Throwable throwable)
    {
        this.errorCode = errorCode;
    }


    public WSDSErrorCodes getErrorCode()
    {
        return errorCode;
    }

    public abstract String getErrorCodesFileName();
}
