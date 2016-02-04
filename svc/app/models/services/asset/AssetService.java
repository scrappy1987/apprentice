package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import common.util.json.play.JSONHelper;

import javax.inject.Inject;

public class AssetService extends Service
{
    private CreateAssetServiceOperation createAssetServiceOperation;

    private ListAssetServiceOperation listAssetServiceOperation;

    private UpdateAssetServiceOperation updateAssetServiceOperation;

    private DeleteAssetServiceOperation deleteAssetServiceOperation;

    private FindAssetServiceOperation findAssetServiceOperation;

    private ListAssetForContactServiceOperation listAssetForContactServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public AssetService(UnavailableServiceOperation unavailableServiceOperation,
                                CreateAssetServiceOperation createAssetServiceOperation,
                                ListAssetServiceOperation listAssetServiceOperation,
                                FindAssetServiceOperation findAssetServiceOperation,
                                ListAssetForContactServiceOperation listAssetForContactServiceOperation,
                                JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.createAssetServiceOperation = createAssetServiceOperation;

        this.listAssetServiceOperation = listAssetServiceOperation;

        this.findAssetServiceOperation = findAssetServiceOperation;

        this.listAssetForContactServiceOperation = listAssetForContactServiceOperation;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listAssetServiceOperation.execute(jsonHelper.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateAssetServiceOperation.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteAssetServiceOperation.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return findAssetServiceOperation.execute(identifier);
    }

    public JsonNode listForContact(JsonNode contactId)
    {
        return listAssetForContactServiceOperation.execute(contactId);
    }
}
