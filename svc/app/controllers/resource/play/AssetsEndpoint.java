package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import models.services.asset.AssetService;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;

import javax.inject.Inject;

public class AssetsEndpoint extends ResourceEndpoint<AssetService>
{
    private static final Logger.ALogger logger = Logger.of(AssetsEndpoint.class);

    @Inject public AssetsEndpoint(AssetService projectService)
    {
        super(projectService);
    }


    // GET {path}/contact/:id/asset
    @Transactional public Result list(Long parentId)
    {
        JsonNode jsonResponse = getService().listForContact(getIdAsJson(parentId));

        return ok(jsonResponse);
    }
}
