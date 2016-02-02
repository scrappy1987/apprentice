package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.Asset;
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
        logger.info("In find asset method");
        String id = jsonRequest.path("id") + "";
        logger.info("id" + id);
        Asset asset = null;

        try
        {
            asset = dao.find(jsonRequest.path("id").asInt());
        }
        catch (Exception e)
        {
            logger.info(e.getMessage(), e);
        }

        logger.info("\n\nAsset: " + asset + "\n\n");

        return jsonHelper.toJson(dao.find(jsonRequest.path("id").asInt()));
    }
}
