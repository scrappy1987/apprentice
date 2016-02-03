package models.services.location;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.ListLocationForFunctionalOrgServiceOperation;
import play.Logger;

/**
 * Created by a613794 on 02/02/2016.
 */
public class LocationService extends Service {

    private static final Logger.ALogger logger = Logger.of(LocationService.class);

    private ListLocationForFunctionalOrgServiceOperation listLocationForFunctionalOrgServiceOperation;
    private JSONHelper jsonHelper;

    @Inject
    public LocationService(ListLocationForFunctionalOrgServiceOperation listLocationForFunctionalOrgServiceOperation,
                           UnavailableServiceOperation unavailableServiceOperation,
                           JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);
        this.listLocationForFunctionalOrgServiceOperation = listLocationForFunctionalOrgServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JsonNode list()
    {
        JsonNode jsonResponse = listLocationForFunctionalOrgServiceOperation.doExecute(jsonHelper.toJson(""));
        return jsonResponse;
    }

    public JsonNode listForFunctionalOrgId(JsonNode functionalOrgId)
    {
        JsonNode jsonResponse = listLocationForFunctionalOrgServiceOperation.execute(functionalOrgId);
        return jsonResponse;
    }
}
