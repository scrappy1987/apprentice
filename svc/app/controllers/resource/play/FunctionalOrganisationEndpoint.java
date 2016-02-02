package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.services.functionalorg.FunctionalOrganisationService;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;
/**
 * Created by a613794 on 02/02/2016.
 */
public class FunctionalOrganisationEndpoint extends ResourceEndpoint<FunctionalOrganisationService>
{

    private static final Logger.ALogger logger = Logger.of(FunctionalOrganisationEndpoint.class);

    @Inject
    public FunctionalOrganisationEndpoint(FunctionalOrganisationService functionalOrganisationService)
    {
        super(functionalOrganisationService);
    }

    @Transactional public Result list(Long userId)
    {
        JsonNode jsonResponse = getService().listForUser(new JSONHelper().toJson(userId));
        return ok(jsonResponse);
    }
}