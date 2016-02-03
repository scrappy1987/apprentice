package net.atos.wsds.exception;

/**
 * Created by a614407 on 02/02/2016.
 */
abstract class WSDSException extends RuntimeException {

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

    //TO-DO Get checked
    @Override
    public String getMessage()
    {
        return getErrorCodesFileName();
    }

    protected abstract String getErrorCodesFileName();
}
