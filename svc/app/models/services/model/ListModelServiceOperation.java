package models.services.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.BrandDao;
import models.persistence.dao.impl.ModelDao;
import models.services.ServiceOperation;
import play.Logger;

public class ListModelServiceOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListModelServiceOperation.class);

    private ModelDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListModelServiceOperation(ModelDao dao, JSONHelper jsonHelper)
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
