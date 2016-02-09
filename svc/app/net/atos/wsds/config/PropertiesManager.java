package net.atos.wsds.config;

import net.atos.wsds.exception.WSDSSystemErrorCodes;
import net.atos.wsds.exception.WSDSSystemException;
import play.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by a614407 on 03/02/2016.
 */
public class PropertiesManager {

    private static final Logger.ALogger LOG = Logger.of( PropertiesManager.class);

    private Map<String, Properties> wsdsProperties = new HashMap<String, Properties>();

    public PropertiesManager() {

        String baseFolderName = System.getProperty("net.atos.wsds.property.files.folder");

        File baseFolder = new File(baseFolderName);

        if (baseFolder.isDirectory()) {
            //Get files in folder
            LOG.info("In config directory");
            for (File file : baseFolder.listFiles()) {
                String fileName = file.getName();
                LOG.info("Properties File " + fileName);
                Properties props = getProperties(baseFolderName, fileName);
                wsdsProperties.put(fileName, props);
                LOG.info("Added properties for " + fileName);
            }
        }

        displayProperties();
    }

    private Properties getProperties(String baseFolder, String fileName) {
        Properties props = new Properties();

        String propsFileName = baseFolder + File.separatorChar + fileName;

        LOG.info("Properties File Absolute Path " + propsFileName);

        File propsFile = new File(propsFileName);

        try {
            if (propsFile.exists()) {
                props.load(new FileInputStream(new File(propsFileName)));
            } else {
                throw new WSDSSystemException(WSDSSystemErrorCodes.PROPERTIES_NOT_FOUND);
            }
        } catch (IOException e) {
            throw new WSDSSystemException(WSDSSystemErrorCodes.PROPERTIES_NOT_FOUND, e);
        }

        return props;
    }

    public String getProperty(String fileName, String propName) {
            return (String) wsdsProperties.get(fileName).get(propName);
    }

    private void displayProperties() {
        for (String fileName: wsdsProperties.keySet()) {
            LOG.info("Property File " + fileName + " on wsdsProperties map");

            Properties props = wsdsProperties.get(fileName);

            for (Object propKey: props.keySet()) {
                LOG.info("PropKey: " + propKey + " PropValue: " + props.get(propKey));
            }

        }
    }
}

