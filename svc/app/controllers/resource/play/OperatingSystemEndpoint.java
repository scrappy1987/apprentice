package controllers.resource.play;

import com.google.inject.Inject;
import models.services.model.ModelService;
import models.services.operatingSystem.OperatingSystemService;
import play.Logger;

public class OperatingSystemEndpoint extends ResourceEndpoint<OperatingSystemService>
{

    private static final Logger.ALogger logger = Logger.of(OperatingSystemEndpoint.class);

    @Inject
    public OperatingSystemEndpoint(OperatingSystemService operatingSystemService)
    {
        super(operatingSystemService);
    }
}
