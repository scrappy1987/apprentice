package models.services.brand;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.BrandDao;
import models.services.ServiceOperation;
import play.Logger;

public class ListBrandServiceOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListBrandServiceOperation.class);

    private BrandDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListBrandServiceOperation(BrandDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;
        this.jsonHelper = jsonHelper;
    }

    @Override
    public JsonNode doExecute(JsonNode jsonRequest)
    {
        JsonNode jsonResponse = jsonHelper.toJson(dao.list());
        return jsonResponse;
    }
}
