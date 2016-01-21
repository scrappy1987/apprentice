package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
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
        return null;
    }
}
