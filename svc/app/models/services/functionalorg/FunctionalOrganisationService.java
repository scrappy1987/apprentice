package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import play.Logger;


/**
 * Created by a613794 on 29/01/2016.
 */
public class FunctionalOrganisationService extends Service {

    private static final Logger.ALogger logger = Logger.of(FunctionalOrganisationService.class);
    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private ListFunctionalOrganisationServiceOperation listFunctionalOrganisationServiceOperation;
    private UnavailableServiceOperation unavailableServiceOperation;
    private JSONHelper jsonHelper;

    @Inject
    public FunctionalOrganisationService(ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation,
                                         ListFunctionalOrganisationServiceOperation listFunctionalOrganisationServiceOperation,
                                         UnavailableServiceOperation unavailableServiceOperation,
                                         JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);
        this.listFunctionalOrganisationForUserServiceOperation = listFunctionalOrganisationForUserServiceOperation;
        this.listFunctionalOrganisationServiceOperation = listFunctionalOrganisationServiceOperation;
        this.unavailableServiceOperation = unavailableServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        JsonNode jsonResponse = listFunctionalOrganisationServiceOperation.doExecute(jsonHelper.toJson(""));
        return jsonResponse;
    }

    public JsonNode listForUser(JsonNode userId)
    {
        JsonNode jsonResponse = listFunctionalOrganisationForUserServiceOperation.doExecute(userId);
        return jsonResponse;
    }
}
