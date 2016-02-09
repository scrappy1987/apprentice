package controllers.resource.play;

import com.google.inject.Inject;
import models.services.brand.BrandService;
import models.services.model.ModelService;
import play.Logger;

public class ModelEndpoint extends ResourceEndpoint<ModelService>
{

    private static final Logger.ALogger logger = Logger.of(ModelEndpoint.class);

    @Inject
    public ModelEndpoint(ModelService modelService)
    {
        super(modelService);
    }
}
