package models.services.location;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.ListContactForLocationServiceOperation;
import play.Logger;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ContactService extends Service
{
    private static final Logger.ALogger logger = Logger.of(ContactService.class);

    private ListContactForLocationServiceOperation listContactForLocationServiceOperation;

    private UnavailableServiceOperation unavailableServiceOperation;

    private JSONHelper jsonHelper;

    @Inject
    public ContactService(ListContactForLocationServiceOperation listContactForLocationServiceOperation,
                          UnavailableServiceOperation unavailableServiceOperation,
                          JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);
        this.listContactForLocationServiceOperation = listContactForLocationServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        JsonNode jsonResponse = listContactForLocationServiceOperation.doExecute(jsonHelper.toJson(""));
        return jsonResponse;
    }

    public JsonNode listForLocation(JsonNode locationId)
    {
        JsonNode jsonResponse = listContactForLocationServiceOperation.doExecute(locationId);
        return jsonResponse;
    }
}
