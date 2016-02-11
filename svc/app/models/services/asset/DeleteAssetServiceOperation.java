package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class DeleteAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateAssetServiceOperation.class);

    private AssetDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public DeleteAssetServiceOperation(AssetDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        int id = Integer.parseInt(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ID_PROPERTY).textValue());
        dao.delete(id);
        return jsonHelper.toJson("{\"message\":\"Deleted Asset with id" + id + "\"}");
    }
}
