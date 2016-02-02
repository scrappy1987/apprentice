package models.persistence.entities;

import javax.persistence.*;
import java.sql.Date;
import common.constants.WsdsConstants;

@Table(name = "dbo.T_ASSETS")
@Entity
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = WsdsConstants.ASSET_JSON_AO_SDM_LAST_TICKET_NUMBER_PROPERTY, nullable = false)
    private String aoSDMLastTicketNumber;

    @Column(name = WsdsConstants.ASSET_JSON_AO_FO_AO_NAME_PROPERTY, nullable = false)
    private int aoFOAoName;

    @ManyToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_LOCATION_PROPERTY)
    private Location location;

    @ManyToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_CONTACT_PROPERTY)
    private Contact contact;

    @Column(name = WsdsConstants.ASSET_JSON_ASSET_SERIAL_NO_PROPERTY, nullable = false)
    private String assetSerialNo;

    @Column(name = WsdsConstants.ASSET_JSON_ASSET_LABEL_PROPERTY, nullable = false)
    private String assetLabel;

    @Column(name = WsdsConstants.ASSET_JSON_ASSET_AO_CI_NAME_PROPERTY, nullable = false)
    private String assetAoCiName;

    @OneToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_PROPERTY_TYPE_PROPERTY)
    private PropertyType propertyType;

    @OneToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_STATUS_PROPERTY)
    private Status status;

    @Column(name = WsdsConstants.ASSET_JSON_ASSET_SEVERITY_NAME_PROPERTY, nullable = false)
    private String assetSeverityName;

    @Column(name = WsdsConstants.ASSET_JSON_ASSET_AO_SERVICE_SCOPE_PROPERTY, nullable = false)
    private String assetAoServiceScope;

    @ManyToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_MODEL_PROPERTY)
    private Model model;

    @OneToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_BRAND_PROPERTY)
    private Brand brand;

    @OneToOne
    @JoinColumn(name = WsdsConstants.ASSET_JSON_OPERATING_SYSTEM_PROPERTY)
    private OperatingSystem operatingSystem;

    @Column(name = WsdsConstants.ASSET_JSON_COMPUTER_TCP_IP_HOST_NAME_PROPERTY, nullable = false)
    private String computerTcpIpHostName;

    @Column(name = WsdsConstants.ASSET_JSON_AO_ATF_EXTERNAL_TOOL_PROPERTY, nullable = false)
    private String aoATFExternalTool;

    @Column(name = WsdsConstants.ASSET_JSON_AO_DELETE_PROPERTY, nullable = false)
    private String aoDelete;

    @Column(name = WsdsConstants.ASSET_JSON_SE_ASSIGNMENT_PROPERTY, nullable = false)
    private String seAssignment;

    @Column(name = WsdsConstants.ASSET_JSON_OBJECT_ACTION_PROPERTY, nullable = false)
    private String objectAction;

    @Column(name = WsdsConstants.ASSET_JSON_OBJECT_TYPE_PROPERTY, nullable = false)
    private String objectType;

    @Column(name = WsdsConstants.ASSET_JSON_AOD_ASSIGNMENT_PROPERTY, nullable = false)
    private String aodAssignment;

    @Column(name = WsdsConstants.ASSET_JSON_D_ASSIGNMENT_PROPERTY, nullable = false)
    private String dAssignment;

    public Asset() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAoSDMLastTicketNumber() {
        return aoSDMLastTicketNumber;
    }

    public void setAoSDMLastTicketNumber(String aoSDMLastTicketNumber) {
        this.aoSDMLastTicketNumber = aoSDMLastTicketNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getAssetSerialNo() {
        return assetSerialNo;
    }

    public void setAssetSerialNo(String assetSerialNo) {
        this.assetSerialNo = assetSerialNo;
    }

    public String getAssetLabel() {
        return assetLabel;
    }

    public void setAssetLabel(String assetLabel) {
        this.assetLabel = assetLabel;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getAoFOAoName() {
        return aoFOAoName;
    }

    public void setAoFOAoName(int aoFOAoName) {
        this.aoFOAoName = aoFOAoName;
    }

    public String getAssetAoCiName() {
        return assetAoCiName;
    }

    public void setAssetAoCiName(String assetAoCiName) {
        this.assetAoCiName = assetAoCiName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssetSeverityName() {
        return assetSeverityName;
    }

    public void setAssetSeverityName(String assetSeverityName) {
        this.assetSeverityName = assetSeverityName;
    }

    public String getAssetAoServiceScope() {
        return assetAoServiceScope;
    }

    public void setAssetAoServiceScope(String assetAoServiceScope) {
        this.assetAoServiceScope = assetAoServiceScope;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getComputerTcpIpHostName() {
        return computerTcpIpHostName;
    }

    public void setComputerTcpIpHostName(String computerTcpIpHostName) {
        this.computerTcpIpHostName = computerTcpIpHostName;
    }

    public String getAoATFExternalTool() {
        return aoATFExternalTool;
    }

    public void setAoATFExternalTool(String aoATFExternalTool) {
        this.aoATFExternalTool = aoATFExternalTool;
    }

    public String getAoDelete() {
        return aoDelete;
    }

    public void setAoDelete(String aoDelete) {
        this.aoDelete = aoDelete;
    }

    public String getSeAssignment() {
        return seAssignment;
    }

    public void setSeAssignment(String seAssignment) {
        this.seAssignment = seAssignment;
    }

    public String getObjectAction() {
        return objectAction;
    }

    public void setObjectAction(String objectAction) {
        this.objectAction = objectAction;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getAodAssignment() {
        return aodAssignment;
    }

    public void setAodAssignment(String aodAssignment) {
        this.aodAssignment = aodAssignment;
    }

    public String getdAssignment() {
        return dAssignment;
    }

    public void setdAssignment(String dAssignment) {
        this.dAssignment = dAssignment;
    }
}