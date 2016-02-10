package models.services.propertyType;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;

import javax.inject.Inject;

public class PropertyTypeService extends Service
{
    private ListPropertyTypeServiceOperation listPropertyTypeServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public PropertyTypeService(UnavailableServiceOperation unavailableServiceOperation,
                                       ListPropertyTypeServiceOperation listPropertyTypeServiceOperation,
                                       JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listPropertyTypeServiceOperation = listPropertyTypeServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listPropertyTypeServiceOperation.execute(jsonHelper.toJson(""));
    }
}
