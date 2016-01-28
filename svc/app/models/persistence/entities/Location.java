package models.persistence.entities;

import javax.persistence.*;

@Table(name = "dbo.T_LOCATIONS")
@Entity
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "functionalOrg", nullable = false)
    private FunctionalOrganisation functionalOrg;

    @Column(name = "location", nullable = false)
    private int location;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "locationStatus", nullable = false)
    private String locationStatus;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @Column(name = "address3", nullable = false)
    private String address3;

    @Column(name = "address4", nullable = false)
    private String address4;

    @Column(name = "address5", nullable = false)
    private String address5;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zip", nullable = false)
    private String zip;
}