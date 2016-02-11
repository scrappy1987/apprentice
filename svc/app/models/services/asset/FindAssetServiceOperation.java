package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.Asset;
import models.persistence.entities.Location;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class FindAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindAssetServiceOperation.class);

    private AssetDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public FindAssetServiceOperation(AssetDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Asset asset = dao.find(jsonRequest.path("id").asInt());
        jsonRequest = (asset == null) ? jsonHelper.toJson(new Asset()) : jsonHelper.toJson(asset);
        return jsonRequest;
    }
}
