package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import play.Logger;
/**
 * Created by a613794 on 02/02/2016.
 */
public class FunctionalOrganisationService extends Service
{
    private static final Logger.ALogger logger = Logger.of(FunctionalOrganisationService.class);
    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private UnavailableServiceOperation unavailableServiceOperation;

    @Inject
    public FunctionalOrganisationService(ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation,
                                         UnavailableServiceOperation unavailableServiceOperation)
    {
        super(unavailableServiceOperation);
        this.listFunctionalOrganisationForUserServiceOperation = listFunctionalOrganisationForUserServiceOperation;
        this.unavailableServiceOperation = unavailableServiceOperation;
    }

    public JsonNode listForUser(JsonNode userId)
    {
        JsonNode jsonResponse = listFunctionalOrganisationForUserServiceOperation.doExecute(userId);
        return jsonResponse;
    }
}
