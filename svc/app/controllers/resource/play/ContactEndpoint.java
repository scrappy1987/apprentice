package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.location.ContactService;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ContactEndpoint extends ResourceEndpoint<ContactService>
{

    private static final Logger.ALogger logger = Logger.of(ContactEndpoint.class);

    @Inject
    public ContactEndpoint(ContactService contactService)
    {
        super(contactService);
    }

    @Transactional
    public Result list(Long locationId)
    {
        JsonNode jsonResponse = getService().listForLocation(getIdAsJson(locationId));
        return ok(jsonResponse);
    }
}
