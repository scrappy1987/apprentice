package models.services.operatingSystem;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;

import javax.inject.Inject;

public class OperatingSystemService extends Service
{
    private ListOperatingSystemOperation listOperatingSystemOperation;

    private JSONHelper jsonHelper;

    @Inject public OperatingSystemService(UnavailableServiceOperation unavailableServiceOperation,
                                          ListOperatingSystemOperation listOperatingSystemOperation,
                                          JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listOperatingSystemOperation = listOperatingSystemOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listOperatingSystemOperation.execute(jsonHelper.toJson(""));
    }
}
