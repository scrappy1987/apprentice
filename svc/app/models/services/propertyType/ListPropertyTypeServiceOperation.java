package models.services.propertyType;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.PropertyTypeDao;
import models.services.ServiceOperation;
import play.Logger;

public class ListPropertyTypeServiceOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListPropertyTypeServiceOperation.class);

    private PropertyTypeDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListPropertyTypeServiceOperation(PropertyTypeDao dao, JSONHelper jsonHelper)
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
