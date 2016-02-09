package models.services.operatingSystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.ModelDao;
import models.persistence.dao.impl.OperatingSystemDao;
import models.services.ServiceOperation;
import play.Logger;

public class ListOperatingSystemOperation extends ServiceOperation {

    private static final Logger.ALogger logger = Logger.of(ListOperatingSystemOperation.class);

    private OperatingSystemDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListOperatingSystemOperation(OperatingSystemDao dao, JSONHelper jsonHelper)
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
