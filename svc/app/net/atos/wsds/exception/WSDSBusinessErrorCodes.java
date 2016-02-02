package net.atos.wsds.exception;

/**
 * Created by a614407 on 01/02/2016.
 */
public enum WSDSBusinessErrorCodes implements WSDSErrorCodes {


    CONTACT_NOT_FOUND(9000) {
        @Override
        public int getErrorCode() {
            return 9000;
        }
    },
    LOCATION_NOT_FOUND(9001) {
        @Override
        public int getErrorCode() {
            return 9001;
        }
    };

    WSDSBusinessErrorCodes(int errorCode)
    {

    }
}
