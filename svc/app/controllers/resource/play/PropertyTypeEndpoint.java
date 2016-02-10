package controllers.resource.play;

import com.google.inject.Inject;
import models.services.propertyType.PropertyTypeService;
import play.Logger;

public class PropertyTypeEndpoint extends ResourceEndpoint<PropertyTypeService>
{

    private static final Logger.ALogger logger = Logger.of(PropertyTypeEndpoint.class);

    @Inject
    public PropertyTypeEndpoint(PropertyTypeService propertyTypeService)
    {
        super(propertyTypeService);
    }
}
