package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.location.LocationService;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by a613794 on 03/02/2016.
 */
public class LocationEndpoint extends ResourceEndpoint<LocationService>
{
        private static final Logger.ALogger logger = Logger.of(LocationEndpoint.class);

    @Inject
    public LocationEndpoint(LocationService locationService)
    {
        super(locationService);
    }

    @Transactional
    public Result list(Long functionalOrgID)
    {
        JsonNode jsonResponse = getService().listForFunctionalOrgId(getIdAsJson(functionalOrgID));

        logger.info("Location: " + new JSONHelper().toJson(jsonResponse));

        return ok(jsonResponse);
    }
}
