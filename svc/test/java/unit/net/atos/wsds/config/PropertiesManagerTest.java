package net.atos.wsds.config;

import net.atos.wsds.exception.WSDSBusinessErrorCodes;
import net.atos.wsds.exception.WSDSBusinessException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by a614407 on 09/02/2016.
 */
public class PropertiesManagerTest {

    @Test
    public void testPropertiesManager() {

        System.setProperty("net.atos.wsds.property.files.folder", "C:\\wsds_config");

        PropertiesManager propsManager = new PropertiesManager();
    }


  /*  //TODO - REMOVE - just for testing

    if (true) {
        throw new WSDSBusinessException(WSDSBusinessErrorCodes.CONTACT_NOT_FOUND);
    }*/
}
