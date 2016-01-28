package models.persistence.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "dbo.T_ASSETS")
@Entity
public class Asset
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "aoSDMLastTicketNumber", nullable = false)
    private String aoSDMLastTicketNumber;

    @Column(name = "location", nullable = false)
    @ManyToOne
    private Location location;

    @Column(name = "contact", nullable = false)
    @ManyToOne
    private Contact contact;

    @Column(name = "assetSerialNo", nullable = false)
    private String assetSerialNo;

    @Column(name = "assetLabel", nullable = false)
    private String assetLabel;

    @Column(name = "assetAoCiName", nullable = false)
    private String assetAoCiName;

    @Column(name = "propertyType")
    private PropertyType propertyType;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "assetSeverityName", nullable = false)
    private String assetSeverityName;

    @Column(name = "assetAoServiceScope", nullable = false)
    private String assetAoServiceScope;

    @Column(name = "model", nullable = false)
    @ManyToOne
    private Model model;

    @Column(name = "operatingSystem", nullable = false)
    private OperatingSystem operatingSystem;

    @Column(name = "computerTcpIpHostName", nullable = false)
    private String computerTcpIpHostName;

    @Column(name = "aoATFExternalTool", nullable = false)
    private String aoATFExternalTool;

    @Column(name = "aoDelete", nullable = false)
    private String aoDelete;

    @Column(name = "seAssignment", nullable = false)
    private String seAssignment;

    @Column(name = "objectAction", nullable = false)
    private String objectAction;

    @Column(name = "objectType", nullable = false)
    @ManyToOne
    private String objectType;

    @Column(name = "aodAssignment", nullable = false)
    private Date aodAssignment;

    @Column(name = "dAssignment", nullable = false)
    private Date dAssignment;

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

    public Date getAodAssignment() {
        return aodAssignment;
    }

    public void setAodAssignment(Date aodAssignment) {
        this.aodAssignment = aodAssignment;
    }

    public Date getdAssignment() {
        return dAssignment;
    }

    public void setdAssignment(Date dAssignment) {
        this.dAssignment = dAssignment;
    }
}