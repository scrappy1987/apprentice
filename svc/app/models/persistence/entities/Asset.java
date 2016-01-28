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
}