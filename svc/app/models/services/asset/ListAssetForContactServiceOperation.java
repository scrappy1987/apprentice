package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class ListAssetForContactServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListAssetForContactServiceOperation.class);

    private AssetDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListAssetForContactServiceOperation(AssetDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        return null;
    }
}
