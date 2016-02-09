package models.services.model;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;

import javax.inject.Inject;

public class ModelService extends Service
{
    private ListModelServiceOperation listModelServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public ModelService(UnavailableServiceOperation unavailableServiceOperation,
                                ListModelServiceOperation listModelServiceOperation,
                                JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listModelServiceOperation = listModelServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listModelServiceOperation.execute(jsonHelper.toJson(""));
    }
}
