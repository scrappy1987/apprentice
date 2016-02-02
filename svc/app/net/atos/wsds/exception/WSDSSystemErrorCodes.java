package net.atos.wsds.exception;

/**
 * Created by a614407 on 01/02/2016.
 */
public enum  WSDSSystemErrorCodes implements WSDSErrorCodes {

       WSDS_SERVER_ERROR(1000), NETWORK_ERROR(1001), PROPERTIES_NOT_FOUND(1002),   SERVICE_UNREACHABLE_ERROR(1003);

    WSDSSystemErrorCodes(int errorCode)
    {
        this.errorCode = errorCode;
    }

    private final int errorCode;

    @Override
    public int getErrorCode()
    {
        return errorCode;
    }


    }

