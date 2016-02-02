package net.atos.wsds.exception;

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
        super(errorCodes);
    }

    @Override
    protected String getErrorCodesFileName()
    {
        return "TODO: In WSDSSystemException";
    }
}
