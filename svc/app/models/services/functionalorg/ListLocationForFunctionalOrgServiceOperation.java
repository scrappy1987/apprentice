package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.impl.LocationDao;
import models.persistence.entities.FunctionalOrganisation;
import models.persistence.entities.Location;
import models.services.ServiceOperation;
import play.Logger;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by a613794 on 02/02/2016.
 */

public class ListLocationForFunctionalOrgServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListLocationForFunctionalOrgServiceOperation.class);

    private LocationDao locationDao;

    private FunctionalOrganisationDao functionalOrganisationDao;

    private JSONHelper jsonHelper;

    @Inject
    public ListLocationForFunctionalOrgServiceOperation(LocationDao locationDao, FunctionalOrganisationDao functionalOrganisationDao, JSONHelper jsonHelper)
    {
        this.locationDao = locationDao;
        this.jsonHelper = jsonHelper;
        this.functionalOrganisationDao = functionalOrganisationDao;
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {
        FunctionalOrganisation functionalOrganisation = functionalOrganisationDao.find(jsonRequest.path("id").asInt());
        List<Location> locations = locationDao.findLocationsForFunctionalOrganisation(functionalOrganisation);
        JsonNode jsonResponse = jsonHelper.toJson(locations);
        return jsonResponse;
    }
}

