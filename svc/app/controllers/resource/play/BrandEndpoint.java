package controllers.resource.play;

import com.google.inject.Inject;
import models.services.brand.BrandService;
import play.Logger;

public class BrandEndpoint extends ResourceEndpoint<BrandService>
{

    private static final Logger.ALogger logger = Logger.of(BrandEndpoint.class);

    @Inject
    public BrandEndpoint(BrandService brandService)
    {
        super(brandService);
    }
}
