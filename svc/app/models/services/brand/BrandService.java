package models.services.brand;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import javax.inject.Inject;

public class BrandService extends Service
{
    private ListBrandServiceOperation listBrandServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public BrandService(UnavailableServiceOperation unavailableServiceOperation,
                                ListBrandServiceOperation listBrandServiceOperation,
                                JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listBrandServiceOperation = listBrandServiceOperation;
        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listBrandServiceOperation.execute(jsonHelper.toJson(""));
    }
}
