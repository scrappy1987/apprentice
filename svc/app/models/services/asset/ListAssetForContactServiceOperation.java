package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.AssetDao;
import models.persistence.dao.impl.ContactDao;
import models.persistence.entities.Asset;
import models.persistence.entities.Contact;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;
import java.util.List;

public class ListAssetForContactServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListAssetForContactServiceOperation.class);

    private AssetDao assetDao;

    private ContactDao contactDao;

    private JSONHelper jsonHelper;

    @Inject
    public ListAssetForContactServiceOperation(AssetDao assetDao, ContactDao contactDao, JSONHelper jsonHelper)
    {
        this.assetDao = assetDao;
        this.contactDao = contactDao;
        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        logger.info("******************In ListAssetClass**************");
        Contact contact = contactDao.find(jsonRequest.path("id").asInt());
        logger.info("contact: " + jsonHelper.toJson(contact));

        List<Asset> assets = assetDao.listForContact(contact);
        logger.info("Asset list: " +assets);
        return jsonHelper.toJson(assets);
    }
}
