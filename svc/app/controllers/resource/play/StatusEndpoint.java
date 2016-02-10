package controllers.resource.play;

import com.google.inject.Inject;
import models.services.status.StatusService;
import play.Logger;

public class StatusEndpoint extends ResourceEndpoint<StatusService>
{

    private static final Logger.ALogger logger = Logger.of(StatusEndpoint.class);

    @Inject
    public StatusEndpoint(StatusService statusService)
    {
        super(statusService);
    }
}
