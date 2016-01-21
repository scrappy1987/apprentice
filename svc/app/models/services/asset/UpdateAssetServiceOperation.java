package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import models.persistence.dao.impl.AssetDao;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class UpdateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateAssetServiceOperation.class);

    private AssetDao dao;

    @Inject
    public UpdateAssetServiceOperation(AssetDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        return null;
    }
}
