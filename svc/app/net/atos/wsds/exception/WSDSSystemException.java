package net.atos.wsds.exception;

import net.atos.wsds.config.PropertiesManager;

/**
 * Created by a614407 on 02/02/2016.
 */
public class WSDSSystemException extends WSDSException {

    public WSDSSystemException(WSDSSystemErrorCodes systemErrorCodes)
    {
        super(systemErrorCodes);
    }

    public WSDSSystemException(WSDSErrorCodes errorCodes, Throwable throwable)
    {
        super(errorCodes, throwable);
    }

    @Override
    public String getErrorCodesFileName()
    {
        return "TODO: In WSDSSystemException";
    }
}
