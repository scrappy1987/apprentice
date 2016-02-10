package models.services.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.StatusDao;
import models.services.ServiceOperation;
import play.Logger;

public class ListStatusServiceOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListStatusServiceOperation.class);

    private StatusDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListStatusServiceOperation(StatusDao dao, JSONHelper jsonHelper)
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
