package models.services.status;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;

import javax.inject.Inject;

public class StatusService extends Service
{
    private ListStatusServiceOperation listStatusServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public StatusService(UnavailableServiceOperation unavailableServiceOperation,
                                 ListStatusServiceOperation listStatusServiceOperation,
                                 JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listStatusServiceOperation = listStatusServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listStatusServiceOperation.execute(jsonHelper.toJson(""));
    }
}
