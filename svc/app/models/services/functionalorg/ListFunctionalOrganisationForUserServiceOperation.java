package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.impl.UserDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.User;
import models.services.ServiceOperation;
import play.Logger;
import javax.inject.Inject;

/**
 * Created by a613794 on 29/01/2016.
 */
public class ListFunctionalOrganisationForUserServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListFunctionalOrganisationForUserServiceOperation.class);

    private FunctionalOrganisationDao functionalOrganisationDao;

    private JSONHelper jsonHelper;

    private UserDao userDao;

    @Inject
    public ListFunctionalOrganisationForUserServiceOperation(FunctionalOrganisationDao functionalOrganisationDao, JSONHelper jsonHelper, UserDao userDao)
    {
        this.userDao = userDao;
        this.functionalOrganisationDao = functionalOrganisationDao;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {
        User user = userDao.find(jsonRequest.asLong());
        JsonNode jsonResponse = jsonHelper.toJson(functionalOrganisationDao.findFunctionalOrganisationsForUser(user));
        return jsonResponse;
    }
}
