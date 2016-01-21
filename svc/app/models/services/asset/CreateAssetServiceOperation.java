package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import models.persistence.dao.impl.AssetDao;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class CreateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateAssetServiceOperation.class);

    private AssetDao dao;

    @Inject
    public CreateAssetServiceOperation(AssetDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
       return null;
    }
}
