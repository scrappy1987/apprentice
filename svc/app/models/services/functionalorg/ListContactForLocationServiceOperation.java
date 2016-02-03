package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.ContactDao;
import models.persistence.dao.impl.LocationDao;
import models.persistence.entities.Contact;
import models.persistence.entities.Location;
import models.services.ServiceOperation;
import play.Logger;

import java.util.List;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ListContactForLocationServiceOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListContactForLocationServiceOperation.class);

    private ContactDao contactDao;

    private JSONHelper jsonHelper;

    private LocationDao locationDao;

    @Inject
    public ListContactForLocationServiceOperation(ContactDao contactDao, LocationDao locationDao, JSONHelper jsonHelper)
    {
        this.contactDao = contactDao;
        this.locationDao = locationDao;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {

        Location location = locationDao.find(jsonRequest.path("id").asInt());

        Logger.info("LOCATIN: ******* " + jsonHelper.toJson(location));

        List<Contact> contacts = contactDao.findContactsForLocation(location);
        JsonNode jsonResponse = jsonHelper.toJson(contacts);
        return jsonResponse;
    }
}
