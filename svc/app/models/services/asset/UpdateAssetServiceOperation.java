package models.services.asset;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.*;
import models.persistence.entities.*;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateAssetServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateAssetServiceOperation.class);

    private AssetDao assetDao;
    private LocationDao locationDao;
    private ContactDao contactDao;
    private PropertyTypeDao propertyTypeDao;
    private StatusDao statusDao;
    private ModelDao modelDao;
    private BrandDao brandDao;
    private OperatingSystemDao operatingSystemDao;

    @Inject
    public UpdateAssetServiceOperation(AssetDao assetDao,
                                       LocationDao locationDao,
                                       ContactDao contactDao,
                                       PropertyTypeDao propertyTypeDao,
                                       StatusDao statusDao,
                                       ModelDao modelDao,
                                       BrandDao brandDao,
                                       OperatingSystemDao operatingSystemDao)
    {
        this.assetDao = assetDao;
        this.locationDao = locationDao;
        this.contactDao = contactDao;
        this.propertyTypeDao = propertyTypeDao;
        this.statusDao = statusDao;
        this.modelDao = modelDao;
        this.brandDao = brandDao;
        this.operatingSystemDao = operatingSystemDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Asset asset = assetDao.find(jsonRequest.findPath("id").asInt());

        Location location = locationDao.find(jsonRequest.path("contact").path("location").path("id").asInt());
        Contact contact = contactDao.find(jsonRequest.path("contact").path("id").asInt());
        PropertyType propertyType = propertyTypeDao.find(jsonRequest.path("propertyType").path("id").asInt());
        Status status = statusDao.find(jsonRequest.path("status").path("id").asInt());
        Model model = modelDao.find(jsonRequest.path("model").path("id").asInt());
        Brand brand = brandDao.find(jsonRequest.path("model").path("brand").path("id").asInt());
        OperatingSystem operatingSystem = operatingSystemDao.find(jsonRequest.path("operatingSystem").path("id").asInt());

        Asset updatedAsset = changeAsset(asset, jsonRequest, location, contact, propertyType, status, model, brand, operatingSystem);

        assetDao.update(updatedAsset);

        return new JSONHelper().toJson(updatedAsset);
    }

    private Asset changeAsset(Asset asset, JsonNode jsonRequest, Location location, Contact contact, PropertyType propertyType, Status status, Model model, Brand brand, OperatingSystem operatingSystem)
    {

        asset.setAoFOAoName(jsonRequest.path(WsdsConstants.ASSET_JSON_AO_FO_AO_NAME_PROPERTY).asInt());
        asset.setAoATFExternalTool(jsonRequest.findPath(WsdsConstants.ASSET_JSON_AO_ATF_EXTERNAL_TOOL_PROPERTY).textValue());
        asset.setAodAssignment(jsonRequest.findPath(WsdsConstants.ASSET_JSON_AOD_ASSIGNMENT_PROPERTY).textValue());
        asset.setAoDelete(jsonRequest.findPath(WsdsConstants.ASSET_JSON_AO_DELETE_PROPERTY).textValue());
        asset.setAoSDMLastTicketNumber(jsonRequest.findPath(WsdsConstants.ASSET_JSON_AO_SDM_LAST_TICKET_NUMBER_PROPERTY).textValue());
        asset.setAssetAoCiName(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_AO_CI_NAME_PROPERTY).textValue());
        asset.setAssetAoServiceScope(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_AO_SERVICE_SCOPE_PROPERTY).textValue());
        asset.setAssetLabel(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_LABEL_PROPERTY).textValue());
        asset.setAssetSerialNo(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_SERIAL_NO_PROPERTY).textValue());
        asset.setAssetSeverityName(jsonRequest.findPath(WsdsConstants.ASSET_JSON_ASSET_SEVERITY_NAME_PROPERTY).textValue());
        asset.setComputerTcpIpHostName(jsonRequest.findPath(WsdsConstants.ASSET_JSON_COMPUTER_TCP_IP_HOST_NAME_PROPERTY).textValue());
        asset.setContact(contact);
        asset.setdAssignment(jsonRequest.findPath(WsdsConstants.ASSET_JSON_D_ASSIGNMENT_PROPERTY).textValue());
        asset.setLocation(location);
        asset.setModel(model);
        asset.setBrand(brand);
        asset.setObjectAction(jsonRequest.findPath(WsdsConstants.ASSET_JSON_OBJECT_ACTION_PROPERTY).textValue());
        asset.setObjectType(jsonRequest.findPath(WsdsConstants.ASSET_JSON_OBJECT_TYPE_PROPERTY).textValue());
        asset.setOperatingSystem(operatingSystem);
        asset.setPropertyType(propertyType);
        asset.setSeAssignment(jsonRequest.findPath(WsdsConstants.ASSET_JSON_SE_ASSIGNMENT_PROPERTY).textValue());
        asset.setStatus(status);
        asset.setdAssignment(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));

        return asset;
    }
}
