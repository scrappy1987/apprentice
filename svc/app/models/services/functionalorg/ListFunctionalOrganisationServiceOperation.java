package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.impl.UserDao;
import models.persistence.entities.User;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

/**
 * Created by a613794 on 29/01/2016.
 */
public class ListFunctionalOrganisationServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListFunctionalOrganisationServiceOperation.class);

    private FunctionalOrganisationDao functionalOrganisationDao;

    private JSONHelper jsonHelper;

    @Inject
    public ListFunctionalOrganisationServiceOperation(FunctionalOrganisationDao functionalOrganisationDao,
                                                      JSONHelper jsonHelper)
    {
        this.functionalOrganisationDao = functionalOrganisationDao;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {
        JsonNode jsonResponse = jsonHelper.toJson(functionalOrganisationDao.list());
        return jsonResponse;
    }
}
