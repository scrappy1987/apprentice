package net.atos.wsds.exception;

import net.atos.wsds.config.PropertiesManager;

/**
 * Created by a614407 on 02/02/2016.
 */
public class WSDSBusinessException extends WSDSException {

     public WSDSBusinessException(WSDSBusinessErrorCodes businessErrorCodes)
    {
        super(businessErrorCodes);
    }

    public WSDSBusinessException(WSDSErrorCodes errorCodes, Throwable throwable)
    {
        super(errorCodes, throwable);
    }

    @Override
    public String getErrorCodesFileName()
    {
        return "Todo: In WSDSBusinessException";
    }
}
